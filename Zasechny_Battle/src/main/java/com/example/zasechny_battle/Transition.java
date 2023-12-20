package com.example.zasechny_battle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class Transition {
    public static void TransitionWindows(Scene sceneclos, String name, Boolean close, Boolean open){// double width, double height, boolean variability) throws IOException {
        if(close){
            sceneclos.getWindow().hide();
        }
        if(open) {
            FXMLLoader fxmlLoader = new FXMLLoader(Transition.class.getResource(name + ".fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            //stage.setFullScreen(true);
            stage.setTitle(name);
        /*if(variability){
            stage.setMinWidth(750);
            stage.setMinHeight(550);
        }
        stage.setResizable(variability);*/
            stage.show();
        }
    }
    public static void Alert(String setHeaderText, String ContentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Диологовое окно");
        alert.setHeaderText(setHeaderText);
        alert.setContentText(ContentText);
        alert.showAndWait();
    }
}
