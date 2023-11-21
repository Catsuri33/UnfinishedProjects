const mongoose = require("mongoose");

const UsersSchema = mongoose.Schema({

    id: {

        type: Number,
        required: true

    },
    nickname: {

        type: String,
        required: true

    },
    first_name: {

        type: String,
        required: true

    },
    last_name: {

        type: String,
        required: true

    },
    email: {

        type: String,
        required: true

    },
    email_state: {

        type: Number,
        default: -1

    },
    password: {

        type: String,
        required: true

    },
    rank: {

        type: String,
        default: "User"

    },
    level: {

        type: Number,
        default: 0

    },
    xp: {

        type: Number,
        default: 0

    },
    insicoins: {

        type: Number,
        default: 0.0

    },
    discord_id: {

        type: String,
        default: ""

    },
    account_state: {

        type: Number,
        default: 0

    },
    ban_time: {

        type: Number,
        default: 0

    },
    ban_reason: {

        type: String,
        default: ""

    },
    ban_author: {

        type: String,
        default: ""

    },
    ban_total: {

        type: Number,
        default: 0

    },
    creation_date: {

        type: Date,
        default: Date.now

    },
    email_code: {

        type: String,
        default: ""

    },
    minecraft_uuid: {

        type: String,
        default: ""

    },
    activity: {

        type: String,
        default: ""

    },
    state: {

        type: String,
        default: "offline"

    }

}, { collection: "users" });

module.exports = mongoose.model("User", UsersSchema);