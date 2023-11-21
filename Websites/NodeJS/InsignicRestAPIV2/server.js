const express = require("express");
const mongoose = require("mongoose");
const ejs = require("ejs");
const http = require('http');
const https = require('https');

const app = express();
const port = 3000;

app.set('view engine', 'ejs');
app.use(express.static(__dirname + '/public'));
app.use(express.json({ limit: "100mb" }));

// Import Routes
const authRouter = require("./routes/auth");
const usersRouter = require("./routes/users");

// Setup Routes
app.use("/v2/auth", authRouter);
app.use("/v2/users", usersRouter);

// Routes
app.get("/", function(req, res){

    res.redirect("/v2");

});

app.get("/v1", function(req, res){

    res.render(__dirname + '/public/html/v1', {

        

    });

});

app.get("/v2", function(req, res){

    res.render(__dirname + '/public/html/v2', {

        

    });

});

// Connect MongoDB
mongoose.connect("URI", { useNewUrlParser: true, useUnifiedTopology: true })
.then(console.log("Connected to MongoDB InsignicAccounts Database."));

// Start server
var httpServer = http.createServer(app);
//var httpsServer = https.createServer(credentials, app);

httpServer.listen(8080, () => {

    console.log(`InsignicAPI V2 started.`);

});
//httpsServer.listen(8443);

//app.listen(port, () => {

    //console.log(`InsignicAPI V2 started on port ${port}.`);

//});