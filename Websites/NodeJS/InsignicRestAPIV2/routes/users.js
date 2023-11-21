const express = require("express");
const bcrypt = require("bcrypt");

// Import middlewares
const auth = require("../middleware/auth");
const User = require("../models/User");
const { admin, editor, viewer } = require("../middleware/roles");

// Setup the router for express
const router = express.Router();

// GET All the Users
router.get("/", [auth, viewer], async (req, res) => {

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

        res.send({

            ok: true,
            result: users
    
        });

    } catch(err){

        res.send({

            ok: false,
            result: err.message
    
        });

    }

});

// GET a Specific User by Its Username [EDITOR]
router.get("/admin/:username", [auth, editor], async (req, res) => {

    try {

        var user = await User.find({ "nickname": req.params.username }).lean();

        res.send({

            ok: true,
            result: user
    
        });

    } catch(err){

        if(err.message == "Cannot convert undefined or null to object"){

            res.send({

                ok: false,
                result: "User not found"
        
            });

        } else {

            res.send({

                ok: false,
                result: err.message
        
            });

        }

    }

});

// GET a Specific User by Its Username [VIEWER]
router.get("/:username", [auth, viewer], async (req, res) => {

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

        res.send({

            ok: true,
            result: user
    
        });

    } catch(err){

        if(err.message == "Cannot convert undefined or null to object"){

            res.send({

                ok: false,
                result: "User not found"
        
            });

        } else {

            res.send({

                ok: false,
                result: err.message
        
            });

        }

    }

});

// POST New User
router.post("/", [auth, editor], async (req, res) => {

    var idNb = 0

    await User.countDocuments({}, function(err, count){

        idNb = count + 1

    });

    const salt = await bcrypt.genSalt(15);
    const hashedPassword = (await bcrypt.hash(req.body.password, salt));

    const user = new User({

        id: idNb,
        nickname: req.body.nickname,
        first_name: req.body.first_name,
        last_name: req.body.last_name,
        email: req.body.email,
        password: hashedPassword

    });

    try {

        const savedUser = await user.save();
        res.status(200).send({

            ok: true,
            result: savedUser
    
        });

    } catch(err){

        res.status(200).send({

            ok: false,
            result: err.message
    
        });

    }

});

// PATCH a New Value in a User
router.patch("/:username", [auth, editor], async (req, res) => {

    try {

        var user = await User.updateOne(
            { "nickname": req.params.username }, 
            { $set: { id: req.body.id, nickname: req.body.nickname, first_name: req.body.first_name, last_name: req.body.last_name, email: req.body.email, email_state: req.body.email_state, password: req.body.password, rank: req.body.rank, level: req.body.level, xp: req.body.xp, insicoins: req.body.insicoins, discord_id: req.body.discord_id, account_state: req.body.account_state, ban_time: req.body.ban_time, ban_reason: req.body.ban_reason, ban_author: req.body.ban_author, ban_total: req.body.ban_total, creation_date: req.body.creation_date, email_code: req.body.email_code, minecraft_uuid: req.body.minecraft_uuid, activity: req.body.activity, state: req.body.state } }
        );

        res.status(200).send({

            ok: true,
            result: user
    
        });

    } catch(err){

        if(err.message == "Cannot convert undefined or null to object"){

            res.send({

                ok: false,
                result: "User not found"
        
            });

        } else {

            res.send({

                ok: false,
                result: err.message
        
            });

        }

    }

});

// DELETE A User by Its Username
router.delete("/:username", [auth, admin], async (req, res) => {

    try {

        var user = await User.find({ "nickname": req.params.username }).deleteOne();

        res.status(200).send({

            ok: true,
            result: "User deleted"
    
        });

    } catch(err){

        if(err.message == "Cannot convert undefined or null to object"){

            res.send({

                ok: false,
                result: "User not found"
        
            });

        } else {

            res.send({

                ok: false,
                result: err.message
        
            });

        }

    }
    
});

// Export the router
module.exports = router;