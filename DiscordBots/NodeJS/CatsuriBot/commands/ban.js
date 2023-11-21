const Discord = require('discord.js');

module.exports.run = async (bot, message, args) => {

    let bannedUser = message.guild.member(message.mentions.users.first() || message.guild.members.get(args[0]));
        let bannedReason = args.join(" ").slice(22);

        if(!bannedUser){

            return message.channel.send('❌ Error, the user does not exist !');

        }

        if(!message.member.hasPermission("BAN_MEMBERS")){

            return message.channel.send('❌ Error, you do not have permission to do this !');

        }

        if(bannedUser.hasPermission("BAN_MEMBERS")){

            return message.channel.send('❌ Error, this user can not be ban !');

        }

        let bannedEmbed = new Discord.RichEmbed()
          .setTitle('Ban')
          .setColor('#CD1E22')
          .addField('**User banned : **', `${bannedUser} (ID : ${bannedUser.id})`)
          .addField('**User having banned : **', `${message.author} (ID : ${message.author.id})`)
          .addField('**Channel : **', message.channel)
          .addField('**Reason of the ban : **', bannedReason)
          .setFooter('Copyright © 2018 - 2019 Catsuri33');

        let banChannel = message.guild.channels.find(`name`, "logs");

        if(!bannedReason){

            return message.channel.send('❌ Error, please specify a reason !');

        } else {

        if(!banChannel){

            return message.channel.send('❌ Error, the channel does not exist ! Please create a channel #logs !');

        } else {

            message.guild.member(bannedUser).send('You have been ban of **' + message.guild.name + '** for **' + bannedReason + '** !');
            message.delete();
            message.guild.member(bannedUser).ban(bannedReason);
            banChannel.send(bannedEmbed);

        }

    }

}

module.exports.help = {

    name: "ban"

}