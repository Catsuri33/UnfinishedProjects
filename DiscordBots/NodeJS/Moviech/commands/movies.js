const { SlashCommandBuilder } = require("@discordjs/builders");
const { CommandInteraction, MessageEmbed } = require("discord.js");

module.exports = {

    data: new SlashCommandBuilder()
        .setName("movies")
        .setDescription("Show the avaible movies."),
    async execute(interaction){

        embed = new MessageEmbed()
            .setTitle("List of Movies")
            .setColor("#4834d4")
            .addField("2021", "- Arcane\n")

        return interaction.reply({ embeds: [ embed ] });

    }

}

async function findOneMovie(client, movieName){



}