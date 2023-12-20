package com.example.zasechny_battle.Controller;

import com.example.zasechny_battle.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class AddParticipant {

    @FXML
    public Label Label;
    @FXML
    private TextField Club;

    @FXML
    private DatePicker Date_Birth;

    @FXML
    private TextField Insurance_policy;

    @FXML
    private TextField Medical_Certificate_id;

    @FXML
    private TextField Name;

    @FXML
    private TextField Number_pas;

    @FXML
    private TextField Patronymic;

    @FXML
    private TextField Series_pas;

    @FXML
    private TextField Surname;

    @FXML
    public void Add(MouseEvent event) {
        Transition.TransitionWindows(Label.getScene(), "Сurrent_Competitions", true,false);
    }

    @FXML
    public void Exit(MouseEvent event) {
        Transition.TransitionWindows(Label.getScene(), "Сurrent_Competitions", true,false);
    }
}
