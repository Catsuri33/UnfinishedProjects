package com.insignicnetwork.practice.core.divisions;

import com.insignicnetwork.practice.mysql.PracticeMySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DivisionsManager {

    public static void checkDivisions(UUID uuid){

        Player p = Bukkit.getPlayer(uuid);

        if(PracticeMySQL.getPlayerElo(uuid) <= 100){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.DIRTI.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 100 && PracticeMySQL.getPlayerElo(uuid) <= 200){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.DIRTII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 200 && PracticeMySQL.getPlayerElo(uuid) <= 300){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.DIRTIII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 300 && PracticeMySQL.getPlayerElo(uuid) <= 400){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.BRONZEI.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 400 && PracticeMySQL.getPlayerElo(uuid) <= 500){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.BRONZEII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 500 && PracticeMySQL.getPlayerElo(uuid) <= 600){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.BRONZEIII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 600 && PracticeMySQL.getPlayerElo(uuid) <= 800){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.PLATINUMI.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 800 && PracticeMySQL.getPlayerElo(uuid) <= 900){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.PLATINUMII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 900 && PracticeMySQL.getPlayerElo(uuid) <= 1000){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.PLATINUMIII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 1000 && PracticeMySQL.getPlayerElo(uuid) <= 1200){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.SILVERI.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 1200 && PracticeMySQL.getPlayerElo(uuid) <= 1400){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.SILVERII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 1400 && PracticeMySQL.getPlayerElo(uuid) <= 1600){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.SILVERIII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 1600 && PracticeMySQL.getPlayerElo(uuid) <= 1800){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.GOLDI.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 1800 && PracticeMySQL.getPlayerElo(uuid) <= 2000){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.GOLDII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 2000 && PracticeMySQL.getPlayerElo(uuid) <= 2200){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.GOLDIII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 2200 && PracticeMySQL.getPlayerElo(uuid) <= 2400){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.INFERIUMI.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 2400 && PracticeMySQL.getPlayerElo(uuid) <= 2600){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.INFERIUMII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) > 2600 && PracticeMySQL.getPlayerElo(uuid) <= 2800){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.INFERIUMIII.getName());

        }

        if(PracticeMySQL.getPlayerElo(uuid) >= 3000){

            PracticeMySQL.setPlayerDivision(uuid, DivisionList.INSIGNIC.getName());

        }

    }

}
