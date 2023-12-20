package com.example.zasechny_battle.Controller;

import com.example.zasechny_battle.Database;
import com.example.zasechny_battle.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Date;

public class New_Competitions {
    @FXML
    public TextField place;
    @FXML
    private DatePicker date;

    Database database = new Database();

    @FXML
    void Сreate(MouseEvent event) {
        if(date.getValue().toString().trim().isEmpty() && place.getText().trim().isEmpty()) {
            database.CreateCompetitions(date.getValue().toString().trim(), place.getText().trim());
            Transition.TransitionWindows(date.getScene(), "Сurrent_Competitions", true, false);
        } else {
            Transition.Alert("Ошибка", "Заполните данные");
        }
    }

    public void Exit(MouseEvent event) {
        Transition.TransitionWindows(date.getScene(), "Сurrent_Competitions", true,false);
    }
}
