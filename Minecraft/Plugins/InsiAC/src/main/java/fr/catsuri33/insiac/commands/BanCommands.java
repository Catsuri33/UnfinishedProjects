package fr.catsuri33.insiac.commands;

import fr.catsuri33.insiac.InsiAC;
import fr.catsuri33.insiac.mysql.PlayersMySQL;
import fr.catsuri33.insiac.mysql.ServersMySQL;
import fr.catsuri33.insiac.sanctions.bans.BanManager;
import fr.catsuri33.insiac.utils.TimeUnit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.UUID;

public class BanCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("ban")){

            if(sender.hasPermission("insiac.ban") || sender.isOp()){

                if(ServersMySQL.isPasswordCorrect(InsiAC.getInstance().getConfig().getString("server-name"))){

                    if(args.length < 3 ){

                        sender.sendMessage("§6§lInsiAC » §r§cError, the command is §e/ban <Player> <Perm|Time> <Unit> <Reason> §c!");
                        return false;

                    }

                    String targetName = args[0];

                    if(PlayersMySQL.getUUID(targetName, InsiAC.getInstance().getConfig().getString("server-name")) == null){

                        sender.sendMessage("§6§lInsiAC » §r§cError, this player has never connected !");
                        return false;

                    }

                    UUID targetUUID = PlayersMySQL.getUUID(targetName, InsiAC.getInstance().getConfig().getString("server-name"));

                    if(BanManager.isBanned(targetUUID)){

                        sender.sendMessage("§6§lInsiAC » §r§cError, this player his already banned !");
                        return false;

                    }

                    String reason = "";

                    if(args[1].equalsIgnoreCase("perm")){

                        for(int i = 2; i < args.length; i++){

                            reason += args[i] + " ";

                        }

                        BanManager.ban(targetUUID, InsiAC.getInstance().getConfig().getString("server-name"), -1, reason);
                        sender.sendMessage("§6§lInsiAC » §r§aYou have banned §e" + targetName + " §c(Permanent) §afor §e" + reason + " §a!");
                        return false;

                    } else {

                        for(int i = 3; i < args.length; i++){

                            reason += args[i] + " ";

                        }

                        if(args.length < 4 ){

                            sender.sendMessage("§6§lInsiAC » §r§cError, the command is §e/ban <Player> <Perm|Time> <Unit> <Reason> §c!");
                            return false;

                        }

                        int duration = 0;

                        try {

                            duration = Integer.parseInt(args[1]);

                        } catch(NumberFormatException e){

                            sender.sendMessage("§6§lInsiAC » §r§cError, time must be a number !");
                            return false;

                        }

                        if(!TimeUnit.existFromShortcut(args[2])){

                            sender.sendMessage("§6§lInsiAC » §r§cError, this unit of time doesn't exist ! (Units: s, min, h, d, m, y");
                            return false;

                        }

                        TimeUnit unit = TimeUnit.getFromShortcut(args[2]);
                        long banTime = unit.getTimeInSeconds() * duration;

                        BanManager.ban(targetUUID, InsiAC.getInstance().getConfig().getString("server-name"), banTime, reason);
                        sender.sendMessage("§6§lInsiAC » §r§aYou have banned §e" + targetName + " §c(" + duration + " " + unit.getName() + ") §afor §e" + reason + " §a!");
                        return false;

                    }

                } else {

                    sender.sendMessage("§6§lInsiAC » §r§cError, the password in the config file does not match with the server name !");
                    return false;

                }

            } else {

                sender.sendMessage("§6§lInsiAC » §r§cError, you don't have permission to execute this command !");
                return false;

            }

        }

        if(label.equalsIgnoreCase("unban")){

            if(sender.hasPermission("insiac.unban") || sender.isOp()){

                if(ServersMySQL.isPasswordCorrect(InsiAC.getInstance().getConfig().getString("server-name"))){

                    if(args.length != 1){

                        sender.sendMessage("§6§lInsiAC » §r§cError, the command is §e/unban <Player> §c!");
                        return false;

                    }

                    String targetName = args[0];

                    if(PlayersMySQL.getUUID(targetName, InsiAC.getInstance().getConfig().getString("server-name")) == null){

                        sender.sendMessage("§6§lInsiAC » §r§cError, this player has never connected !");
                        return false;

                    }

                    UUID targetUUID = PlayersMySQL.getUUID(targetName, InsiAC.getInstance().getConfig().getString("server-name"));

                    if(!BanManager.isBanned(targetUUID)){

                        sender.sendMessage("§6§lInsiAC » §r§cError, this player his not banned !");
                        return false;

                    }

                    BanManager.unban(targetUUID, InsiAC.getInstance().getConfig().getString("server-name"));
                    sender.sendMessage("§6§lInsiAC » §r§aYou have unban §e" + targetName + " §a!");
                    return false;

                } else {

                    sender.sendMessage("§6§lInsiAC » §r§cError, the password in the config file does not match with the server name !");
                    return false;

                }

            } else {

                sender.sendMessage("§6§lInsiAC » §r§cError, you don't have permission to execute this command !");
                return false;

            }

        }

        if(label.equalsIgnoreCase("check")){

            if(sender.hasPermission("insiac.check") || sender.isOp()){

                if(ServersMySQL.isPasswordCorrect(InsiAC.getInstance().getConfig().getString("server-name"))){

                    if(args.length != 1){

                        sender.sendMessage("§6§lInsiAC » §r§cError, the command is §e/check <Player> §c!");
                        return false;

                    }

                    String targetName = args[0];

                    if(PlayersMySQL.getUUID(targetName, InsiAC.getInstance().getConfig().getString("server-name")) == null){

                        sender.sendMessage("§6§lInsiAC » §r§cError, this player has never connected !");
                        return false;

                    }

                    UUID targetUUID = PlayersMySQL.getUUID(targetName, InsiAC.getInstance().getConfig().getString("server-name"));

                    BanManager.checkDuration(targetUUID, InsiAC.getInstance().getConfig().getString("server-name"));

                    sender.sendMessage("§7§m                    §r§6§lInsiAC§r§7§m                    ");
                    sender.sendMessage("§ePseudo: §f" + args[0]);
                    sender.sendMessage("§eUUID: §f" + targetUUID.toString());
                    sender.sendMessage("§eBanned: " + (BanManager.isBanned(targetUUID) ? "§a✔️" : "§c❌"));

                    if(BanManager.isBanned(targetUUID)){

                        sender.sendMessage("     §eReason: §f" + BanManager.getReason(targetUUID, InsiAC.getInstance().getConfig().getString("server-name")));
                        sender.sendMessage("     §eTime Left: §f" + BanManager.getTimeLeft(targetUUID, InsiAC.getInstance().getConfig().getString("server-name")));

                    }

                    sender.sendMessage("§eTotal Sanctions: §f" + PlayersMySQL.getSanctionsTotal(targetUUID, InsiAC.getInstance().getConfig().getString("server-name")));
                    sender.sendMessage("§eTotal Bans: §f" + PlayersMySQL.getSanctionsBans(targetUUID, InsiAC.getInstance().getConfig().getString("server-name")));
                    sender.sendMessage("§eTotal Mutes: §f" + PlayersMySQL.getSanctionsMutes(targetUUID, InsiAC.getInstance().getConfig().getString("server-name")));
                    sender.sendMessage("§eTotal Warns: §f" + PlayersMySQL.getSanctionsWarns(targetUUID, InsiAC.getInstance().getConfig().getString("server-name")));

                    sender.sendMessage("§7§m                                                ");

                    return false;

                } else {

                    sender.sendMessage("§6§lInsiAC » §r§cError, the password in the config file does not match with the server name !");
                    return false;

                }

            }

        }

        return false;

    }

}
