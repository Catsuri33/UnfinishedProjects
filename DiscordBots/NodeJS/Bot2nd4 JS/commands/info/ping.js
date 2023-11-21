module.exports = {

    name: "ping",
    category: "info",
    description: "Obtenir la latence du bot et de l'API.",
    run: async (client, message, args) => {

        const msg = await message.channel.send("Calcul du ping en cours...");

        msg.edit(`La latence du bot est de ${Math.floor(msg.createdTimestamp - message.createdAt)}ms \nLa latence de l'API est de ${Math.round(client.ws.ping)}ms`);

    }

}