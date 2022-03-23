package com.fyra.reviewprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuController {
    @FXML
    private Button knapp;

    @FXML
    private TextField textRuta;

    @FXML
    void initialize(){
        Person person = new Person();
        person.setName("Otto Kostmann");
        textRuta.setText(person.getName());
    }

    @FXML
    void knappKlick(ActionEvent event) {
        Person person = new Person();
        person.setName("Otto Kostmann");
        String x = textRuta.getText();
        textRuta.setText(x+=person.getName());
    }
}