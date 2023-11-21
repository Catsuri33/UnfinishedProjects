const express = require("express");
const jwt = require("jsonwebtoken");
const bcrypt = require("bcrypt");

const API = require("../models/API");
const User = require("../models/User");

// Setup express server router.
const router = express.Router();

// On Post
router.post("/", async (req, res) => {

    // Get user from the database
    let user_api = await API.find({ "email": req.body.email }).lean();
    let user = await User.find({ "email": req.body.email }).lean();

    var currentAPIObj = user_api[0];
    var currentUserObj = user[0];

    if(!user_api){

        res.send({

            ok: false,
            result: "Invalid email or password !"
    
        });
        return;

    }

    // Compare password with password in database.
    const valid = await bcrypt.compare(req.body.password, currentUserObj.password);
    if(!valid){

        res.send({

            ok: false,
            result: "Invalid email or password !"
    
        });
        return;

    }

    const token = jwt.sign({

        id: currentAPIObj._id,
        roles: currentAPIObj.roles,

    }, "jwtPrivateKey", { expiresIn: "15m" });

    res.send({

        ok: true,
        token: token

    });

});

// Export the router
module.exports = router;