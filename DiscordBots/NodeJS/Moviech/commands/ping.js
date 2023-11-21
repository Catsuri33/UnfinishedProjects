const { SlashCommandBuilder } = require("@discordjs/builders");
const { CommandInteraction } = require("discord.js");

module.exports = {

    data: new SlashCommandBuilder()
        .setName("ping")
        .setDescription("Send the ping of the bot."),
    async execute(interaction){

        await interaction.reply("Pong !");

        const message = await interaction.fetchReply();

        return interaction.editReply(`Bot ping: ${message.createdTimestamp - interaction.createdTimestamp} ms\nYour ping: ${interaction.client.ws.ping} ms`);

    }

}