package com.insignic.uhchost.game;

import java.util.Arrays;

public enum GameStates {

    LOBBY(false),
    GAME(false),
    GAME_PVP(false),
    END(false);

    private boolean state;
    private static GameStates currentState;

    GameStates(boolean state){

        this.state = state;

    }

    public static void setState(GameStates gameState) {

        currentState = gameState;

    }

    public static boolean isState(GameStates ... gameState){

        return Arrays.asList(gameState).contains(currentState);

    }

    public static GameStates getCurrentState() {

        return currentState;

    }

}
