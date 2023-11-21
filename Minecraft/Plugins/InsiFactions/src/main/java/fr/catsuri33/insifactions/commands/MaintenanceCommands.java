package fr.catsuri33.insifactions.commands;

import fr.catsuri33.insifactions.InsiFactions;
import fr.catsuri33.insifactions.utils.VerifyVar;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MaintenanceCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("maintenance")){

            if(sender.isOp() || sender.hasPermission("insifactions.maintenance")){

                if(args.length == 0){

                    sender.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/maintenance <On - Off - Set> <Heure> <Durée> <Unité>");
                    return false;

                }

                if(args.length == 1){

                    if(args[0].equalsIgnoreCase("on")){

                        InsiFactions.configManager.getMaintenanceConfig().set("maintenance.enabled", "true");
                        InsiFactions.configManager.saveMaintenanceConfig();
                        InsiFactions.configManager.reloadMaintenanceConfig();

                        kickPlayers();
                        sender.sendMessage(InsiFactions.prefix + "§aVous avez activé la maintenance du serveur !");

                        return true;

                    }

                    if(args[0].equalsIgnoreCase("off")){

                        InsiFactions.configManager.getMaintenanceConfig().set("maintenance.enabled", "false");
                        InsiFactions.configManager.saveMaintenanceConfig();
                        InsiFactions.configManager.reloadMaintenanceConfig();

                        sender.sendMessage(InsiFactions.prefix + "§cVous avez désactivé la maintenance du serveur !");

                        return true;

                    }

                }

                if(args.length == 2 || args.length == 3){

                    sender.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/maintenance <On - Off - Set> <Heure> <Durée>");
                    return false;

                }

                if(args.length == 4){

                    if(args[0].equalsIgnoreCase("set")){

                        int hour = Integer.parseInt(args[1]);
                        int duration = Integer.parseInt(args[2]);

                        DateTimeFormatter date = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalDateTime actualDate = LocalDateTime.now();

                        

                    }

                }

            }

        }

        return false;

    }

    public void kickPlayers(){

        for(Player players : Bukkit.getOnlinePlayers()){

            if(!players.isOp() || !players.hasPermission("insifactions.staymaintenance")){

                players.kickPlayer("§c§lMaintenance\n§r§cUne maintenance commence !\n\n§6Durée: §eIndéfinie");

            }

        }

    }

}
