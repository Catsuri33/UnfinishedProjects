const express = require('express');
const mongoose = require('mongoose');
const ejs = require('ejs')
const fetch = require('node-fetch');
const bodyParser = require('body-parser');
const bcrypt = require('bcrypt');
const app = express();

var countTotalViews = 0;

// Server setup
app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(__dirname + '/public'));

mongoose.connect('URI');

const signUpSchema = {

    firstname: String,
    lastname: String,
    email: String,
    password: String,
    verifypassword: String,
    rank: String,
    signup_date: Date

}

const usersDB = mongoose.model('users', signUpSchema);

app.get('/', (req, res) => {

    res.render(__dirname + '/public/html/index', {

        

    });

});

app.get('/equipes', function(req, res) {

    res.render(__dirname + '/public/html/equipes', {

        

    });

});

app.get('/contact', function(req, res) {

    res.render(__dirname + '/public/html/contact', {

        

    });

});

app.get('/inscription', function(req, res) {

    //updateTotalVisistsCount();

    res.render(__dirname + '/public/html/inscription', {

        //totalViews: countTotalViews
        errorMessage: ""

    });

});

app.get('/connexion', function(req, res) {

    res.render(__dirname + '/public/html/connexion', {

        errorMessage: ""

    });

});

app.get('/profil', function(req, res) {

    res.render(__dirname + '/public/html/profil', {

        

    });

});

app.post('/inscription', async function(req, res) {

    let update = new usersDB({

        firstname: req.body.firstname,
        lastname: req.body.lastname,
        email: req.body.email,
        password: req.body.password,
        rank: "Membre",
        signup_date: Date.now()

    });

    var query = usersDB.find({}).select({ "name": update.email, "_id": 0});

    query.exec(function (err, someValue) {

        if (err) return next(err);
        console.log(someValue);

    });

    if(update.password != req.body.verifypassword){

        res.render(__dirname + '/public/html/inscription', {

            errorMessage: "Erreur, les mots de passes ne correspondent pas !"
    
        });

        return;

    }

    hashedPassword = await bcrypt.hash(req.body.password, 10);
    update.password = hashedPassword;

    update.save();
    res.redirect('/profil');

});

app.post('/connexion', async function(req, res) {

    

    res.redirect('/profil');

});

app.listen('3000', function() {

    console.log('[ SBL ] Server is running !');

});

// Counters
function updateTotalVisistsCount(){

    fetch('https://api.countapi.xyz/update/sambasketlesparre-totalviews/281f2a64-7d09-4c2f-9db7-914ee821bed7/?amount=1')
        .then(res => res.json())
        .then(res => {

            countTotalViews = res.value;

    });

}