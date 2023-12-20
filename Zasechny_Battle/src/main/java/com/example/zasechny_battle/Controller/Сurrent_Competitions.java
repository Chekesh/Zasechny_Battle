package com.example.zasechny_battle.Controller;

import com.example.zasechny_battle.Database;
import com.example.zasechny_battle.Transition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class Сurrent_Competitions {
    @FXML
    public ChoiceBox Age;
    @FXML
    public ChoiceBox Category;
    @FXML
    private ChoiceBox Competition;
    Database database = new Database();

    String data = null;

    @FXML
    void initialize() {
        UpdaateChoiceBox();
        Competition.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> Replaced_Label(newValue));

        Category.getItems().addAll("5-7", "8-9", "10-11", "12-13", "14-15", "16-17", "18<");
        Age.getItems().addAll("Лёгкая", "Средняя", "Тяжёлая", "Абсолютная");
    }

    @FXML
    void Exit(MouseEvent event) {
        Transition.TransitionWindows(Competition.getScene(), "Home", true, true);
    }

    @FXML
    void NewCompetition(MouseEvent event) {
        Transition.TransitionWindows(Competition.getScene(), "New_Competitions", false, true);
    }

    void UpdaateChoiceBox(){
        Competition.getItems().clear();
        List<String> compet = database.Get_Title();
        Competition.getItems().addAll(compet);
    }

    public void Close(MouseEvent event) {
        if(data != null){
            database.ClosureCompetitions(data);
            UpdaateChoiceBox();
        }else {
            Transition.Alert("Ошибка", "Соревнования не выбраны");
        }
    }
    public void Replaced_Label(Object newValue) {
        if (newValue != null) {
            data = newValue.toString().substring(0, 10);
        }
    }

    public void Add_Participant(MouseEvent event) {
        Transition.TransitionWindows(Competition.getScene(), "Add_Participant", false, true);
    }
}
