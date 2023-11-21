package com.insignic.lifebuyer.engine.listeners;

import com.insignic.lifebuyer.utils.Logger;

import static org.lwjgl.glfw.GLFW.GLFW_CONNECTED;
import static org.lwjgl.glfw.GLFW.GLFW_DISCONNECTED;

public class JoystickListener {

    private static JoystickListener instance;

    private JoystickListener(){



    }

    public static JoystickListener get(){

        if(instance == null){

            instance = new JoystickListener();

        }

        return instance;

    }

    public static void joystickAxesCallback(long window, float axes){



    }

    public static void joystickButtonCallback(long window, int button){



    }

    public static void joystickHatStateCallback(long window, int hats){



    }

    public static void joystickConfigurationCallback(long window, int action){

        if(action == GLFW_CONNECTED){

            Logger.info("Joystick connected !");

        } else if(action == GLFW_DISCONNECTED){

            Logger.info("Joystick disconnected !");

        }

    }

}
