package com.insignic.controvert;

import javax.swing.*;

public class Controvert {

    public static String projectName = "Controvert";
    public static String projectVersion = "1.0.0";

    public static void main(String args[]){

        createWindow();

    }

    private static void createWindow(){

        JFrame frame = new JFrame();

        frame.setTitle("Controvert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 600);

        ImageIcon image = new ImageIcon("medias/images/controvert.png");
        frame.setIconImage(image.getImage());

        frame.setVisible(true);

    }

}
