package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import fr.catsuri33.insiserveressential.lang.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SetSlots implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("setslots")){

            if(sender.isOp() || sender.hasPermission("insiserveressential.setslots")){

                if (args.length <= 0) {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify arguments ! §c/setslots <Amount> §c!");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier des arguments ! §e/setslots <Nombre> §c!");

                    }

                }

                if (args.length == 1) {

                    if(isInt(args[0])){

                        String slotsString = args[0];
                        int slotsInt = Integer.parseInt(slotsString);

                        setupSlots(slotsInt);

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed the number of server slots to §e" + slotsInt + "§a.");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé le nombre de slots du serveur en §e" + slotsInt + "§a.");

                        }

                    } else {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_EN.getMessage());

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_FR.getMessage());

                        }

                    }

                }

                if (args.length > 1) {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_SETSLOTS_EN.getMessage());

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_SETSLOTS_FR.getMessage());

                    }

                }

            } else {

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                    sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_PERMISSION_EN.getMessage());

                }

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                    sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_PERMISSION_FR.getMessage());

                }

            }

            return true;

        }

        return false;

    }

    private void setupSlots(int slots){

        try {

            this.changeSlots(slots);

        } catch(ReflectiveOperationException e) {

            e.printStackTrace();

        }

    }

    public void changeSlots(int slots) throws ReflectiveOperationException {

        Method serverGetHandle = Bukkit.getServer().getClass().getDeclaredMethod("getHandle");

        Object playerList = serverGetHandle.invoke(Bukkit.getServer());
        Field maxPlayersField = playerList.getClass().getSuperclass().getDeclaredField("maxPlayers");

        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerList, slots);

    }

    public static boolean isInt(String s) {

        try {

            Integer.parseInt(s);

        } catch (NumberFormatException nfe) {

            return false;

        }

        return true;

    }

}
