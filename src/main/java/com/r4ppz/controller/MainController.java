package com.r4ppz.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import com.r4ppz.model.MainModel;

public class MainController {
    private MainModel mainModel = new MainModel();

    @FXML
    private Button saveButton;
    @FXML
    private Button exportButton;
    @FXML
    private TextArea mainTextArea;

    @FXML
    public void saveButtonAction(ActionEvent event){
        mainModel.setTime(mainModel.getCurrentTime());
        mainModel.setDate(mainModel.getCurrentDate());
        mainModel.setTxt(mainTextArea.getText());
    }

    @FXML
    public void exportButtonAction(ActionEvent event) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
            writer.write(mainModel.getCurrentDate());
            writer.newLine();
            writer.write(mainModel.getCurrentTime());
            writer.newLine();
            writer.write(mainModel.getTxt());
            writer.close();
        } catch (IOException e) {
            System.out.println("IO EXCEPTION !!! WHOOO HOOO");
        }
    }
}