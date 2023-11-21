package com.insignic.uhchost.listeners;

import com.insignic.uhchost.UHCHost;
import com.insignic.uhchost.game.guis.*;
import com.insignic.uhchost.twitter.TwitterActions;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.stream.Collectors;

public class PlayerClick implements Listener {

    private boolean hasTweeted = false;

    @EventHandler
    public void onPlayerClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null){

            return;

        }

        // Host Inventory
        if(e.getInventory().equals(HostCustomisationInventory.inv)){

            if(e.getSlot() == 9){

                p.openInventory(PvPInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                p.openInventory(BorderInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 13){

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("FFA")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "2vs2");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("2vs2")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "3vs3");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("3vs3")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "4vs4");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("4vs4")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "5vs5");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("5vs5")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "10vs10");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("10vs10")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "25vs25");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("25vs25")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "50vs50");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("50vs50")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.server.gamemode", "FFA");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    HostCustomisationInventory.createInventory();
                    p.openInventory(HostCustomisationInventory.inv);

                    e.setCancelled(true);
                    return;

                }

            }

            if(e.getSlot() == 14){

                p.openInventory(SlotsInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 17){

                p.openInventory(NetherInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 30){

                if(!hasTweeted){

                    if(!UHCHost.configManager.getSettingsConfiguration().getString("settings.server.name").equals("Null")){

                        if(!UHCHost.configManager.getSettingsConfiguration().getString("settings.server.ip").equals("Null")){

                            String hostNames;
                            hostNames = String.join(", ", UHCHost.hostList.stream().map(Player::getName).collect(Collectors.toList()));

                            if(SlotsInventory.spectator){

                                TwitterActions.postTweet("\uD83D\uDFE1 Game on " + UHCHost.configManager.getSettingsConfiguration().getString("settings.server.name") + " \uD83D\uDFE1\n\nHost(s): " + hostNames + "\nSlots: " + SlotsConfigurationInventory.slotsNumber + "\nSpectators: Enabled\nTeam Size: " + UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode") + "\nScenarios: \n\nIP: " + UHCHost.configManager.getSettingsConfiguration().getString("settings.server.ip"));

                            } else {

                                TwitterActions.postTweet("\uD83D\uDFE1 Game on " + UHCHost.configManager.getSettingsConfiguration().getString("settings.server.name") + " \uD83D\uDFE1\n\nHost(s): " + hostNames + "\nSlots: " + SlotsConfigurationInventory.slotsNumber + "\nSpectators: Disabled\nTeam Size: " + UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode") + "\nScenarios: \n\nIP: " + UHCHost.configManager.getSettingsConfiguration().getString("settings.server.ip"));

                            }

                            p.sendMessage(UHCHost.prefix + "§aVotre tweet a bien été envoyé !");
                            hasTweeted = true;
                            e.setCancelled(true);
                            return;

                        } else {

                            p.sendMessage(UHCHost.prefix + "§cErreur, veuillez contacter un Admin du serveur pour qu'il change l'ip du serveur dans le fichier settings.yml !");
                            e.setCancelled(true);
                            return;

                        }

                    } else {

                        p.sendMessage(UHCHost.prefix + "§cErreur, veuillez contacter un Admin du serveur pour qu'il change le nom du serveur dans le fichier settings.yml !");
                        e.setCancelled(true);
                        return;

                    }

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous êtes limité à 1 tweet par partie !");
                    e.setCancelled(true);
                    return;

                }

            }

            if(e.getSlot() == 35){

                p.openInventory(SettingsInventory.inv);
                e.setCancelled(true);
                return;

            }

        }

        // Setting Inventory
        if(e.getInventory().equals(SettingsInventory.inv)){

            if(e.getSlot() == 10){

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("All")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.lobby-floor", "OnlyTeam");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    p.sendMessage(UHCHost.prefix + "§aVous avez changé les paramètres du sol du lobby en: §eEquipes Uniquement §a!");
                    SettingsInventory.createInventory();
                    p.openInventory(SettingsInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("OnlyTeam")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.lobby-floor", "OnlyDefault");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    p.sendMessage(UHCHost.prefix + "§aVous avez changé les paramètres du sol du lobby en: §eMulticolore Uniquement §a!");
                    SettingsInventory.createInventory();
                    p.openInventory(SettingsInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("OnlyDefault")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.lobby-floor", "Deactivated");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    p.sendMessage(UHCHost.prefix + "§aVous avez changé les paramètres du sol du lobby en: §eDésactivé §a!");
                    SettingsInventory.createInventory();
                    p.openInventory(SettingsInventory.inv);

                    e.setCancelled(true);
                    return;

                }

                if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("Deactivated")){

                    UHCHost.configManager.getSettingsConfiguration().set("settings.lobby-floor", "All");
                    UHCHost.configManager.saveSettingsConfiguration();
                    UHCHost.configManager.reloadSettingsConfiguration();

                    p.sendMessage(UHCHost.prefix + "§aVous avez changé les paramètres du sol du lobby en: §eTout §a!");
                    SettingsInventory.createInventory();
                    p.openInventory(SettingsInventory.inv);

                    e.setCancelled(true);
                    return;

                }

            }

            if(e.getSlot() == 22){

                p.openInventory(HostCustomisationInventory.inv);
                e.setCancelled(true);
                return;

            }

        }

        // Border Inventory
        if(e.getInventory().equals(BorderInventory.inv)){

            if(e.getSlot() == 11){

                p.openInventory(BorderTimeBegunInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                p.openInventory(BorderSizeStartInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 13){

                p.openInventory(BorderDamageInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                p.openInventory(BorderSizeEndInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                p.openInventory(BorderTimeCenterInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(HostCustomisationInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Border Size Start Inventory
        if(e.getInventory().equals(BorderSizeStartInventory.inv)){

            if(e.getSlot() == 10){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                if((wb.getSize() - 50) >= 50){

                    wb.setSize(wb.getSize() - 50);
                    BorderSizeStartInventory.createInventory();
                    p.openInventory(BorderSizeStartInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre la taille de la bordure en dessous de 50 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 11){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                if((wb.getSize() - 10) >= 50){

                    wb.setSize(wb.getSize() - 10);
                    BorderSizeStartInventory.createInventory();
                    p.openInventory(BorderSizeStartInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre la taille de la bordure en dessous de 50 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                if((wb.getSize() - 5) >= 50){

                    wb.setSize(wb.getSize() - 5);
                    BorderSizeStartInventory.createInventory();
                    p.openInventory(BorderSizeStartInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre la taille de la bordure en dessous de 50 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                wb.setSize(wb.getSize() + 5);
                BorderSizeStartInventory.createInventory();
                p.openInventory(BorderSizeStartInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                wb.setSize(wb.getSize() + 10);
                BorderSizeStartInventory.createInventory();
                p.openInventory(BorderSizeStartInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 16){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                wb.setSize(wb.getSize() + 50);
                BorderSizeStartInventory.createInventory();
                p.openInventory(BorderSizeStartInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(BorderInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Border Size End Inventory
        if(e.getInventory().equals(BorderSizeEndInventory.inv)){

            if(e.getSlot() == 10){

                if((BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd - 50) >= 50){

                    BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd - 50;
                    BorderSizeEndInventory.createInventory();
                    p.openInventory(BorderSizeEndInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre la taille de la bordure en dessous de 50 !");
                    BorderSizeEndInventory.borderEnd = 50;
                    BorderSizeEndInventory.createInventory();
                    p.openInventory(BorderSizeEndInventory.inv);

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 11){

                if((BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd - 10) >= 50){

                    BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd - 10;
                    BorderSizeEndInventory.createInventory();
                    p.openInventory(BorderSizeEndInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre la taille de la bordure en dessous de 50 !");
                    BorderSizeEndInventory.borderEnd = 50;
                    BorderSizeEndInventory.createInventory();
                    p.openInventory(BorderSizeEndInventory.inv);

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                if((BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd - 5) >= 50){

                    BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd - 5;
                    BorderSizeEndInventory.createInventory();
                    p.openInventory(BorderSizeEndInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre la taille de la bordure en dessous de 50 !");
                    BorderSizeEndInventory.borderEnd = 50;
                    BorderSizeEndInventory.createInventory();
                    p.openInventory(BorderSizeEndInventory.inv);

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd + 5;
                BorderSizeEndInventory.createInventory();
                p.openInventory(BorderSizeEndInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd + 10;
                BorderSizeEndInventory.createInventory();
                p.openInventory(BorderSizeEndInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 16){

                BorderSizeEndInventory.borderEnd = BorderSizeEndInventory.borderEnd + 50;
                BorderSizeEndInventory.createInventory();
                p.openInventory(BorderSizeEndInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(BorderInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Border Time Begun Inventory
        if(e.getInventory().equals(BorderTimeBegunInventory.inv)){

            if(e.getSlot() == 10){

                if((BorderTimeBegunInventory.timeBorderBegun - 60) >= 60){

                    BorderTimeBegunInventory.timeBorderBegun = BorderTimeBegunInventory.timeBorderBegun - 60;
                    BorderTimeBegunInventory.createInventory();
                    p.openInventory(BorderTimeBegunInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant que la bordure bouge en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 11){

                if((BorderTimeBegunInventory.timeBorderBegun - 10) >= 60){

                    BorderTimeBegunInventory.timeBorderBegun = BorderTimeBegunInventory.timeBorderBegun - 10;
                    BorderTimeBegunInventory.createInventory();
                    p.openInventory(BorderTimeBegunInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant que la bordure bouge en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                if((BorderTimeBegunInventory.timeBorderBegun - 5) >= 60){

                    BorderTimeBegunInventory.timeBorderBegun = BorderTimeBegunInventory.timeBorderBegun - 5;
                    BorderTimeBegunInventory.createInventory();
                    p.openInventory(BorderTimeBegunInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant que la bordure bouge en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                BorderTimeBegunInventory.timeBorderBegun = BorderTimeBegunInventory.timeBorderBegun + 5;
                BorderTimeBegunInventory.createInventory();
                p.openInventory(BorderTimeBegunInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                BorderTimeBegunInventory.timeBorderBegun = BorderTimeBegunInventory.timeBorderBegun + 10;
                BorderTimeBegunInventory.createInventory();
                p.openInventory(BorderTimeBegunInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 16){

                BorderTimeBegunInventory.timeBorderBegun = BorderTimeBegunInventory.timeBorderBegun + 60;
                BorderTimeBegunInventory.createInventory();
                p.openInventory(BorderTimeBegunInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(BorderInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Border Damage Inventory
        if(e.getInventory().equals(BorderDamageInventory.inv)){

            if(e.getSlot() == 10){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                if((wb.getDamageAmount() - 10) >= 1){

                    wb.setDamageAmount(wb.getDamageAmount() - 10);
                    BorderDamageInventory.createInventory();
                    p.openInventory(BorderDamageInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre les dégâts de la bordure en dessous de 1 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 11){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                if((wb.getDamageAmount() - 5) >= 1){

                    wb.setDamageAmount(wb.getDamageAmount() - 5);
                    BorderDamageInventory.createInventory();
                    p.openInventory(BorderDamageInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre les dégâts de la bordure en dessous de 1 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                if((wb.getDamageAmount() - 1) >= 1){

                    wb.setDamageAmount(wb.getDamageAmount() - 1);
                    BorderDamageInventory.createInventory();
                    p.openInventory(BorderDamageInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre les dégâts de la bordure en dessous de 1 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                wb.setDamageAmount(wb.getDamageAmount() + 1);
                BorderDamageInventory.createInventory();
                p.openInventory(BorderDamageInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                wb.setDamageAmount(wb.getDamageAmount() + 5);
                BorderDamageInventory.createInventory();
                p.openInventory(BorderDamageInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 16){

                WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

                wb.setDamageAmount(wb.getDamageAmount() + 10);
                BorderDamageInventory.createInventory();
                p.openInventory(BorderDamageInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(BorderInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Border Time Center Inventory
        if(e.getInventory().equals(BorderTimeCenterInventory.inv)){

            if(e.getSlot() == 10){

                if((BorderTimeCenterInventory.timeBorderCenter - 60) >= 60){

                    BorderTimeCenterInventory.timeBorderCenter = BorderTimeCenterInventory.timeBorderCenter - 60;
                    BorderTimeCenterInventory.createInventory();
                    p.openInventory(BorderTimeCenterInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant que la bordure arrive au centre en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 11){

                if((BorderTimeCenterInventory.timeBorderCenter - 10) >= 60){

                    BorderTimeCenterInventory.timeBorderCenter = BorderTimeCenterInventory.timeBorderCenter - 10;
                    BorderTimeCenterInventory.createInventory();
                    p.openInventory(BorderTimeCenterInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant que la bordure arrive au centre en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                if((BorderTimeCenterInventory.timeBorderCenter - 5) >= 60){

                    BorderTimeCenterInventory.timeBorderCenter = BorderTimeCenterInventory.timeBorderCenter - 5;
                    BorderTimeCenterInventory.createInventory();
                    p.openInventory(BorderTimeCenterInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant que la bordure arrive au centre en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                BorderTimeCenterInventory.timeBorderCenter = BorderTimeCenterInventory.timeBorderCenter + 5;
                BorderTimeCenterInventory.createInventory();
                p.openInventory(BorderTimeCenterInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                BorderTimeCenterInventory.timeBorderCenter = BorderTimeCenterInventory.timeBorderCenter + 10;
                BorderTimeCenterInventory.createInventory();
                p.openInventory(BorderTimeCenterInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 16){

                BorderTimeCenterInventory.timeBorderCenter = BorderTimeCenterInventory.timeBorderCenter + 60;
                BorderTimeCenterInventory.createInventory();
                p.openInventory(BorderTimeCenterInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(BorderInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Slots Inventory
        if(e.getInventory().equals(SlotsInventory.inv)) {

            if (e.getSlot() == 12) {

                p.openInventory(SlotsConfigurationInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                if(SlotsInventory.spectator){

                    SlotsInventory.spectator = false;
                    SlotsInventory.createInventory();
                    p.openInventory(SlotsInventory.inv);

                    e.setCancelled(true);
                    return;

                } else {

                    SlotsInventory.spectator = true;
                    SlotsInventory.createInventory();
                    p.openInventory(SlotsInventory.inv);

                    e.setCancelled(true);
                    return;

                }

            }

            if(e.getSlot() == 22){

                p.openInventory(HostCustomisationInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Slots Configuration Inventory
        if(e.getInventory().equals(SlotsConfigurationInventory.inv)){

            if(e.getSlot() == 10){

                if((SlotsConfigurationInventory.slotsNumber - 10) >= 2){

                    SlotsConfigurationInventory.slotsNumber = SlotsConfigurationInventory.slotsNumber - 10;
                    SlotsConfigurationInventory.createInventory();
                    p.openInventory(SlotsConfigurationInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le nombre de slots en dessous de 2 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 11){

                if((SlotsConfigurationInventory.slotsNumber - 5) >= 2){

                    SlotsConfigurationInventory.slotsNumber = SlotsConfigurationInventory.slotsNumber - 5;
                    SlotsConfigurationInventory.createInventory();
                    p.openInventory(SlotsConfigurationInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le nombre de slots en dessous de 2 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                if((SlotsConfigurationInventory.slotsNumber - 1) >= 2){

                    SlotsConfigurationInventory.slotsNumber = SlotsConfigurationInventory.slotsNumber - 1;
                    SlotsConfigurationInventory.createInventory();
                    p.openInventory(SlotsConfigurationInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le nombre de slots en dessous de 2 !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                SlotsConfigurationInventory.slotsNumber = SlotsConfigurationInventory.slotsNumber + 1;
                SlotsConfigurationInventory.createInventory();
                p.openInventory(SlotsConfigurationInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                SlotsConfigurationInventory.slotsNumber = SlotsConfigurationInventory.slotsNumber + 5;
                SlotsConfigurationInventory.createInventory();
                p.openInventory(SlotsConfigurationInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 16){

                SlotsConfigurationInventory.slotsNumber = SlotsConfigurationInventory.slotsNumber + 10;
                SlotsConfigurationInventory.createInventory();
                p.openInventory(SlotsConfigurationInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(SlotsInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Nether Inventory
        if(e.getInventory().equals(NetherInventory.inv)) {

            if(e.getSlot() == 12){

                if(NetherInventory.netherState){

                    NetherInventory.netherState = false;

                    NetherInventory.createInventory();
                    p.openInventory(NetherInventory.inv);

                    e.setCancelled(true);
                    return;

                } else {

                    NetherInventory.netherState = true;

                    NetherInventory.createInventory();
                    p.openInventory(NetherInventory.inv);

                    e.setCancelled(true);
                    return;

                }

            }

            if(e.getSlot() == 14){

                PotionsInventory.createInventory();
                p.openInventory(PotionsInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(HostCustomisationInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // Potions Inventory
        if(e.getInventory().equals(PotionsInventory.inv)) {

            if(e.getSlot() == 0){

                if(PotionsInventory.night_vision_1_potion){

                    PotionsInventory.night_vision_1_potion = false;

                    PotionsInventory.createInventory();
                    p.openInventory(PotionsInventory.inv);

                    e.setCancelled(true);
                    return;

                } else {

                    PotionsInventory.night_vision_1_potion = true;

                    PotionsInventory.createInventory();
                    p.openInventory(PotionsInventory.inv);

                    e.setCancelled(true);
                    return;

                }

            }

            if(e.getSlot() == 22){

                p.openInventory(NetherInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // PvP Inventory
        if(e.getInventory().equals(PvPInventory.inv)) {

            if(e.getSlot() == 12){

                if(PvPInventory.isPvPClassic){

                    PvPInventory.isPvPClassic = false;

                    PvPInventory.createInventory();
                    p.openInventory(PvPInventory.inv);

                    e.setCancelled(true);
                    return;

                } else {

                    PvPInventory.isPvPClassic = true;

                    PvPInventory.createInventory();
                    p.openInventory(PvPInventory.inv);

                    e.setCancelled(true);
                    return;

                }

            }

            if(e.getSlot() == 14){

                p.openInventory(PvPTimeInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(HostCustomisationInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        // PvP Time Inventory
        if(e.getInventory().equals(PvPTimeInventory.inv)){

            if(e.getSlot() == 10){

                if((PvPTimeInventory.pvpTime - 60) >= 60){

                    PvPTimeInventory.pvpTime = PvPTimeInventory.pvpTime - 60;
                    PvPTimeInventory.createInventory();
                    p.openInventory(PvPTimeInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant le PvP en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 11){

                if((PvPTimeInventory.pvpTime - 10) >= 60){

                    PvPTimeInventory.pvpTime = PvPTimeInventory.pvpTime - 10;
                    PvPTimeInventory.createInventory();
                    p.openInventory(PvPTimeInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant le PvP en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 12){

                if((PvPTimeInventory.pvpTime - 5) >= 60){

                    PvPTimeInventory.pvpTime = PvPTimeInventory.pvpTime - 5;
                    PvPTimeInventory.createInventory();
                    p.openInventory(PvPTimeInventory.inv);

                } else {

                    p.sendMessage(UHCHost.prefix + "§cErreur, vous ne pouvez pas descendre le temps avant le PvP en dessous de 1 minute !");

                }

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 14){

                PvPTimeInventory.pvpTime = PvPTimeInventory.pvpTime + 5;
                PvPTimeInventory.createInventory();
                p.openInventory(PvPTimeInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 15){

                PvPTimeInventory.pvpTime = PvPTimeInventory.pvpTime + 10;
                PvPTimeInventory.createInventory();
                p.openInventory(PvPTimeInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 16){

                PvPTimeInventory.pvpTime = PvPTimeInventory.pvpTime + 60;
                PvPTimeInventory.createInventory();
                p.openInventory(PvPTimeInventory.inv);

                e.setCancelled(true);
                return;

            }

            if(e.getSlot() == 22){

                p.openInventory(PvPInventory.inv);

                e.setCancelled(true);
                return;

            }

        }

        if(!p.getGameMode().equals(GameMode.CREATIVE)) {

            e.setCancelled(true);

        }

    }

}
