const Discord = require('discord.js');
const ms = require('ms');

module.exports.run = async (bot, message, args) => {

    let mutedUser = message.guild.member(message.mentions.users.first() || message.guild.members.get(args[0]));
    let muteChannel = message.guild.channels.find(`name`, "logs");

    if(!muteChannel){

        return message.channel.send('❌ Error, the channel does not exist ! Please create a channel #logs !');

    }

    if(!mutedUser){

        return message.channel.send('❌ Error, the user does not exist !');

    }

    if(!message.member.hasPermission("MANAGE_MESSAGES")){

        return message.channel.send('❌ Error, you do not have permission to do this !');

    }

    if(mutedUser.hasPermission("MANAGE_MESSAGES")){

        return message.channel.send('❌ Error, this user can not be mute !');

    }

    let muteRole = message.guild.roles.find(`name`, `Muted`);

    // Creation du rôle
    if(!muteRole){

        try{

            muteRole = await message.guild.createRole({

                name: 'Muted',
                color: '#2d3436',
                permissions: []

            });

            message.guild.channels.forEach(async (channel, id) => {

                await channel.overwritePermissions(muteRole, {

                    SEND_MESSAGES: false,
                    ADD_REACTIONS: false,
                    CHANGE_NICKNAME: false,
                    SPEAK: false

                });

            });

        } catch (e) {

            console.log(e.stack);

        }

    }

    let muteTime = args[1];

    if(!muteTime){
        
        return message.channel.send('❌ Error, you must specify the duration of the mute !');

    }

    let mutedEmbed = new Discord.RichEmbed()
      .setTitle('Mute')
      .setColor('#B22326')
      .addField('**User mute : **', `${mutedUser} (ID : ${mutedUser.id})`)
      .addField('**User having mute : **', `${message.author} (ID : ${message.author.id})`)
      .addField('**Channel : **', message.channel)
      .addField('**Duration of the mute : **', `${ms(ms(muteTime))}`)
      .setFooter('Copyright © 2018 - 2019 Catsuri33');

    await mutedUser.addRole(muteRole.id);
    message.channel.send(`<@${mutedUser.id}> is mute for ${ms(ms(muteTime))}.`);
    muteChannel.send(mutedEmbed);

    setTimeout(() => {

        mutedUser.removeRole(muteRole.id);
        message.channel.send(`<@${mutedUser.id}> is no longer mute.`);

    }, ms(muteTime))
};

module.exports.help = {

    name: "mute"

};