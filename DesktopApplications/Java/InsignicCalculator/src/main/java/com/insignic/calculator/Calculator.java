package com.insignic.calculator;

import com.insignic.calculator.utils.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;

public class Calculator extends Application {

    private final int width = 400;
    private final int height = 600;

    public static void main(String args[]){

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        Logger.info("Starting the InsignicCalculator app !");
        long timeStart = System.currentTimeMillis();

        URL calculatorFMXLPath = new File("src/main/java/com/insignic/calculator/fxml/calculator.fxml").toURI().toURL();
        Parent calculatorFXML = FXMLLoader.load(calculatorFMXLPath);
        Scene calculatorScene = new Scene(calculatorFXML);

        stage.setTitle("InsignicCalculator");
        stage.setScene(calculatorScene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.show();

        Logger.success("App started in " + (System.currentTimeMillis() - timeStart) + "ms !");

    }

}

