package fr.epicgiant.core.commands;

import fr.catsuri33.api.npcs.NPCManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NPCCommand implements CommandExecutor {

    public NPCManager npcManager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 2){

                if(args[0].equalsIgnoreCase("create")){

                    String npcName = args[1];
                    npcManager.createNPC(player, npcName);

                }

            }

        }

        return true;

    }
}
