package fr.odilonesport.fallenkingdoms.commands.admin;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.utils.RegionManager;
import fr.odilonesport.fallenkingdoms.utils.ValuesCheck;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class SetAreaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("setarea")){

            if(sender instanceof Player){

                Player p = (Player) sender;

                if(!p.isOp()){

                    p.sendMessage(Main.getInstance().prefix + "§cErreur, vous n'avez pas la permission d'éxecuter cette commande !");
                    return false;

                }

                if(args.length > 0){

                    if(args[0].equalsIgnoreCase("lobby")){

                        if(args.length != 1){

                            p.sendMessage(Main.getInstance().prefix +  "§cErreur, la commande est '§e/setarea <lobby>§c' !");
                            return false;

                        } else {

                            Double x = p.getLocation().getX();
                            Double y = p.getLocation().getY();
                            Double z = p.getLocation().getZ();

                            Main.getInstance().getConfig().set("game.lobby.x", x);
                            Main.getInstance().getConfig().set("game.lobby.y", y);
                            Main.getInstance().getConfig().set("game.lobby.z", z);
                            Main.getInstance().saveConfig();

                            p.sendMessage(Main.getInstance().prefix + "§aLe lobby a été définit en §eX: " + x + " Y: " + y + " Z: " + z + "§a.");
                            return true;

                        }

                    }

                    if(args[0].equalsIgnoreCase("base")){

                        if(args.length != 3){

                            p.sendMessage(Main.getInstance().prefix +  "§cErreur, la commande est '§e/setarea <base> <team name> <radius>§c' !");
                            return false;

                        }

                        String team = args[1].toLowerCase();
                        String radius = args[2];
                        List<Object> teamFields = Arrays.asList(Main.getInstance().getConfig().getConfigurationSection("game.teams").getKeys(false).toArray());

                        if(!teamFields.contains(team)){

                            p.sendMessage(Main.getInstance().prefix +  "§cErreur, l'équipe '§e" + team.substring(0, 1).toUpperCase() + team.substring(1) + "§c' n'existe pas !");
                            return false;

                        }

                        if(!ValuesCheck.isInteger(radius)){

                            p.sendMessage(Main.getInstance().prefix +  "§cErreur, le radius spécifié n'est pas un nombre entier !");
                            return false;

                        }

                        Integer radiusInt = Integer.parseInt(radius);
                        Object teamObject = teamFields.get(teamFields.indexOf(team));
                        String teamName = teamObject.toString().substring(0, 1).toUpperCase() + teamObject.toString().substring(1);
                        String teamColor = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("game.teams." + teamObject + ".color"));
                        Double xCoord = p.getLocation().getX();
                        Double yCoord = p.getLocation().getY();
                        Double zCoord = p.getLocation().getZ();

                        Main.getInstance().getConfig().set("game.teams." + teamObject + ".base.radius", radiusInt);
                        Main.getInstance().saveConfig();
                        Main.getInstance().getConfig().set("game.teams." + teamObject + ".base.x", xCoord);
                        Main.getInstance().saveConfig();
                        Main.getInstance().getConfig().set("game.teams." + teamObject + ".base.y", yCoord);
                        Main.getInstance().saveConfig();
                        Main.getInstance().getConfig().set("game.teams." + teamObject + ".base.z", zCoord);
                        Main.getInstance().saveConfig();

                        if(Main.getInstance().basesRegions.containsKey(teamObject.toString())){

                            Main.getInstance().basesRegions.remove(teamObject.toString());

                        }

                        RegionManager baseRegion = new RegionManager(new Location(Bukkit.getWorlds().get(0), xCoord - radiusInt, yCoord, zCoord - radiusInt), new Location(Bukkit.getWorlds().get(0), xCoord + radiusInt, yCoord, -zCoord - radiusInt));
                        Main.getInstance().basesRegions.put(teamObject.toString(), baseRegion);

                        p.sendMessage(Main.getInstance().prefix + "§aVous avez définit la base " + teamColor + teamName + " §aaux coordonnés: §eX: " + xCoord + "§a, §eZ: " + zCoord + "§a, §eRayon: " + radius + "§a.");
                        return true;

                    } else {

                        p.sendMessage(Main.getInstance().prefix +  "§cErreur, la commande est '§e/setarea <lobby/base> <team name (only for base)> <radius (only for base)>§c' !");
                        return false;

                    }

                } else {

                    p.sendMessage(Main.getInstance().prefix +  "§cErreur, la commande est '§e/setarea <lobby/base> <team name (only for base)> <radius (only for base)>§c' !");
                    return false;

                }

            } else {

                sender.sendMessage(Main.getInstance().prefix + "§cCette commande ne peut être executée que par un joueur !");
                return false;

            }

        }

        return false;

    }

}
