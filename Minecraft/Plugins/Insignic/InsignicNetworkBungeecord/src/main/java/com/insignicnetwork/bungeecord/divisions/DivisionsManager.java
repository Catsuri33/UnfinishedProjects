package com.insignicnetwork.bungeecord.divisions;

import com.insignicnetwork.bungeecord.mysql.CTFMySQL;

import java.util.UUID;

public class DivisionsManager {

    public static void checkDivisions(UUID uuid){

        if(CTFMySQL.getPlayerElo(uuid) <= 100){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.DIRTI.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 100 && CTFMySQL.getPlayerElo(uuid) <= 200){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.DIRTII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 200 && CTFMySQL.getPlayerElo(uuid) <= 300){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.DIRTIII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 300 && CTFMySQL.getPlayerElo(uuid) <= 400){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.BRONZEI.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 400 && CTFMySQL.getPlayerElo(uuid) <= 500){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.BRONZEII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 500 && CTFMySQL.getPlayerElo(uuid) <= 600){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.BRONZEIII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 600 && CTFMySQL.getPlayerElo(uuid) <= 800){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.PLATINUMI.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 800 && CTFMySQL.getPlayerElo(uuid) <= 900){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.PLATINUMII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 900 && CTFMySQL.getPlayerElo(uuid) <= 1000){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.PLATINUMIII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 1000 && CTFMySQL.getPlayerElo(uuid) <= 1200){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.SILVERI.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 1200 && CTFMySQL.getPlayerElo(uuid) <= 1400){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.SILVERII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 1400 && CTFMySQL.getPlayerElo(uuid) <= 1600){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.SILVERIII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 1600 && CTFMySQL.getPlayerElo(uuid) <= 1800){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.GOLDI.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 1800 && CTFMySQL.getPlayerElo(uuid) <= 2000){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.GOLDII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 2000 && CTFMySQL.getPlayerElo(uuid) <= 2200){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.GOLDIII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 2200 && CTFMySQL.getPlayerElo(uuid) <= 2400){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.INFERIUMI.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 2400 && CTFMySQL.getPlayerElo(uuid) <= 2600){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.INFERIUMII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) > 2600 && CTFMySQL.getPlayerElo(uuid) <= 2800){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.INFERIUMIII.getName());

        }

        if(CTFMySQL.getPlayerElo(uuid) >= 3000){

            CTFMySQL.setPlayerDivision(uuid, DivisionList.INSIGNIC.getName());

        }

    }

}
