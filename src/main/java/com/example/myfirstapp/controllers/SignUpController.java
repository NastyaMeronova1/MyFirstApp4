package com.example.myfirstapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.myfirstapp.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField login_field;

    @FXML
    private Button SignUpButton;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {


        SignUpButton.setOnAction(event -> {
            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        HelloApplication.DatabaseHandler dbHandler = new HelloApplication.DatabaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = signUpCountry.getText();
        String gender = "";
        if(signUpCheckBoxMale.isSelected())
            gender = "мужской";
        else
            gender = "женский";

        User user = new User(firstName, lastName, userName, password, location, gender);

        dbHandler.signUpUser(user);
    }
}
