module com.insignic.calculator {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.insignic.calculator to javafx.fxml;
    exports com.insignic.calculator;

    opens com.insignic.calculator.controller to javafx.fxml;
    exports com.insignic.calculator.controller;

}