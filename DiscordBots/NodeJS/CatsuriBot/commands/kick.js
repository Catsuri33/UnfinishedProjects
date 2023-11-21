const Discord = require('discord.js');

module.exports.run = async (bot, message, args) => {

    let kickedUser = message.guild.member(message.mentions.users.first() || message.guild.members.get(args[0]));
    let kickedReason = args.join(" ").slice(22);

    if(!kickedUser){

        return message.channel.send('❌ Error, the user does not exist !');

    }

    if(!message.member.hasPermission("KICK_MEMBERS")){

        return message.channel.send('❌ Error, you do not have permission to do this !');

    }

    if(kickedUser.hasPermission("KICK_MEMBERS")){

        return message.channel.send('❌ Error, this user can not be kick !');

    }

    let kickedEmbed = new Discord.RichEmbed()
      .setTitle('Kick')
      .setColor('#B22326')
      .addField('**User kicked : **', `${kickedUser} (ID : ${kickedUser.id})`)
      .addField('**User having kicked : **', `${message.author} (ID : ${message.author.id})`)
      .addField('**Channel : **', message.channel)
      .addField('**Reason of the kick : **', kickedReason)
      .setFooter('Copyright © 2018 - 2019 Catsuri33');

    let kickChannel = message.guild.channels.find(`name`, "logs");

    if(!kickedReason){

        return message.channel.send('❌ Error, please specify a reason !');

    } else {

    if(!kickChannel){

        return message.channel.send('❌ Error, the channel does not exist ! Please create a channel #logs !');

    } else {

        message.guild.member(kickedUser).send('You have been kick of **' + message.guild.name + '** for **' + kickedReason + '** !');
        message.delete();
        
        message.guild.member(kickedUser).kick(kickedReason);
        kickChannel.send(kickedEmbed);

    }

}


}

module.exports.help = {

    name: "kick"

}