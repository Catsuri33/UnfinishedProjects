const { SlashCommandBuilder } = require('@discordjs/builders');
const { MessageEmbed } = require('discord.js');

module.exports = {
	data: new SlashCommandBuilder()
		.setName("help")
		.setDescription("Afficher toutes les commandes."),
	async execute(interaction) {

        embed = new MessageEmbed()
            .setTitle("Commandes")
            .setColor("#2ecc71")
            .addField("**Générales**", "- /help : Afficher la liste des commandes.")
            .addField("**Utiles**", "- /maths <Calcul> : Effectuer un calcul.")
            .addField("**Modération**", "- /clear <Nombre> : Supprimer un certain nombre de messages.")

		return interaction.reply({ embeds: [ embed ] });

	},
};