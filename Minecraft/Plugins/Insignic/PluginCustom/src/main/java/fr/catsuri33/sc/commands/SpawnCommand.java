package fr.catsuri33.sc.commands;

import fr.catsuri33.sc.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 0){

                if(Main.configManager.getServerConfiguration().getString("server.spawn-location.world-name") == null){

                    player.sendMessage(Main.prefix + " §cErreur, le spawn du serveur n'a pas été défini !");
                    return false;

                }

                String spawnWorldName = Main.configManager.getServerConfiguration().getString("server.spawn-location.world-name");
                World world = Bukkit.getWorld(spawnWorldName);
                double spawnX = Main.configManager.getServerConfiguration().getDouble("server.spawn-location.x");
                double spawnY = Main.configManager.getServerConfiguration().getDouble("server.spawn-location.y");
                double spawnZ = Main.configManager.getServerConfiguration().getDouble("server.spawn-location.z");
                float spawnPitch = (float) Main.configManager.getServerConfiguration().getDouble("server.spawn-location.yaw");
                float spawnYaw = (float) Main.configManager.getServerConfiguration().getDouble("server.spawn-location.pitch");

                player.teleport(new Location(world, spawnX, spawnY, spawnZ, spawnYaw, spawnPitch));
                player.sendMessage(Main.prefix + " §aVous avez été téléporté au spawn du serveur !");
                return true;

            }

            if(args.length == 1){

                if(args[0].equalsIgnoreCase("set")){

                    if(player.isOp() || player.hasPermission("server.setspawn")){

                        String spawnWorldName = player.getLocation().getWorld().getName();
                        double spawnX = player.getLocation().getX();
                        double spawnY = player.getLocation().getY();
                        double spawnZ = player.getLocation().getZ();
                        double spawnPitch = player.getLocation().getPitch();
                        double spawnYaw = player.getLocation().getYaw();

                        Main.configManager.getServerConfiguration().set("server.spawn-location.world-name", spawnWorldName);
                        Main.configManager.getServerConfiguration().set("server.spawn-location.x", spawnX);
                        Main.configManager.getServerConfiguration().set("server.spawn-location.y", spawnY);
                        Main.configManager.getServerConfiguration().set("server.spawn-location.z", spawnZ);
                        Main.configManager.getServerConfiguration().set("server.spawn-location.yaw", spawnPitch);
                        Main.configManager.getServerConfiguration().set("server.spawn-location.pitch", spawnYaw);
                        Main.configManager.saveServerConfiguration();

                        player.sendMessage(Main.prefix + " §aVous avez défini le spawn du serveur sur le monde §6" + spawnWorldName + " §aaux coordonnés §6X:" + spawnX + ", Y:" + spawnY + ", Z:" + spawnZ + " §a!");
                        return true;


                    } else {

                        player.sendMessage(Main.prefix + " §cErreur, vous n'avez pas la permission d'exécuter cette commande !");
                        return false;

                    }

                } else {

                    player.sendMessage(Main.prefix + " §cErreur, la commande est §6/spawn <Set> §c!");
                    return false;

                }

            }

            if(args.length > 1){

                player.sendMessage(Main.prefix + " §cErreur, la commande est §6/spawn §c!");
                return false;

            }

        } else {

            sender.sendMessage(Main.prefix + " §cErreur, la commande ne peut etre effectuee que par un joueur !");
            return false;

        }

        return false;

    }

}
