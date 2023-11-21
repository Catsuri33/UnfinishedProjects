const express = require("express");

const router = express.Router();

const User = require("../models/User");

// GET All the Users
router.get("/", async function(req, res){

    try {

        var docsNb = 0

        await User.countDocuments({}, function(err, count){

            docsNb = count

        });

        var users = await User.find().lean();

        for(i = 0; i < docsNb; i++){

            var currentObj = users[i];
            delete currentObj.first_name;
            delete currentObj.last_name;
            delete currentObj.email;
            delete currentObj.email_state;
            delete currentObj.password;
            delete currentObj.account_state;
            delete currentObj.ban_time;
            delete currentObj.ban_reason;
            delete currentObj.ban_author;
            delete currentObj.ban_total;
            delete currentObj.email_code;

        }

        res.json(users);

    } catch(err){

        res.json({ message: err.message });

    }

});

// GET a Specific User by Its Username
router.get("/:username", async function(req, res){

    try {

        var user = await User.find({ "nickname": req.params.username }).lean();

        var currentObj = user[0];
        delete currentObj.first_name;
        delete currentObj.last_name;
        delete currentObj.email;
        delete currentObj.email_state;
        delete currentObj.password;
        delete currentObj.account_state;
        delete currentObj.ban_time;
        delete currentObj.ban_reason;
        delete currentObj.ban_author;
        delete currentObj.ban_total;
        delete currentObj.email_code;

        res.json(user);

    } catch(err){

        if(err.message == "Cannot convert undefined or null to object"){

            res.json({ message: "User not found" });

        } else {

            res.json({ message: err.message });

        }

    }

});

// POST New User
//router.post("/", async function(req, res){

    //var idNb = 0

    //await User.countDocuments({}, function(err, count){

        //idNb = count + 1

    //});

    //const user = new User({

        //id: idNb,
        //nickname: req.body.nickname,
        //first_name: req.body.first_name,
        //last_name: req.body.last_name,
        //email: req.body.email,
        //password: req.body.password

    //});

    //try {

        //const savedUser = await user.save();
        //res.json(savedUser);

    //} catch(err){

        //res.json({ message: err.message });

    //}

//});

module.exports = router;