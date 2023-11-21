package fr.catsuri33.uhc.game;

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

    public static Gamestates getState(){

        return currentState;

    }

}
