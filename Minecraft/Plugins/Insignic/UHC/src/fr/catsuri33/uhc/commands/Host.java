package fr.catsuri33.uhc.commands;

import fr.catsuri33.uhc.UHC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Host implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(command.getName().equalsIgnoreCase("host") && player.hasPermission("uhc.host")){

                if(args.length == 0){

                    player.sendMessage("§e*=*=*=*=*=*=*=* §6Aide Host §e*=*=*=*=*=*=*=*");
                    player.sendMessage("§6/host add <Pseudo> : §fAjouter un host.");
                    player.sendMessage("§6/host remove <Pseudo> : §fRetirer un host.");
                    player.sendMessage("§6/host list : §fAfficher le liste des hosts.");
                    player.sendMessage("§e*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                    return true;

                }

                // Ajouter un Host.
                if(args[0].equalsIgnoreCase("add")){

                    if(args.length == 1){

                        player.sendMessage("§b[§6UHC§b] §cVeuillez faire /host add <Pseudo>");
                        return true;

                    }

                    Player p = Bukkit.getPlayer(args[1]);

                    if(!UHC.getInstance().playerInGame.contains(p.getUniqueId())){

                        player.sendMessage("§b[§6UHC§b] §cCe joueur n'est pas connecté sur le serveur/n'existe pas !");
                        return true;

                    } else {

                        if(!UHC.getInstance().playerHost.contains(p.getUniqueId())){

                            UHC.getInstance().playerHost.add(p.getUniqueId());
                            player.sendMessage("§b[§6UHC§b] §a" + p.getName() + " a bien été ajouté en tant qu'host !");

                            p.sendMessage("§b[§6UHC§b] §aVous êtes désormais host de la partie !");
                            p.setPlayerListName("§c[Host] §c" + player.getName());
                            p.setDisplayName("§c[Host] §c" + player.getName() + "§f");

                            ItemStack hostItem = new ItemStack(Material.COMPARATOR, 1);
                            ItemMeta hostItemMeta = hostItem.getItemMeta();
                            hostItemMeta.setDisplayName("§cHost Editor");
                            hostItemMeta.setLore(Arrays.asList("§r§7Utilisez cet item pour configurer", "§r§7les paramètres de la partie."));
                            hostItem.setItemMeta(hostItemMeta);

                            p.getInventory().setItem(4, hostItem);
                            p.updateInventory();

                            return true;

                        } else {

                            p.sendMessage("§b[§6UHC§b] §cCe joueur est déjà host de la partie !");
                            return true;

                        }

                    }

                }

                // Retirer un host.
                if(args[0].equalsIgnoreCase("remove")){

                    if(args.length == 1){

                        player.sendMessage("§b[§6UHC§b] §cVeuillez faire /host remove <Pseudo>");
                        return true;

                    }

                    Player p = Bukkit.getPlayer(args[1]);

                    if(!UHC.getInstance().playerInGame.contains(p.getUniqueId())){

                        player.sendMessage("§b[§6UHC§b] §cCe joueur n'est pas connecté sur le serveur/n'existe pas !");
                        return true;

                    } else {

                        if(UHC.getInstance().playerHost.contains(p.getUniqueId())){

                            UHC.getInstance().playerHost.remove(p.getUniqueId());
                            player.sendMessage("§b[§6UHC§b] §a" + p.getName() + " a bien été retiré en tant qu'host !");

                            p.sendMessage("§b[§6UHC§b] §cVous n'êtes désormais plus host de la partie !");
                            p.setDisplayName("§7" + player.getName() + "§7");
                            p.setPlayerListName("§7" + player.getName());
                            p.getInventory().clear();

                            return true;

                        } else {

                            p.sendMessage("§b[§6UHC§b] §cCe joueur n'est pas host de la partie !");
                            return true;

                        }

                    }

                }

                // Voir la liste des hosts.
                if(args[0].equalsIgnoreCase("list")){

                    int hostSize = UHC.getInstance().playerHost.size();
                    Player hostNames = Bukkit.getPlayer(UHC.getInstance().playerHost.toString());

                    player.sendMessage("§b[§6UHC§b] §eIl y a actuellement §6" + hostSize + " §ehosts :");
                    player.sendMessage("- " + hostNames.getName());
                    return true;

                }

            } else {

                player.sendMessage("§b[§6UHC§b] §cVous n'avez pas la permission d'éxecuter cette commande !");
                return true;

            }

        }

        return false;

    }

}
