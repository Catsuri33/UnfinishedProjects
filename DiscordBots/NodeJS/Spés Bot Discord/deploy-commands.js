require("dotenv").config();
const fs = require('fs');
const { REST } = require('@discordjs/rest');
const { Routes } = require('discord-api-types/v9');

const commands = [];
const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'));

for (const file of commandFiles) {
	const command = require(`./commands/${file}`);
	commands.push(command.data.toJSON());
}

const token = process.env.DISCORD_TOKEN;
const rest = new REST({ version: '9' }).setToken(token);

rest.put(Routes.applicationGuildCommands(process.env.DISCORD_ID, "891244802555932712"), { body: commands })
	.then(() => console.log('Successfully registered application commands.'))
	.catch(console.error);