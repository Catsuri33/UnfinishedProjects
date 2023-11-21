package com.insignic.controvert.core.inputs.controllers;

import com.insignic.controvert.core.inputs.Input;

import java.awt.event.KeyEvent;

public class UserController implements Controller {

    private Input input;

    public UserController(Input input){

        this.input = input;

    }

    @Override
    public boolean isUp() {

        return input.isPressed(KeyEvent.VK_UP);

    }

    @Override
    public boolean isDown() {

        return input.isPressed(KeyEvent.VK_DOWN);

    }

    @Override
    public boolean isLeft() {

        return input.isPressed(KeyEvent.VK_LEFT);

    }

    @Override
    public boolean isRight() {

        return input.isPressed(KeyEvent.VK_RIGHT);

    }

}
