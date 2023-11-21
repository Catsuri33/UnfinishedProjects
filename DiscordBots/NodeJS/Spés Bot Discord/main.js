require("dotenv").config();
const { Client, Intents, Collection } = require('discord.js');
const fs = require("fs");

const client = new Client({ intents: [
  Intents.FLAGS.GUILDS, 
  Intents.FLAGS.GUILD_MESSAGES,
  Intents.FLAGS.DIRECT_MESSAGES
] 

});

// Get commands
client.commands = new Collection();
const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'));

for(const file of commandFiles) {

	const command = require(`./commands/${file}`);
	client.commands.set(command.data.name, command);

}

client.on('ready', () => {

  client.user.setPresence({ activities: [{ name: "aider les élèves." }] });

  console.log(`Logged in as ${client.user.tag} !`);

});

client.on('interactionCreate', async interaction => {

	if(!interaction.isCommand()) return;

	const command = client.commands.get(interaction.commandName);

	if(!command) return;

	try {

		await command.execute(interaction);

	} catch (error) {

		console.error(error);

	}

});

client.login(process.env.DISCORD_TOKEN);