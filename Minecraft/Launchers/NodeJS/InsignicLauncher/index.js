const {app, BrowserWindow, ipcMain} = require('electron');
const { Client, Authenticator } = require('minecraft-launcher-core');
const launcher = new Client();

var auth;

function createWindow (){

  const mainWindow = new BrowserWindow({

    width: 800,
    height: 600,
    title: "InsignicClient",
    webPreferences: {

        nodeIntegration: true

    }

  });

  mainWindow.loadFile('index.html');

}

app.whenReady().then(() => {

  createWindow();
  
  app.on('activate', function () {

    if (BrowserWindow.getAllWindows().length === 0) createWindow();

  });

});

app.on('window-all-closed', function (){
  
  if (process.platform !== 'darwin') app.quit();

});

ipcMain.on('login', (event, value) => {

    Authenticator.getAuth(value.username, value.password).then((val) => {

        auth = Authenticator.getAuth(value.username, value.password);
        launchGame();

    }).catch((err) => {

        event.sender.send("err", "Identifiants Invalides !");

    });

});

function launchGame(){

    let opts = {

        clientPackage: null,
        authorization: auth,
        root: "C:/Users/user/AppData/Roaming/.minecraft",
        version: {

            number: "1.15.2",
            type: "release"

        },
        memory: {

            max: "2048",
            min: "1024"

        }

    }
     
    launcher.launch(opts);
     
    launcher.on('debug', (e) => console.log(e));
    launcher.on('data', (e) => console.log(e));

}