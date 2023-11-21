module.exports = {

    name: "calculer",
    category: "utils",
    description: "Obtenir le résultat d'un calcul.",
    run: async (client, message, args) => {

        if(!args[0]) return message.channel.send("Erreur, vous devez spécifier un calcul à effectuer !");

        let response;
        try {

            resp = math.evaluate(args.join(' '));


        } catch(e){

            return message.channel.send("Erreur, vous devez spécifier un calcul valide !");

        }

        const embed = new Discord.RichEmbed()
            .setColor("#2980b9")
            .setTitle("Résultat Calcul")
            .addField("Calcul", `${args.join(' ')}`)
            .addField("Résultat", `${response}`)

        message.channel.send(embed);

    }

}