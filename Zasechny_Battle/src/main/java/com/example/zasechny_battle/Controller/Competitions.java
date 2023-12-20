package com.example.zasechny_battle.Controller;

import com.example.zasechny_battle.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Competitions {

    @FXML
    private Label Text;

    @FXML
    void Exit(MouseEvent event) {
        Transition.TransitionWindows(Text.getScene(), "Home", true, true);
    }

}