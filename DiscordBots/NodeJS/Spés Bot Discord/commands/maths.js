const { SlashCommandBuilder } = require('@discordjs/builders');
const { MessageEmbed } = require('discord.js');
const math = require("mathjs");

module.exports = {
	data: new SlashCommandBuilder()
		.setName("maths")
		.setDescription("Renvoyer la réponse au calcul fournis.")
        .addStringOption(option => option.setName("calcul").setDescription("Entrez le calcul.")),
	async execute(interaction) {

        let calculRep = interaction.options.get("calcul");

        if(calculRep === null){

            return interaction.reply("Erreur, veuillez spécifier le calcul en argument !");

        }

        let calcul = calculRep.value;
        let rep = 0

        try {

            rep = math.evaluate(calcul);

        } catch(err){

            return interaction.reply("Erreur, votre calcul n'est pas valide !");

        }

        embed = new MessageEmbed()
            .setTitle("Résultat du calcul")
            .setColor("#3498db")
            .addField("Calcul", calcul)
            .addField("Résultat", rep.toString())

		return interaction.reply({ embeds: [ embed ] });

	},
};