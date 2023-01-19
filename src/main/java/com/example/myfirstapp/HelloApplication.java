package com.example.myfirstapp;

import com.example.myfirstapp.controllers.Configs;
import com.example.myfirstapp.controllers.Const;
import com.example.myfirstapp.controllers.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("My First App");
        stage.setScene(scene);
        stage.show();
    }
    public static class DatabaseHandler extends Configs {



    Connection dbConnection;
        public static Statement statement;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;*/

        static{
            try {
                dbConnection = DriverManager.getConnection(connectionString,
                        dbUser, dbPass);
            }catch (SQLException throwables) {
                throwables.printStackTrace();
                throw new RuntimeException();
            }
        }
        static {
            try {
                statement = dbConnection.createStatement();
            }catch (SQLException throwables) {
                throwables.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
    public void signUpUser (User user) {
        String insert = "INSERT INTO" + Const.USER_TABLE + "(" +
                Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," + Const.USER_PASSWORD + "," +
                Const.USER_LOCATION + "," + Const.USER_GENDER + ")" + "VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}