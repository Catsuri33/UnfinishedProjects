package com.insignic.bot.events.command;

import com.insignic.bot.InsignicBot;
import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.commands.bot_admin.InsignicAccountBanCommand;
import com.insignic.bot.events.command.commands.bot_admin.InsignicAccountUnbanCommand;
import com.insignic.bot.events.command.commands.bot_admin.SendNewsToChannelsCommand;
import com.insignic.bot.events.command.commands.fun.RollCommand;
import com.insignic.bot.events.command.commands.global.*;
import com.insignic.bot.events.command.commands.insignic.BadgesCommand;
import com.insignic.bot.events.command.commands.insignic.VerifyEmailCommand;
import com.insignic.bot.events.command.commands.music.*;
import com.insignic.bot.events.command.commands.server_admin.*;
import com.insignic.bot.utils.DateUtils;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

public class CommandManager {

    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager(){

        // Global
        addCommand(new HelpCommand());
        addCommand(new PingCommand());
        addCommand(new UserCommand());
        addCommand(new BotUserCommand());
        addCommand(new ServerCommand());

        // Server Admin
        addCommand(new KickCommand());
        addCommand(new BanCommand());
        addCommand(new ChannelCommand());
        addCommand(new PrefixCommand());
        addCommand(new ClearCommand());
        addCommand(new PollCommand());

        // Music
        addCommand(new PlayCommand());
        addCommand(new StopCommand());
        addCommand(new SkipCommand());
        addCommand(new LeaveCommand());

        // Bot Admin
        addCommand(new SendNewsToChannelsCommand());
        addCommand(new InsignicAccountBanCommand());
        addCommand(new InsignicAccountUnbanCommand());

        // Insignic
        addCommand(new VerifyEmailCommand());
        addCommand(new BadgesCommand());

        // Fun
        addCommand(new RollCommand());

    }

    private void addCommand(ICommand command){

        boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(command.getName()));

        if(nameFound){

            throw new IllegalArgumentException("A command with this name already exist !");

        }

        commands.add(command);

    }

    @Nullable
    private ICommand getCommand(String search){

        String searchLower = search.toLowerCase();

        for(ICommand command : this.commands){

            if(command.getName().equals(searchLower) || command.getAliases().contains(searchLower)){

                return command;

            }

        }

        return null;

    }

    public void handle(GuildMessageReceivedEvent e){

        Long guildId = e.getGuild().getIdLong();
        String[] split = e.getMessage().getContentRaw().replaceFirst("(?i)" + Pattern.quote(DatabaseManager.instance.getPrefix(guildId)), "").split("\\s+");
        String invoke = split[0].toLowerCase();
        ICommand command = this.getCommand(invoke);
        User user = e.getMember().getUser();
        String userId = user.getId();
        TextChannel channel = e.getChannel();

        if(DatabaseManager.instance.getNickname(user.getIdLong()) != null){

            String accountCreationDate = DatabaseManager.instance.getCreationDate(user.getIdLong());
            Date date = new Date();

            if(DateUtils.compareDates(accountCreationDate, date)){

                String dateDifferenceString = String.valueOf(DateUtils.getDifference(accountCreationDate, date));

                if(!DatabaseManager.instance.getBadges(user.getIdLong()).contains("account_creation_" + dateDifferenceString)){

                    DatabaseManager.instance.addBadges(user.getIdLong(), "account_creation_" + dateDifferenceString);
                    channel.sendMessage("Congratulations " + user.getAsMention() + ", your account is now " + dateDifferenceString + " year old !\n\nYou gained **" + dateDifferenceString + " Year Badge** !").queue();

                }

            }

        }

        if(InsignicBot.activateTopGG){

            InsignicBot.topGGApi.hasVoted(userId).whenComplete((hasVoted, voteEvent) -> {

                if(hasVoted){

                    InsignicBot.topGGApi.getVotingMultiplier().whenComplete((multiplier, multiplierEvent) -> {

                        Random random = new Random();
                        DecimalFormat decimalFormat = new DecimalFormat("###.###");
                        int randomXP = random.nextInt(21 - 1) + 1;
                        double randomInsiCoins = 1.00 + random.nextDouble() * (21.00 - 1.00);
                        String randomInsiCoinsString = decimalFormat.format(randomInsiCoins).replace(",", ".");
                        double randomInsiCoinsFin = Double.parseDouble(randomInsiCoinsString);

                        if(multiplier.isWeekend()){

                            if(DatabaseManager.instance.getNickname(user.getIdLong()) != null){

                                DatabaseManager.instance.addXP(user.getIdLong(), randomXP * 2);
                                DatabaseManager.instance.addInsiCoins(user.getIdLong(), randomInsiCoinsFin * 2);

                                user.openPrivateChannel().queue(privateChannel -> {

                                    privateChannel.sendMessage("__**Top.gg Vote**__\n").queue();
                                    privateChannel.sendMessage("Thanks for voting on Top.gg (https://top.gg)! You have won **" + randomXP * 2 + " XP** and **" + randomInsiCoinsFin * 2 + " InsiCoins** ! (Weekend Boost x2)").queue();

                                });

                            } else {

                                user.openPrivateChannel().queue(privateChannel -> {

                                    privateChannel.sendMessage("__**Top.gg Vote**__\n").queue();
                                    privateChannel.sendMessage("Thanks for voting on Top.gg (https://top.gg) ! You don't have an InsignicAccount account so you didn't get any rewards !").queue();

                                });

                            }

                        } else {

                            if(DatabaseManager.instance.getNickname(user.getIdLong()) != null){

                                DatabaseManager.instance.addXP(user.getIdLong(), randomXP);
                                DatabaseManager.instance.addInsiCoins(user.getIdLong(), randomInsiCoinsFin);

                                user.openPrivateChannel().queue(privateChannel -> {

                                    privateChannel.sendMessage("__**Top.gg Vote**__\n").queue();
                                    privateChannel.sendMessage("Thanks for voting on Top.gg (https://top.gg)! You have won **" + randomXP + " XP** and **" + randomInsiCoinsFin + " InsiCoins** !").queue();

                                });

                            } else {

                                user.openPrivateChannel().queue(privateChannel -> {

                                    privateChannel.sendMessage("__**Top.gg Vote**__\n").queue();
                                    privateChannel.sendMessage("Thanks for voting on Top.gg (https://top.gg) ! You don't have an InsignicAccount account so you didn't get any rewards !").queue();

                                });

                            }

                        }

                    });

                }

            });

        }

        if(command != null){

            if(!e.getGuild().getName().equals(DatabaseManager.instance.getGuildName(e.getGuild().getIdLong()))){

                DatabaseManager.instance.setGuildName(e.getGuild().getIdLong(), e.getGuild().getName());

            }

            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext commandContext = new CommandContext(e, args);

            command.handle(commandContext);

        }

    }

}
