const mongoose = require("mongoose");

const APISchema = mongoose.Schema({

    email: {

        type: String,
        required: true

    },
    roles: {

        type: Array,
        required: true

    }

}, { collection: "users_api" });

module.exports = mongoose.model("API", APISchema);