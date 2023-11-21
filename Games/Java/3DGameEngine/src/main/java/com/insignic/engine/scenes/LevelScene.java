package com.insignic.engine.scenes;

import com.insignic.Window;
import com.insignic.engine.utils.Logger;

public class LevelScene extends Scene {

    public LevelScene(){

        Logger.info("Level Scene open !");

        Window.get().r = 1;
        Window.get().g = 1;
        Window.get().b = 1;

    }

    @Override
    public void update(float dt) {



    }

}
