const express = require("express");
const mongoose = require("mongoose");
const dotenv = require("dotenv");
const cors = require("cors");
const bodyParser = require("body-parser");
const ejs = require("ejs");

const app = express();

app.set('view engine', 'ejs');
app.use(express.static(__dirname + '/public'));
app.use(bodyParser.json());

// Import Routes
const usersRoute = require("./routes/users");
app.use("/users", usersRoute);

// Routes
app.get("/", function(req, res){

    res.render(__dirname + '/public/html/index', {

        

    });

});

// Connect MongoDB
mongoose.connect("URI", { useNewUrlParser: true, useUnifiedTopology: true })
.then(console.log("Connected to MongoDB Database."));

// Start server
app.listen(3001, function(){

    console.log("InsignicRestAPI started.");

});