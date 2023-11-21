package com.insignicstudio.test3dgame.state;

import java.util.Arrays;

public enum SystemState {

    START("Start", 1),
    RUN("Run", 2),
    END("End", 0);

    private String name;
    private int state;
    private static SystemState currentState;

    SystemState(String name, int state){

        this.name = name;
        this.state = state;

    }

    public String getName() {

        return name;

    }

    public static SystemState getCurrentState() {

        return currentState;

    }

    public static void setState(SystemState state) {

        currentState = state;

    }

    public static boolean isState(SystemState ... state){

        return Arrays.asList(state).contains(currentState);

    }

}
