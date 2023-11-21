package com.insignic.insiads.core.tasks;

import com.insignic.insiads.InsiAds;
import com.insignic.insiads.database.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AdsRunnable extends BukkitRunnable {

    public static int timer = 60;

    @Override
    public void run() {

        if(timer == 0){

            for(Player players : Bukkit.getOnlinePlayers()){

                if(InsiAds.lastAdtoUserMap.containsKey(players.getUniqueId())){

                    if(System.currentTimeMillis() >= (InsiAds.lastAdtoUserMap.get(players.getUniqueId()) + 3600000)){

                        InsiAds.lastAdtoUserMap.remove(players.getUniqueId());

                    }

                } else {

                    if(DatabaseManager.instance.isCampaignAvaible()){

                        String adCampaignName = DatabaseManager.instance.getRandomAdCampaignAvaible();
                        Integer adCampaignViews = DatabaseManager.instance.getAdCampaignViews(adCampaignName);
                        Double adCampaignPrice = DatabaseManager.instance.getAdCampaignPrice(adCampaignName);
                        Double totalMoney = DatabaseManager.instance.getTotalMoney();
                        Double avaibleMoney = DatabaseManager.instance.getAvaibleMoney();
                        Double payMoney = DatabaseManager.instance.getPayMoney();
                        Double serverMoney = DatabaseManager.instance.getServerMoney(InsiAds.getInstance().getConfig().getString("server.id"));
                        Float serverRate = DatabaseManager.instance.getRate(InsiAds.getInstance().getConfig().getString("server.id"));

                        players.sendMessage(" ");
                        players.sendMessage(DatabaseManager.instance.getAdCampaignMessage(adCampaignName));
                        players.sendMessage(" ");

                        InsiAds.lastAdtoUserMap.put(players.getUniqueId(), System.currentTimeMillis());
                        DatabaseManager.instance.setAdCampaignViews(adCampaignViews + 1, adCampaignName);
                        DatabaseManager.instance.setServerMoney(InsiAds.getInstance().getConfig().getString("server.id"), (serverMoney + adCampaignPrice) * serverRate);
                        DatabaseManager.instance.setTotalMoney(totalMoney + adCampaignPrice);
                        DatabaseManager.instance.setAvaibleMoney(avaibleMoney + (adCampaignPrice * (1 - serverRate)));
                        DatabaseManager.instance.setPayMoney(payMoney + (adCampaignPrice * serverRate));

                        if(DatabaseManager.instance.getAdCampaignViews(adCampaignName) >= DatabaseManager.instance.getAdCampaignViewsTo(adCampaignName)){

                            DatabaseManager.instance.setAdCampaignState(adCampaignName, "ended");

                        }

                    }

                }

            }

            timer = 60;

        }

        timer--;

    }

}
