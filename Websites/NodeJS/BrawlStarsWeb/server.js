const express = require('express');
const mongoose = require('mongoose');
const ejs = require('ejs');
const bodyParser = require('body-parser');
const { check, validationResult } = require('express-validator');
const { Token, BrawlStars } = require('supercell-apis');

const app = express();
const urlEncodedParser = bodyParser.urlencoded({ extended: false })

// Server setup
app.set('view engine', 'ejs');
app.use(express.static(__dirname + '/public'));

app.get('/', (req, res) => {

    res.render(__dirname + '/public/html/english/index_en', {

        

    });

});

app.get('/login/supercell', (req, res) => {

    res.render(__dirname + '/public/html/english/supercell_login', {

        errorMessage: ""

    });

});

app.post('/login/supercell', urlEncodedParser, async (req, res) => {

    const token = await new Token('brawlstars', 'EMAIL', 'TOKEN').init();
    const Bs = new BrawlStars(token);

    const playerData = await Bs.player(req.body.supercelltag);
    console.log(playerData);

    if(playerData.status == 404){

        res.render(__dirname + '/public/html/english/supercell_login', {

            errorMessage: "Tag invalid !"
    
        });
        return;

    }

    res.redirect('/game/home');

});

app.get('/game/home', (req, res) => {

    res.render(__dirname + '/public/html/english/game_home', {

       

    });

});

app.get('/fr/', (req, res) => {

    res.render(__dirname + '/public/html/french/index_fr', {

        

    });

});

app.get('/login/supercell/fr', (req, res) => {

    res.render(__dirname + '/public/html/french/supercell_login', {

        

    });

});

app.get('/es/', (req, res) => {

    res.render(__dirname + '/public/html/spanish/index_es', {

        

    });

});

app.get('/login/supercell/es', (req, res) => {

    res.render(__dirname + '/public/html/spanish/supercell_login', {

        

    });

});

app.listen('3000', function() {

    console.log('[ BrawlStarsWeb ] Server is running !');

});