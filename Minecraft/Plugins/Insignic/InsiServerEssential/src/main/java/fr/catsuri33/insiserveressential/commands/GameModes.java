package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModes implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            // Gamemode Survival
            if (label.equalsIgnoreCase("gm0")) {

                if(p.isOp() || p.hasPermission("insiserveressential.gm0")){

                    if (args.length <= 0) {

                        p.setGameMode(GameMode.SURVIVAL);

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed your game mode to §eSURVIVAL §amode.");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé votre mode de jeu en mode §eSURVIE§a.");

                        }

                    }

                    if (args.length == 1) {

                        String targetName = args[0];

                        Player target = Bukkit.getPlayer(targetName);

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            target.setGameMode(GameMode.SURVIVAL);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed the game mode of §e" + target.getName() + " §ato §eSURVIVAL §amode.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aYou are now in §eSURVIVAL §amode.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé le mode de jeu de §e" + target.getName() + " §aen mode §eSURVIE§a.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aVous êtes désormais en mode §eSURVIE§a.");

                            }

                        } else {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cThe player §e" + targetName + " §cis not online or does not exist !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cLe joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                            }

                        }

                    }

                    if (args.length > 1) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/gm0 <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/gm0 <Joueur> §c!");

                        }

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, you don't have the permission to execute this command !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous n'avez pas la permission d'exéctuter cette commande !");

                    }

                }

            }

            // Gamemode Creative
            if (label.equalsIgnoreCase("gm1")) {

                if(p.isOp() || p.hasPermission("insiserveressential.gm1")){

                    if (args.length <= 0) {

                        p.setGameMode(GameMode.CREATIVE);

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed your game mode to §eCREATIVE §amode.");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé votre mode de jeu en mode §eCREATIF§a.");

                        }

                    }

                    if (args.length == 1) {

                        String targetName = args[0];

                        Player target = Bukkit.getPlayer(targetName);

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            target.setGameMode(GameMode.CREATIVE);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed the game mode of §e" + target.getName() + " §ato §eCREATIVE §amode.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aYou are now in §eCREATIVE §amode.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé le mode de jeu de §e" + target.getName() + " §aen mode §eCREATIF§a.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aVous êtes désormais en mode §eCREATIF§a.");

                            }

                        } else {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cThe player §e" + targetName + " §cis not online or does not exist !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cLe joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                            }

                        }

                        if (args.length > 1) {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/gm1 <Player> §c!");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/gm1 <Joueur> !§c");

                            }

                        }

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, you don't have the permission to execute this command !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous n'avez pas la permission d'exéctuter cette commande !");

                    }

                }

            }

            // Gamemode Adventure
            if (label.equalsIgnoreCase("gm2")) {

                if(p.isOp() || p.hasPermission("insiserveressential.gm2")){

                    if (args.length <= 0) {

                        p.setGameMode(GameMode.ADVENTURE);

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed your game mode to §eADVENTURE §amode.");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé votre mode de jeu en mode §eAVENTURE§a.");

                        }

                    }

                    if (args.length == 1) {

                        String targetName = args[0];

                        Player target = Bukkit.getPlayer(targetName);

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            target.setGameMode(GameMode.ADVENTURE);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed the game mode of §e" + target.getName() + " §ato §eADVENTURE §amode.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aYou are now in §eADVENTURE §amode.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé le mode de jeu de §e" + target.getName() + " §aen mode §eAVENTURE§a.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aVous êtes désormais en mode §eAVENTURE§a.");

                            }

                        } else {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cThe player §e" + targetName + " §cis not online or does not exist !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cLe joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                            }

                        }

                    }

                    if (args.length > 1) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/gm2 <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/gm2 <Joueur> !§c");

                        }

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, you don't have the permission to execute this command !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous n'avez pas la permission d'exéctuter cette commande !");

                    }

                }

            }

            // Gamemode Spectator
            if (label.equalsIgnoreCase("gm3")) {

                if(p.isOp() || p.hasPermission("insiserveressential.gm3")){

                    if (args.length <= 0) {

                        p.setGameMode(GameMode.SPECTATOR);

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed your game mode to §eSPECTATOR §amode.");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé votre mode de jeu en mode §eSPECTATEUR§a.");

                        }

                    }

                    if (args.length == 1) {

                        String targetName = args[0];

                        Player target = Bukkit.getPlayer(targetName);

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            target.setGameMode(GameMode.SPECTATOR);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed the game mode of §e" + target.getName() + " §ato §eSPECTATOR §amode.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aYou are now in §eSPECTATOR §amode.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé le mode de jeu de §e" + target.getName() + " §aen mode §eSPECTATEUR§a.");
                                target.sendMessage("§bInsiServer§fEssential §6» §aVous êtes désormais en mode §eSPECTATEUR§a.");

                            }

                        } else {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cThe player §e" + targetName + " §cis not online or does not exist !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cLe joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                            }

                        }

                    }

                    if (args.length > 1) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/gm3 <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/gm3 <Joueur> !§c");

                        }

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, you don't have the permission to execute this command !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous n'avez pas la permission d'exéctuter cette commande !");

                    }

                }

            }

                return true;

            } else {

            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must be a player to execute this command !");

            }

            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez être un joueur pour effectuer cette commande !");

            }

        }

        return false;

    }
}
