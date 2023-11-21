//                               //
//    TheHaraMC Bot Discord      //
//                               //
//     Author: Catsuri33         //
//     Created: 10/08/19         //
//     Updated: 10/08/19         //
//                               //

const Discord = require('discord.js');
const config = require('./config.json');

const bot = new Discord.Client({disableEveryone: true});

var d = new Date();
hours = d.getHours();
minutes = d.getMinutes();
seconds = d.getSeconds();


bot.on('ready', async () => {

    let statuses = [
        `sur ${bot.guilds.size} serveurs !`,
        `avec ${bot.users.size} utilisateurs !`,
        `t!help`,
        `version 1.0.0`,
        `TheHaraMC !`
    ]

    setInterval(function() {

        let status = statuses[Math.floor(Math.random() * statuses.length)];
        bot.user.setActivity(status, {type: "STREAMING", url:"https://twitch.tv/theharamc"});

    }, 5000)

    console.log("[ " + hours + ":" + minutes + ":" + seconds + ` ][ ${bot.user.username} ] Bot started !`);

});

bot.on("message", async message => {



});

bot.on("guildMemberAdd", function(message) {

    let guild = message.guild;
    let member = message;
    let memberCount = bot.users.size;

    let welcomeEmbed = new Discord.RichEmbed()
        .setTitle("Bienvenue !")
        .setColor("#d63031")
        .setThumbnail(member.user.avatarURL)
        .setDescription(`Bienvenue ${member.user} sur TheHaraMC !`)
        .setFooter("Nous sommes " + memberCount + " membres !")

    member.guild.channels.find("name", "『🤙』bienvenue").send({ embed: welcomeEmbed });

});

bot.on("guildMemberAdd", member => {

    

});

bot.on("guildMemberRemove", function(message) {

    let guild = message.guild;
    let member = message;
    let memberCount = bot.users.size;

    let quitEmbed = new Discord.RichEmbed()
        .setTitle("Au revoir !")
        .setColor("#d63031")
        .setThumbnail(member.user.avatarURL)
        .setDescription(`${member.user} vient de quitter TheHaraMC ! A la prochaine :c`)
        .setFooter("Nous sommes " + memberCount + " membres !")

    member.guild.channels.find("name", "『⛔』bye").send({ embed: quitEmbed });

});

bot.login(config.token);