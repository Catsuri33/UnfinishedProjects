const Discord = require('discord.js');
const fetch = require("node-fetch");

const config = require('./config.json');

const bot = new Discord.Client;


bot.on('ready', async () =>{
    
    bot.user.setActivity('t!help');
    console.log(`${bot.user.username} est en ligne !`);

});

bot.on('message', async message => {

    if(message.author.bot)return;
    if(message.channel.type === 'dm')return;

    let prefix = config.prefix;
    let messageArray = message.content.split(" ");
    let command = messageArray[0];
    let args = messageArray.slice(1);

    if(message.content === prefix + "help"){
        let embed = new Discord.RichEmbed()
          .setTitle('Help')
          .setColor('#2ecc71')
          .addField('General : ', `**- t!help :** Show help.`)
          .addField('Moderation : ', `**- Empty**`)
          .setFooter('Copyright © 2019 Insignic');

        
        return message.channel.send(embed);
    }

    if(message.content === prefix + "weather"){

        let city = args[0];

        if(!city){
            return message.channel.send('❌ Error, you must specify the city !');
        }

        fetch(`http://api.openweathermap.org/data/2.5/weather?q=${city}&lang=en&units=metric&appid=e283a0a668b40ee333f2ba4f7979758b`).then(res => res.json()).then(resJson => {
        
        let weatherEmbed = new Discord.RichEmbed()
                .setTitle(resJson.name)
                .setColor('#2ecc71')
                .addField('Humidity : ', resJson.main.humidity)
                .addField('Pressure : ', resJson.main.pressure)
                .addField('Temperature : ', resJson.main.temp)
                .addField('Maximum Temperature : ', resJson.main.temp_max)
                .addField('Minimum Temperature : ', resJson.main.temp_min)
                .addField('Wind Speed : ', resJson.wind.speed)
                .setFooter('Copyright © 2019 Insignic');

        
        return message.channel.send(weatherEmbed);

        })
    }
});

bot.login(config.token);

//fetch('http://api.openweathermap.org/data/2.5/weather?q=Paris,fr&lang=en&units=metric&appid=e283a0a668b40ee333f2ba4f7979758b').then((response) => {
    //console.log(response);
//});