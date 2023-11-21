package fr.insignicevents.global.commands;

import fr.insignicevents.global.database.servers.ServersTable;
import fr.insignicevents.global.utils.ServerManagement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Maintenance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("maintenance")){

            if(sender.isOp()){

                if(args.length == 1){

                    if(args[0].equalsIgnoreCase("on")){

                        ServersTable.setMaintenanceState("true");
                        ServerManagement.kickAllNonOpForMaintenance();

                        sender.sendMessage("§b§lInsignic §r§fEvents §b» §aLa maintenance est désormais activée !");

                    } else if(args[0].equalsIgnoreCase("off")) {

                        ServersTable.setMaintenanceState("false");

                        sender.sendMessage("§b§lInsignic §r§fEvents §b» §cLa maintenance est désormais désactivée !");

                    } else {

                        sender.sendMessage("§b§lInsignic §r§fEvents §b» §cErreur, vos arguments sont invalides !");

                    }

                } else {

                    sender.sendMessage("§b§lInsignic §r§fEvents §b» §cErreur, vous devez spécifier des arguments !");


                }
            } else {

                sender.sendMessage("§b§lInsignic §r§fEvents §b» §cErreur, vous n'avez pas la permission d'effectuer cette commande !");

            }

            return true;

        }

        return false;

    }
}
