package com.insignic.calculator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    double x, y;

    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }

    @FXML
    void windowDragged(MouseEvent e){

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setX(e.getScreenX() - x);
        stage.setY(e.getScreenY() - y);

    }

    @FXML
    void windowPressed(MouseEvent e){

        x = e.getSceneX();
        y = e.getSceneY();

    }

    @FXML
    private void closeWindow(MouseEvent e){

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    private void minimizeWindow(MouseEvent e){

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setIconified(true);

    }

}
