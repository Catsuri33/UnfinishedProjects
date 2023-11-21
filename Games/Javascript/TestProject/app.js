var express = require('express');
var app = express();
var server = require('http').Server(app);

var currentDate = new Date();

const projectName = "TestApp";
const projectVersion = "1.0.0";

var logger = "[" + currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds() + "][" + projectName + "]";
var startTimeMillis = currentDate.getTime();

console.log(logger + " Starting the server...");

app.get('/', function(req, res){

    res.sendFile(__dirname + '/client/index.html');

});

app.use('/client', express.static(__dirname + '/client'));

server.listen(2000);

var endTimeMillis = currentDate.getTime();
var endTime = endTimeMillis - startTimeMillis;

console.log(logger + " Server started for " + projectName + ", version " + projectVersion + " in " + endTime + "ms !");


var Entity = function(){

    var self = {

        x:250,
        y:250,
        speedX:0,
        speedY:0,
        id:""

    }

    self.update = function(){

        self.updatePostion();

    }

    self.updatePostion = function(){

        self.x += self.speedX;
        self.y += self.speedY;

    }

    self.getDistance = function(point){

        return Math.sqrt(Math.pow(self.x - point.x, 2) + Math.pow(self.y - point.y, 2));

    }

    return self;

}

var socketList = {};
var Player = function(id){

    var self = Entity();
    self.id = id;
    self.number = "" + Math.floor(10 * Math.random());
    self.pressingRight = false;
    self.pressingLeft = false;
    self.pressingUp = false;
    self.pressingDown = false;
    self.pressingLeftMouseButton = false;
    self.mouseAngle = 0;
    self.maxSpeed = 10;

    var superUpdate = self.update;
    self.update = function(){

        self.updateSpeed();
        superUpdate();

        if(self.pressingLeftMouseButton){

            self.shootBullet(self.mouseAngle);

        }

    }

    self.shootBullet = function(angle){

        var bullet = Bullet(self.id, angle);
        bullet.x = self.x;
        bullet.y = self.y;

    }

    self.updateSpeed = function(){

        if(self.pressingRight){

            self.speedX = self.maxSpeed;

        }
        else if(self.pressingLeft){

            self.speedX = -self.maxSpeed;

        }
        else {

            self.speedX = 0;

        }

        if(self.pressingUp){

            self.speedY = -self.maxSpeed;

        }
        else if(self.pressingDown){

            self.speedY = self.maxSpeed;

        }
        else {

            self.speedY = 0;

        }

    }

    Player.list[id] = self;
    return self;

}

Player.list = {};


Player.onConnect = function(socket){

    var player = Player(socket.id);

    socket.on('keyPress', function(data){

        if(data.inputId === 'left'){

            player.pressingLeft = data.state;

        }
        if(data.inputId === 'right'){

            player.pressingRight = data.state;

        }
        if(data.inputId === 'up'){

            player.pressingUp = data.state;

        }
        if(data.inputId === 'down'){

            player.pressingDown = data.state;

        }
        if(data.inputId === 'mouseLeft'){

            player.pressingLeftMouseButton = data.state;

        }
        if(data.inputId === 'mouseAngle'){

            player.mouseAngle = data.state;

        }

    });

}

Player.onDisconnect = function(socket){

    delete Player.list[socket.id];

}

Player.update = function(){

    var pack = [];

    for(var i in Player.list){

        var player = Player.list[i];
        player.update();
        pack.push({

            x:player.x,
            y:player.y,
            number:player.number

        });

    }

    return pack;

}

var Bullet = function(parent, angle){

    var self = Entity();
    self.id = Math.random();
    self.speedX = Math.cos(angle / 180 * Math.PI) * 10;
    self.speedY = Math.sin(angle / 180 * Math.PI) * 10;
    self.parent = parent;
    self.timer = 0;
    self.toRemove = false;

    var superUpdate = self.update;
    self.update = function(){

        if(self.timer++ > 100){

            self.toRemove = true;

        }

        superUpdate();

        for(var i in Player.list){

            var player = Player.list[i];
            if(self.getDistance(player) < 32 && self.parent !== player.id){

                self.toRemove = true;

            }

        }

    }

    Bullet.list[self.id] = self;
    return self;

}

Bullet.list = {};

Bullet.update = function(){

    var pack = [];

    for(var i in Bullet.list){

        var bullet = Bullet.list[i];
        bullet.update();

        if(bullet.toRemove){

            delete Bullet.list[i];

        } else {

            pack.push({

                x:bullet.x,
                y:bullet.y
    
            });

        }

    }

    return pack;

}

var debug = true;
var io = require('socket.io')(server, {});
io.sockets.on('connection', function(socket){

    currentDate = new Date();
    logger = "[" + currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds() + "][" + projectName + "]";

    socket.id = Math.random();
    socketList[socket.id] = socket;

    socket.on('login', function(data){

        if(data.username === "Catsuri33" && data.password == "123456"){

            Player.onConnect(socket);
            socket.emit('loginResponse', {success:true});

        } else {

            socket.emit('loginResponse', {success:false});

        }

    });

    console.log(logger + " Connected to the socket.")

    socket.on('disconnect', function(){

        logger = "[" + currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds() + "][" + projectName + "]";

        delete socketList[socket.id];
        Player.onDisconnect(socket);

        console.log(logger + " Disconnected from the socket.")

    });

    socket.on('sendPlayerMessageToServer', function(data){

        var playerName = ("" + socket.id).slice(2, 7);

        for(var i in socketList){

            socketList[i].emit('addMessageToChat', playerName + ": " + data);

        }

    });

    socket.on('evalServer', function(data){

        if(!debug) return;

        try {

            var request = eval(data);

        } catch(e){

            request = e.message;

        }

        socket.emit('evalAnswer', request);

    });

});

setInterval(function(){

    var pack = {

        player:Player.update(),
        bullet:Bullet.update()

    }

    for(var i in socketList){

        var socket = socketList[i];
        socket.emit('newPositions', pack);

    }

},1000/25);