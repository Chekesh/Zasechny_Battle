package com.example.zasechny_battle.Controller;

import com.example.zasechny_battle.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HomeCont {
    @FXML
    public Label Text;

    @FXML
    void Members(MouseEvent event) {
        Transition.TransitionWindows(Text.getScene(), "Participants", true, true);
    }

    @FXML
    void New_Сompetitions(MouseEvent event) {
        Transition.TransitionWindows(Text.getScene(), "Сurrent_Competitions", true, true);
    }

    @FXML
    void Сompetitions(MouseEvent event) {
        Transition.TransitionWindows(Text.getScene(), "Competitions", true, true);
    }
}
