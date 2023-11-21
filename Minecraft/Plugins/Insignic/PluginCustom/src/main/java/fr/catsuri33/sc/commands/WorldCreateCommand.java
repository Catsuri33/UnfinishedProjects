package fr.catsuri33.sc.commands;

import fr.catsuri33.sc.Main;
import fr.catsuri33.sc.world.WorldsGenerator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WorldCreateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 3 || args.length > 3) {

            sender.sendMessage(Main.prefix + " §cErreur, la commande est §6/wcreate <Nom> <Flat | Normal | Amplified | Large_Biomes> <Structures: on | off> §c!");
            return false;

        }

        if (sender.isOp() || sender.hasPermission("worlds.wcreate")) {

            if (args.length == 3) {

                String worldName = args[0];

                if (Bukkit.getWorld(worldName) == null) {

                    World world = Bukkit.getWorld(worldName);

                    if(args[1].equalsIgnoreCase("flat")){

                        if(args[2].equalsIgnoreCase("on")){

                            WorldsGenerator.crateWorld(worldName, WorldType.FLAT, true);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "flat");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", true);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        if(args[2].equalsIgnoreCase("off")){

                            WorldsGenerator.crateWorld(worldName, WorldType.FLAT, false);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "flat");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", false);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        sender.sendMessage(Main.prefix + " §cErreur, la commande est §6/wcreate <Nom> <Flat | Normal | Amplified | Large_Biomes> <Structures: on | off> §c!");
                        return false;

                    }

                    if(args[1].equalsIgnoreCase("normal")){

                        if(args[2].equalsIgnoreCase("on")){

                            WorldsGenerator.crateWorld(worldName, WorldType.NORMAL, true);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "normal");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", true);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        if(args[2].equalsIgnoreCase("off")){

                            WorldsGenerator.crateWorld(worldName, WorldType.NORMAL, false);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "normal");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", false);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        sender.sendMessage(Main.prefix + " §cErreur, la commande est §6/wcreate <Nom> <Flat | Normal | Amplified | Large_Biomes> <Structures: on | off> §c!");
                        return false;

                    }

                    if(args[1].equalsIgnoreCase("amplified")){

                        if(args[2].equalsIgnoreCase("on")){

                            WorldsGenerator.crateWorld(worldName, WorldType.AMPLIFIED, true);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "amplified");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", true);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        if(args[2].equalsIgnoreCase("off")){

                            WorldsGenerator.crateWorld(worldName, WorldType.AMPLIFIED, false);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "amplified");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", false);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        sender.sendMessage(Main.prefix + " §cErreur, la commande est §6/wcreate <Nom> <Flat | Normal | Amplified | Large_Biomes> <Structures: on | off> §c!");
                        return false;

                    }

                    if(args[1].equalsIgnoreCase("large_biomes")){

                        if(args[2].equalsIgnoreCase("on")){

                            WorldsGenerator.crateWorld(worldName, WorldType.LARGE_BIOMES, true);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "large_biomes");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", true);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        if(args[2].equalsIgnoreCase("off")){

                            WorldsGenerator.crateWorld(worldName, WorldType.LARGE_BIOMES, false);

                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".type", "large_biomes");
                            Main.configManager.getServerConfiguration().set("server.worlds." + worldName + ".structures", false);

                            Main.configManager.saveServerConfiguration();
                            Main.configManager.reloadServerConfiguration();

                            sender.sendMessage(Main.prefix + " §aVous avez créé le monde §6" + worldName + " §a!");
                            return true;

                        }

                        sender.sendMessage(Main.prefix + " §cErreur, la commande est §6/wcreate <Nom> <Flat | Normal | Amplified | Large_Biomes> <Structures: on | off> §c!");
                        return false;

                    }

                    sender.sendMessage(Main.prefix + " §cErreur, ce type de monde n'existe pas ! Types de mondes disponibles: §6Flat | Normal | Amplified | Large_Biomes §c!");
                    return false;

                } else {

                    sender.sendMessage(Main.prefix + " §cErreur, un monde comportant ce nom existe déjà !");
                    return false;

                }

            }

        } else {

            sender.sendMessage(Main.prefix + " §cErreur, vous n'avez pas la permission d'exécuter cette commande !");
            return false;

        }

        return false;

    }

}
