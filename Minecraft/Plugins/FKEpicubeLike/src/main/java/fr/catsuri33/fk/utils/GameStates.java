package fr.catsuri33.fk.utils;

public enum GameStates {

    WAITING,
    GAME,
    ASSAULTS,
    DEATHMATCH;

    private static GameStates currentState;

    public static boolean isState(GameStates state){

        return  currentState == state;

    }

    public static GameStates getState(){

        return currentState;

    }

    public static void setState(GameStates state){

        currentState = state;

    }

}
