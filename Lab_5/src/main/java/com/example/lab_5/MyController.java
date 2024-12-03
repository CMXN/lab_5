package com.example.lab_5;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class MyController {
    @FXML
    private TableView ownerTable;
    @FXML
    private TableColumn ownerCol1;
    @FXML
    private TableColumn ownerCol2;
    @FXML
    private TextField ownerID;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private Button ownerInsertButton;
    @FXML
    private Button ownerUpdateButton;
    @FXML
    private Button ownerDeleteButton;



    @FXML
    private TableView repairTable;
    @FXML
    private TableColumn repairCol1;
    @FXML
    private TableColumn repairCol2;

    @FXML
    private TableView carTable;
    @FXML
    private TableColumn carCol1;
    @FXML
    private TableColumn carCol2;



    public void addOwnerData(ActionEvent actionEvent) throws SQLException {
        DBUtil.insertData(parseInt(ownerID.getText()), name.getText(), address.getText(), phone.getText(),
        email.getText());
    }


    public void initialize()
    {

    }

}