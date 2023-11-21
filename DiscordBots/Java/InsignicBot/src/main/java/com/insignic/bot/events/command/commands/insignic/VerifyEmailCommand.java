package com.insignic.bot.events.command.commands.insignic;

import com.insignic.bot.InsignicBot;
import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.SendEmail;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import java.util.List;

public class VerifyEmailCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Member member = commandContext.getMember();
        final Long guildId = commandContext.getGuild().getIdLong();
        final List<String> args = commandContext.getArgs();

        channel.sendMessage("Error, this command is actually disabled due to an error with Google !").queue();
        return;

//        if(DatabaseManager.instance.getNickname(member.getIdLong()) != null){
//
//            if(args.isEmpty()){
//
//                if(DatabaseManager.instance.getEmailState(member.getIdLong()).equals("-1")){
//
//                    String adressTo = DatabaseManager.instance.getEmail(member.getIdLong());
//                    Message message = SendEmail.prepareMessage(InsignicBot.session, adressTo, member.getUser());
//                    channel.sendMessage("Please wait while the email is sent...").queue();
//
//                    try {
//
//                        Transport.send(message);
//
//                    } catch (MessagingException e) {
//
//                        e.printStackTrace();
//
//                    }
//
//                    DatabaseManager.instance.setEmailState(member.getIdLong(), 0);
//                    channel.sendMessage("Verification email sent to your mail address !").queue();
//
//                } else if(DatabaseManager.instance.getEmailState(member.getIdLong()).equals("0")) {
//
//                    channel.sendMessage("Error, the email has already been sent !").queue();
//                    return;
//
//                } else {
//
//                    if(DatabaseManager.instance.getEmailState(member.getIdLong()).equals("1")){
//
//                        channel.sendMessage("Error, you already verified your email !").queue();
//                        return;
//
//                    }
//
//                }
//
//            }
//
//            if(args.size() == 1){
//
//                if(DatabaseManager.instance.getEmailState(member.getIdLong()).equals("-1")){
//
//                    channel.sendMessage("Error, you have not yet requested the email ! Type `" + DatabaseManager.instance.getPrefix(guildId) + "everify` to receive the email !").queue();
//                    return;
//
//                }
//
//                if(DatabaseManager.instance.getEmailState(member.getIdLong()).equals("0")){
//
//                    String codeByUser = args.get(0);
//
//                    if(codeByUser.equalsIgnoreCase(DatabaseManager.instance.getEmailCode(member.getIdLong()))){
//
//                        channel.sendMessage("You have successfully verified you email !").queue();
//
//                        DatabaseManager.instance.setEmailState(member.getIdLong(), 1);
//                        DatabaseManager.instance.setEmailCode(member.getIdLong(), "");
//
//                        return;
//
//                    } else {
//
//                        channel.sendMessage("Error, the code doesn't match !").queue();
//                        return;
//
//                    }
//
//                }
//
//                if(DatabaseManager.instance.getEmailState(member.getIdLong()).equals("1")){
//
//                    channel.sendMessage("Error, you have already verified your email !").queue();
//                    return;
//
//                }
//
//            }
//
//            if(args.size() > 1){
//
//                channel.sendMessage("Error, the command is `i!everify <Code>` !").queue();
//                return;
//
//            }
//
//        } else {
//
//            channel.sendMessage("Error, you don't have an InsignicAccounts ! To get started type `" + DatabaseManager.instance.getPrefix(guildId) + "account create`.").queue();
//            return;
//
//        }

    }

    @Override
    public String getName() {

        return "everify";

    }

}
