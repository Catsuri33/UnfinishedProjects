const Discord = require('discord.js');

module.exports.run = async (bot, message, args) => {

    let reportedUser = message.guild.member(message.mentions.users.first() || message.guild.members.get(args[0]));
        let reportReason = args.join(" ").slice(22);

        if(!reportedUser){

            return message.channel.send('❌ Error, the user does not exist !');

        }
        
        let reportEmbed = new Discord.RichEmbed()
          .setTitle('Report')
          .setColor('#d63031')
          .addField('**User reported : **', `${reportedUser} (ID : ${reportedUser.id})`)
          .addField('**User having reported : **', `${message.author} (ID : ${message.author.id})`)
          .addField('**Channel : **', message.channel)
          .addField('**Reason of the report : **', reportReason)
          .setFooter('Copyright © 2018 - 2019 Catsuri33');

        let reportChannel = message.guild.channels.find(`name`, "logs");

        if(!reportReason){

            return message.channel.send('❌ Error, please specify a reason !');

        } else {

        if(!reportChannel){

            return message.channel.send('❌ Error, the channel does not exist ! Please create a channel #logs !');

        } else {

            message.delete();
            reportChannel.send(reportEmbed);

        }

    }

}

module.exports.help = {

    name: "report"

}