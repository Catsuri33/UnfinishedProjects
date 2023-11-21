const Discord = require('discord.js');

module.exports.run = async (bot, message, args) => {

    let serverIcon = message.guild.iconURL;
        let embed = new Discord.RichEmbed()
          .setTitle('Server Informations')
          .setColor('#48dbfb')
          .setThumbnail(serverIcon)
          .addField('Name of the server : ', message.guild.name)
          .addField('Server ID : ', message.guild.id)
          .addField('Owner : ', message.guild.owner)
          .addField('Total number of members : ', message.guild.memberCount)
          .addField('AFK Channel : ', message.guild.afkChannel)
          .addField('Region : ', message.guild.region)
          .addField('Created the : ', message.guild.createdAt)
          .addField('You have joined the : ', message.member.joinedAt)
          .setFooter('Copyright © 2018 - 2019 Catsuri33');

        
        return message.channel.send(embed);

}

module.exports.help = {

    name: "serverinfos"

}