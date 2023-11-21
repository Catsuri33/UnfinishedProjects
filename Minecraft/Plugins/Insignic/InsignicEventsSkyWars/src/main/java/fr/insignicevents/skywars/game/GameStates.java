package fr.insignicevents.skywars.game;

public enum GameStates {

    LOBBY(true), PREGAME(false), GAME(false), FINISH(false);

    private static GameStates currentState;
    private boolean canJoin;

    GameStates(boolean canJoin){

        this.canJoin = canJoin;

    }

    public boolean canJoin() {

        return canJoin;

    }

    public static void setState(GameStates state) {

        currentState = state;

    }

    public static boolean isState(GameStates state) {

        return currentState == state;

    }

    public static GameStates getCurrentState() {

        return currentState;

    }
}
