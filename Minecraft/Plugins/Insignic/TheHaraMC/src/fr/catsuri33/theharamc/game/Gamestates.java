/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: Gamestates          */
/*                              */

package fr.catsuri33.theharamc.game;

public enum Gamestates {

    LOBBY(true), PREGAME(false), GAME(false), GAMEPVP(false), END(false);

    private boolean canJoin;
    private static Gamestates currentState;

    Gamestates(boolean canJoin){

        this.canJoin = canJoin;

    }

    public boolean canJoin(){

        return canJoin;

    }

    public static void setState(Gamestates state){

        Gamestates.currentState = state;

    }

    public static boolean isState(Gamestates state){

        return Gamestates.currentState == state;

    }

}
