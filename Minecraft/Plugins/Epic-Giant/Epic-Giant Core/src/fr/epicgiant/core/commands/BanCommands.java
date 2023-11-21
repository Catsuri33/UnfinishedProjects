package fr.epicgiant.core.commands;

import fr.epicgiant.core.Main;
import fr.epicgiant.core.utils.TimeUnit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.UUID;

public class BanCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("ban")){
            if(!sender.hasPermission("epicgiantcore.ban")){
                sender.sendMessage("§cYou do not have permission to execute this command !");
                return false;
            }

            if(args.length < 3){
                helpMessage(sender);
                return false;
            }

            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exist(targetName)){
                sender.sendMessage("§cThis player has never connected to the server !");
                return false;
            }

            UUID targetUUID = Main.getInstance().playerInfos.getUUID(targetName);

            if(Main.getInstance().banManager.isBanned(targetUUID)){
                sender.sendMessage("§cThis player is already banned !");
                return false;
            }

            String reason = "";
            for(int i = 2; i < args.length; i++){
                reason += args[i] + " ";
            }

            if(args[1].equalsIgnoreCase("perm")){
                Main.getInstance().banManager.ban(targetUUID, -1, reason);
                sender.sendMessage("§aYou have banned §6" + targetName + " §c(Permanent) §afor : §e" + reason);
                return false;
            }

            if(!args[1].contains(":")){
                helpMessage(sender);
                return false;
            }

            int duration = 0;
            try {
                duration = Integer.parseInt(args[1].split(":")[0]);
            } catch(NumberFormatException e){
                sender.sendMessage("§cThe value 'duration' must be a number !");
                return false;
            }

            if(!TimeUnit.existFromShortcut(args[1].split(":")[1])){
                sender.sendMessage("§cThis unit of time does not exist !");
                for(TimeUnit units : TimeUnit.values()){
                    sender.sendMessage("§b" + units.getName() + " §f: §e" + units.getShortcut());
                }
                return false;
            }

            TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
            long banTime = unit.getToSecond() * duration;

            Main.getInstance().banManager.ban(targetUUID, banTime, reason);
            sender.sendMessage("§aYou have banned §6" + targetName + " §b(" + duration + " " + unit.getName() + ") §afor : §e" + reason);
            return false;
        }

        if(label.equalsIgnoreCase("unban")){
            if(!sender.hasPermission("epicgiantcore.unban")){
                sender.sendMessage("§c§cYou do not have permission to execute this command  !");
                return false;
            }

            if(args.length != 1){
                sender.sendMessage("§c/unban <player>");
                return false;
            }

            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exist(targetName)){
                sender.sendMessage("§cThis player has never connected to the server !");
                return false;
            }

            UUID targetUUID = Main.getInstance().playerInfos.getUUID(targetName);

            if(!Main.getInstance().banManager.isBanned(targetUUID)){
                sender.sendMessage("§cThis player is not banned !");
                return false;
            }

            Main.getInstance().banManager.unban(targetUUID);
            sender.sendMessage("§aYou have successfully unban §6" + targetName);
            return false;
        }

        return false;
    }

    public void helpMessage(CommandSender sender){
        sender.sendMessage("§c/ban <player> perm <reason>");
        sender.sendMessage("§c/ban <player> <time>:<unit> <reason>");
    }
}
