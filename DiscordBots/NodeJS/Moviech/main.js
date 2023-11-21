require("dotenv").config();
const fs = require("fs");
const { Client, Collection, Intents } = require("discord.js");
const { MongoClient } = require("mongodb");

const handleCommand = require("./helpers/commands");

const client = new Client({ intents: [Intents.FLAGS.GUILDS] });
client.commands = new Collection();
const commandFiles = fs.readdirSync("./commands").filter(file => file.endsWith(".js"));

for(const file of commandFiles){

    const command = require(`./commands/${file}`);
    client.commands.set(command.data.name, command);

}

client.on("ready", () => {

  console.log(`Logged in as ${client.user.tag}!`);

});

client.on("interactionCreate", async interaction => {

    if(interaction.isCommand()) handleCommand(client, interaction);

});

// Database
async function connectDatabase(){

  const uri = "URI";
  const client = new MongoClient(uri);

  try {

    await client.connect();
    console.log("Database connected !");

  } catch(err){

    console.log(err);

  } finally {

    await client.close();

  }

}

async function findAMovieByName(client, movieName){

  client.db("Database01").collection("movies");

}

connectDatabase();
client.login(process.env.DISCORD_APP_TOKEN);