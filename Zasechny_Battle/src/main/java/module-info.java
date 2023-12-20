module com.example.zasechny_battle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.zasechny_battle to javafx.fxml;
    exports com.example.zasechny_battle;
    exports com.example.zasechny_battle.Controller;
    opens com.example.zasechny_battle.Controller to javafx.fxml;
}