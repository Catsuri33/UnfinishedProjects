package com.insignic;

import com.insignic.engine.Main;
import com.insignic.engine.listeners.JoystickListener;
import com.insignic.engine.listeners.KeyListener;
import com.insignic.engine.listeners.MouseListener;
import com.insignic.engine.scenes.LevelEditorScene;
import com.insignic.engine.scenes.LevelScene;
import com.insignic.engine.scenes.Scene;
import com.insignic.engine.utils.Logger;
import com.insignic.engine.utils.Time;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {

    private static Window window = null;
    private int width, height;
    private String title;
    private long glfwWindow;
    private static Scene currentScene;

    public float r, g, b, a;
    private boolean fadeToBlack = false;

    private Window(){

        this.width = 1920;
        this.height = 1080;
        this.title = Main.projectName;
        r = 1;
        g = 1;
        b = 1;
        a = 1;

    }

    public static void changeScene(int newScene){

        switch(newScene){

            case 0:
                currentScene = new LevelEditorScene();
                currentScene.init();
                break;
            case 1:
                currentScene = new LevelScene();
                currentScene.init();
                break;
            default:
                assert false : "Unkown scene '" + newScene + "' !";
                break;

        }

    }

    public static Window get(){

        if(Window.window == null){

            Window.window = new Window();

        }

        return Window.window;

    }

    public void run(){

        Logger.info("Starting LWJGL " + Version.getVersion() + " !");

        init();
        loop();

        // Free the memory
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        // Shutdown GLFW and free errors callbacks
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init(){

        // Setup Error Callback
        GLFWErrorCallback.createPrint(System.err).set();

        if(!glfwInit()){

            throw new IllegalStateException("Error, unable to initialize GLFW !");

        }

        // Initialize GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        // Create Window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, MemoryUtil.NULL, MemoryUtil.NULL);

        if(glfwWindow == MemoryUtil.NULL){

            throw new IllegalStateException("Error, failed to create the GLFW window !");

        }

        // Set Callbacks
        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);
        glfwSetKeyCallback(glfwWindow, KeyListener::keyCallback);
        glfwSetJoystickCallback(JoystickListener::joystickConfigurationCallback);

        // Make OpenGL the context
        glfwMakeContextCurrent(glfwWindow);

        // Enable V-Sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();

        // Init Scene
        Window.changeScene(0);

    }

    public void loop(){

        float beginTime = Time.getTime();
        float endTime;
        float dt = -1.0f;

        while(!glfwWindowShouldClose(glfwWindow)){

            // Poll Events
            glfwPollEvents();

            glClearColor(r, g, b, a);
            glClear(GL_COLOR_BUFFER_BIT);

            if(dt >= 0){

                currentScene.update(dt);

            }

            glfwSwapBuffers(glfwWindow);

            endTime = Time.getTime();
            dt = endTime - beginTime;
            beginTime = endTime;

        }

    }

}
