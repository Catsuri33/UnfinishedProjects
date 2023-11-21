const Discord = require('discord.js');

module.exports.run = async (bot, message, args) => {

    let botIcon = bot.user.displayAvatarURL;
        let embed = new Discord.RichEmbed()
          .setTitle('Help')
          .setColor('#2ecc71')
          .addField('General : ', `**- d!help :** Show help.\n**- d!botinfos :** See the information of the bot. \n**- d!serverinfos : ** See the informations of the server.`)
          .addField('Fun : ', `**- Empty**`)
          .addField('Moderation : ', `**- d!report [User] [Reason] : ** Report a user. \n**- d!kick [User] [Reason] : ** Kick a user. \n**- d!ban [User] [Reason] : ** Ban a user. \n**- d!mute [User] [Duration in seconds] : ** Mute a user.`)
          .setFooter('Copyright © 2018 - 2019 Catsuri33');

        
        return message.channel.send(embed);

}

module.exports.help = {

    name: "help"

}