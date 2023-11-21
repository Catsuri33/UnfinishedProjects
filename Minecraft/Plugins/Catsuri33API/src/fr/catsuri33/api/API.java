/*                              */
/*       Catsuri33API           */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 07/08/2019       */
/*    Updated: 11/08/2019       */
/*    Name: API                 */
/*                              */

package fr.catsuri33.api;

import fr.catsuri33.api.npcs.NPCManager;
import org.bukkit.plugin.java.JavaPlugin;

public class API extends JavaPlugin {

    private static API instance;

    public NPCManager npcManager;

    @Override
    public void onEnable(){

        instance = this;

        npcManager = new NPCManager();

    }

    @Override
    public void onDisable(){



    }

    public static API getInstance(){

        return instance;

    }

}
