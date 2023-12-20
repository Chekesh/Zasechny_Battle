package com.example.zasechny_battle.Controller;

import com.example.zasechny_battle.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

public class Participants {
    @FXML
    public TableColumn ID_user;
    @FXML
    public Button btn;

    @FXML
    public void Add_Participant(MouseEvent event) {
        Transition.TransitionWindows(btn.getScene(), "Add_Participant", false, true);

    }
}
