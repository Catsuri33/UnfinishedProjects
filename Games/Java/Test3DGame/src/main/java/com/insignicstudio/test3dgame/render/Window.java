package com.insignicstudio.test3dgame.render;

import com.insignicstudio.test3dgame.state.SystemState;
import com.insignicstudio.test3dgame.utils.Logger;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.opengl.GL11.*;

public class Window {

    private static Window window;
    private long glfwWindow;
    private int width, height;
    private String title;

    private Window(){

        this.width = 1920;
        this.height = 1080;
        this.title = "Test3DGame";

    }

    public static Window get(){

        if(Window.window == null){

            Window.window = new Window();

        }

        return Window.window;

    }

    public void run(){

        Logger.info("Starting game...");
        Logger.info("LWJGL version " + Version.getVersion());

        init();
        loop();

        SystemState.setState(SystemState.END);

        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init(){

        long timeStartInit = System.currentTimeMillis();

        SystemState.setState(SystemState.START);

        GLFWErrorCallback.createPrint(System.err).set();

        if(!glfwInit()){

            Logger.error("Unable to initialize GLFW !");
            throw new IllegalStateException();

        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, MemoryUtil.NULL, MemoryUtil.NULL);

        if(glfwWindow == MemoryUtil.NULL){

            Logger.error("Failed to create the GLFW window !");
            throw new IllegalStateException();

        }

        glfwMakeContextCurrent(glfwWindow);
        glfwSwapInterval(1);

        glfwShowWindow(glfwWindow);

        GL.createCapabilities();

        long timeEndInit = System.currentTimeMillis() - timeStartInit;

        SystemState.setState(SystemState.RUN);

        Logger.success("Game started in " + timeEndInit + "ms !");

    }

    public void loop(){

        while(!glfwWindowShouldClose(glfwWindow)){

            glfwPollEvents();

            glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow);

        }

    }

}
