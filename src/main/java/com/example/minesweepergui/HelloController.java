package com.example.minesweepergui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText2;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText2.setText("Welcome to JavaFX Application!");
    }
}