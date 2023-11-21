package com.insignicstudio.test3dgame;

import com.insignicstudio.test3dgame.render.Window;

public class Test3DGame {

    private static Test3DGame instance;

    public static void main(String[] args) {

        Window window = Window.get();
        window.run();

    }
    
    public Test3DGame getInstance(){
        
        return instance;
        
    }

}
