package fr.catsuri33.lguhc.game;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public enum Gamestates {

    LOBBY, GAME, GAMEPVP, END;

    private static Gamestates currentState;

    public static void setState(Gamestates state){

        Gamestates.currentState = state;

    }

    public static boolean isState(Gamestates state){

        return Gamestates.currentState == state;

    }

}
