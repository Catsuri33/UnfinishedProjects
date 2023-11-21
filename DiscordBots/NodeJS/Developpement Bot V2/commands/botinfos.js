const Discord = require('discord.js');

module.exports.run = async (bot, message, args) => {

    let botIcon = bot.user.displayAvatarURL;
        let embed = new Discord.RichEmbed()
          .setTitle('Bot Informations')
          .setColor('#e74c3c')
          .setThumbnail(botIcon)
          .addField('Name of the bot : ', bot.user.username)
          .addField('Tag : ', bot.user.tag)
          .addField('ID : ', bot.user.id)
          .addField('Created the : ', bot.user.createdAt)
          .addField('Invitation : ', 'https://discordapp.com/oauth2/authorize?client_id=447858939137097739&scope=bot&permissions=2146958847')
          .addField('Server of the bot : ', 'https://discord.gg/')
          .setFooter('Copyright © 2018 - 2019 Catsuri33');

        
        return message.channel.send(embed);

}

module.exports.help = {

    name: "botinfos"

}