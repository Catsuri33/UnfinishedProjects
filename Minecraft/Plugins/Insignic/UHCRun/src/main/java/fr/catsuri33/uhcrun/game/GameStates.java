package fr.catsuri33.uhcrun.game;

public enum GameStates {

    LOBBY(true), PREGAME(false), GAME(false), MEETUP(false), END(false);

    private boolean canJoin;
    private static GameStates state;

    GameStates(boolean canJoin){

        this.canJoin = canJoin;

    }

    public boolean canJoin(){

        return canJoin;

    }

    public static void setState(GameStates state) {

        GameStates.state = state;

    }

    public static boolean isState(GameStates state) {

        return GameStates.state == state;

    }

    public static GameStates getState() {

        return state;

    }
}
