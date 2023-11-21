package fr.catsuri33.insifactions.commands;

import fr.catsuri33.insifactions.InsiFactions;
import fr.catsuri33.insifactions.guis.GuiManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FactionCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("faction")){

                if(args.length == 0){

                    p.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/faction <Create - Options>");
                    return false;

                }

                if(args.length == 1){

                    if(args[0].equalsIgnoreCase("create")){

                        if(InsiFactions.configManager.getPlayersConfig().getString("players." + p.getUniqueId() + ".faction").equals("")){

                            p.sendMessage(InsiFactions.prefix + "§aVous avez ouvert l'interface de création de faction !");
                            p.openInventory(GuiManager.createFactionInv);
                            return true;

                        } else {

                            p.sendMessage(InsiFactions.prefix + "§cErreur, vous possédez déjà une faction !");
                            return false;

                        }

                    }

                    if(args[0].equalsIgnoreCase("options")){



                    }

                }

                if(args.length >= 2){

                    p.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/faction <Create - Options>");
                    return false;

                }

            }

        } else {

            sender.sendMessage(InsiFactions.prefix + "§cErreur, vous devez être un joueur pour effectuer cette commande !");
            return false;

        }

        return false;

    }

}
