const fs = require('fs');
const { REST } = require('@discordjs/rest');
const { Routes } = require('discord-api-types/v9');

const commands = [];
const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'));

for (const file of commandFiles) {

    const command = require(`./commands/${file}`);
    commands.push(command.data.toJSON());

}

const rest = new REST({ version: '9' }).setToken("OTE0NTYyMDEzODgyMTAxODQw.YaO2Pw._uChB5lbC2geT0Kw9tVjyb1kflo");

(async () => {

    try {

        await rest.put(Routes.applicationGuildCommands("914562013882101840", "674595931345125387"), { body: commands });

        console.log("Commands have been added !")

    } catch (error) {

        console.error(error);

    }

})();