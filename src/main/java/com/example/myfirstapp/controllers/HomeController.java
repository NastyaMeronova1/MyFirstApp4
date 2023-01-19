package com.example.myfirstapp.controllers;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label welcomeText;

    @FXML
    private ImageView imageButtonHome;



    @FXML
    void initialize() {
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'app1.fxml'.";
        assert imageButtonHome != null : "fx:id=\"imageButtonHome\" was not injected: check your FXML file 'app1.fxml'.";

    }
}

