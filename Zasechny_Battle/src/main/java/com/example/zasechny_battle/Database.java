package com.example.zasechny_battle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    Connection dbConnection;

    public Database() {
        getDbConnection();
    }

    public void getDbConnection() {
        String connectionString = "jdbc:mysql://localhost:3306/Zasechny";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, "root", "1234");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateCompetitions(String date, String place){
        String request = "INSERT INTO competitions (`Date`, `Location_Event`, `Registration`) VALUES (?, ?, ?);";
        try {
            //Date date1 = dateFormat.parse(date);
            PreparedStatement prSt = dbConnection.prepareStatement(request);
            prSt.setString(1, date);
            prSt.setString(2, place);
            prSt.setString(3, "Открыта");
            prSt.executeUpdate();
            Transition.Alert("Успешно", "Запись созданна");
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Не правильно введены данные");
            throw new RuntimeException(e);
        }
    }

    public void ClosureCompetitions(String date){
        String request = //"SET sql_safe_updates = 0;" +
                "UPDATE competitions SET Registration = 'Закрыта' WHERE (Date = ?);";// +
                //"SET sql_safe_updates = 1;";
        try {
            //Date date1 = dateFormat.parse(date);
            PreparedStatement prSt = dbConnection.prepareStatement(request);
            prSt.setString(1, date);
            prSt.executeUpdate();
            Transition.Alert("Успешно", "Запись обнавлена");
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Не правильно введены данные");
            throw new RuntimeException(e);
        }
    }

    public List<String> Get_Title() {
        List<String> list = new ArrayList<>();
        String request = "SELECT Date, Location_Event FROM competitions WHERE Registration = ? ";
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(request);
            prSt.setString(1, "Открыта");
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("Date") + " - " + (resultSet.getString("Location_Event")));
            }
            return list;
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        }
    }

}
