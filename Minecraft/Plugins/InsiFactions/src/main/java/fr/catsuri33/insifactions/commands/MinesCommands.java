package fr.catsuri33.insifactions.commands;

import fr.catsuri33.insifactions.InsiFactions;
import fr.catsuri33.insifactions.core.Mines;
import fr.catsuri33.insifactions.core.tasks.MinesRunnable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class MinesCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("setmine")){

                if(p.isOp() || p.hasPermission("insifactions.setmine")){

                    if(args.length < 7){

                        p.sendMessage(InsiFactions.getInstance().prefix + "§cErreur, la commande est §e/setmine <Nom> <x1> <y1> <z1> <x2> <y2> <z2> §c!");

                    }

                    if(args.length == 7){

                        new MinesRunnable().runTaskTimer(InsiFactions.instance, 0L, 20L).cancel();

                        String name = args[0];
                        int x1 = Integer.parseInt(args[1]);
                        int y1 = Integer.parseInt(args[2]);
                        int z1 = Integer.parseInt(args[3]);
                        int x2 = Integer.parseInt(args[4]);
                        int y2 = Integer.parseInt(args[5]);
                        int z2 = Integer.parseInt(args[6]);
                        int coalAmount = 15;
                        int ironAmount = 10;
                        int goldAmount = 6;
                        int redstoneAmount = 8;
                        int lapizAmount = 6;
                        int emeraldAmount = 3;
                        int diamondAmount = 2;

                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".x1", x1);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".y1", y1);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".z1", z1);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".x2", x2);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".y2", y2);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".z2", z2);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".reset-time.hours", 0);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".reset-time.minutes", 10);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name + ".reset-time.seconds", 0);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name  + ".minerals.coal-amount", 15);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name  + ".minerals.iron-amount", 10);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name  + ".minerals.gold-amount", 6);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name  + ".minerals.redstone-amount", 8);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name  + ".minerals.lapis-amount", 6);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name  + ".minerals.emerald-amount", 3);
                        InsiFactions.instance.configManager.getMinesConfiguration().set("mines." + name  + ".minerals.diamond-amount", 2);
                        InsiFactions.instance.configManager.saveMinesConfiguration();

                        ConfigurationSection minesSection = InsiFactions.instance.configManager.getMinesConfiguration().getConfigurationSection("mines");

                        for(String minesName : minesSection.getKeys(false)){

                            final int timerHours = InsiFactions.instance.configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.hours") * 3600;
                            final int timerMinutes = InsiFactions.instance.configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.minutes") * 60;
                            final int timerSeconds = InsiFactions.instance.configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.seconds");

                            InsiFactions.timerMines = timerHours + timerMinutes + timerSeconds;

                            InsiFactions.mines.add(new Mines(minesName, InsiFactions.timerMines, x1, y1, z1, x2, y2, z2, coalAmount, ironAmount, goldAmount, redstoneAmount, lapizAmount, emeraldAmount, diamondAmount));

                            new MinesRunnable().runTaskTimer(InsiFactions.instance, 0L, 20L);

                        }

                        p.sendMessage(InsiFactions.instance.prefix + "§aVous venez de créer la mine §e" + name + " §aentre les coordonnés §e" + x1 + " " + y1 + " " + z1 + " §a/ §e" + x2 + " " + y2 + " " + z2 + " §a!");

                    }

                } else {

                    p.sendMessage(InsiFactions.instance.prefix + "§cErreur, vous n'avez pas la permission d'éxecuter cette commande !");

                }

            }

        } else {

            sender.sendMessage(InsiFactions.instance.prefix + "§cErreur, vous devez être un joueur pour effectuer cette commande !");

        }

        return false;

    }

}
