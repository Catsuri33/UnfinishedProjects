const { SlashCommandBuilder } = require('@discordjs/builders');
const ms = require("ms");

module.exports = {
	data: new SlashCommandBuilder()
		.setName("clear")
		.setDescription("Nettoyer un certain nombre de messages du channel.")
        .setDefaultPermission(false)
        .addStringOption(option => option.setName("nombre").setDescription("Entrez le nombre de messages à supprimer.")),
	async execute(interaction, client) {

        const command = client.commands.get(interaction.commandName);

        if(command.permission){

            const authorPerms = interaction.channel.permissionsFor(interaction.member);
            
            if(!authorPerms || !authorPerms.has(command.permission)){

                return interaction.reply("Erreur, vous n'avez pas la permission d'utiliser cette commande !");

            }

        }

        const amountRep = interaction.options.get("nombre");
        const amount = parseInt(amountRep.value);

        if(!amount){

            return interaction.reply("Erreur, veuillez spécifier le nombre de messages à supprimer.");

        }

        if(amount > 100){

            return interaction.reply("Erreur, le nombre maximum est 100 !");

        }

        const messages = await interaction.channel.messages.fetch({

            limit: amount + 1,

        });

        const filtered = messages.filter((msg) => Date.now() - msg.createdTimestamp < ms("14 days"));

        await interaction.channel.bulkDelete(filtered);

		interaction.reply(`${filtered.size - 1} messages ont étés supprimés !`);

	},
};