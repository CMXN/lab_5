package com.example.lab_5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class MyController {

    //owner elements
    @FXML
    private TableView ownerTable;
    @FXML
    private TableColumn ownerCol1;
    @FXML
    private TableColumn ownerCol2;

    //textfields
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

    //buttons
    @FXML
    private Button ownerInsertButton;
    @FXML
    private Button ownerUpdateButton;
    @FXML
    private Button ownerDeleteButton;
    @FXML
    private Button ownerDisplayButton;


    //repair table
    @FXML
    private TableView repairTable;
    @FXML
    private TableColumn repairCol1;
    @FXML
    private TableColumn repairCol2;


    //car table
    //car elements
    @FXML
    private TableView carTable;
    @FXML
    private TableColumn carCol1;
    @FXML
    private TableColumn carCol2;

    //textfields
    @FXML
    private TextField carID;
    @FXML
    private TextField make;
    @FXML
    private TextField model;
    @FXML
    private TextField VIN;
    @FXML
    private TextField buildYear;
    @FXML
    private TextField type;



    //owner table functions
    public void addOwnerData(ActionEvent actionEvent) throws SQLException {
        DBUtil.insertOwnerData(parseInt(ownerID.getText()), name.getText(), address.getText(), phone.getText(),
        email.getText());
        populateCarData();
    }

    public void ownerDisplay() throws SQLException {
        DBUtil.simpleQuery();
        populateOwnerData();
    }

    public void ownerUpdate() throws SQLException
    {
        DBUtil.updateOwnerData(parseInt(ownerID.getText()), name.getText(), address.getText(), phone.getText(),
                email.getText());
        populateOwnerData();
    }

    public void ownerDelete() throws SQLException
    {
        DBUtil.deleteOwnerData(parseInt(ownerID.getText()));
        populateOwnerData();
    }


    public void populateOwnerData() throws SQLException {
        ResultSet rs = DBUtil.query("SELECT * FROM Owner");
        // create a list of object that we want to add to the table
        ObservableList<Owner> owners = FXCollections.observableArrayList();
        //add object one by one
        while (rs.next()){
            Owner owner = new Owner(rs.getInt("ownerID"), rs.getString("name"),
                    rs.getString("address"), rs.getString("phone"),
                    rs.getString("email"));
            owners.add(owner);
        }

        ownerCol2.setCellValueFactory(new PropertyValueFactory("name"));

        //clear the table
        ownerTable.getItems().clear();
        //add all owners
        ownerTable.getItems().addAll(owners);
        //sort the table
        ownerCol2.setSortType(TableColumn.SortType.ASCENDING);
        ownerTable.sort();
    }

    //repair table functions




    //car table functions
    public void addCarData(ActionEvent actionEvent) throws SQLException {
        DBUtil.insertCarData(parseInt(carID.getText()), make.getText(), model.getText(), parseInt(VIN.getText()),
                parseInt(buildYear.getText()), type.getText());
        populateCarData();
    }

    public void carDisplay() throws SQLException {
        DBUtil.simpleQuery();
        populateCarData();
    }

    public void carUpdate() throws SQLException
    {
        DBUtil.updateCarData(parseInt(carID.getText()), make.getText(), model.getText(), parseInt(VIN.getText()),
                parseInt(buildYear.getText()), type.getText());
        populateCarData();
    }

    public void carDelete() throws SQLException
    {
        DBUtil.deleteCarData(parseInt(carID.getText()));
        populateCarData();
    }

    public void populateCarData() throws SQLException {
        ResultSet rs = DBUtil.query("SELECT * FROM Car");
        // create a list of object that we want to add to the table
        ObservableList<Car> cars = FXCollections.observableArrayList();
        //add object one by one
        while (rs.next()){
            Car car = new Car(rs.getInt("carID"), rs.getString("make"),
                    rs.getString("model"), rs.getInt("VIN"),
                    rs.getInt("buildYear"), rs.getString("type"));
            cars.add(car);
        }

        carCol2.setCellValueFactory(new PropertyValueFactory("make"));

        //clear the table
        carTable.getItems().clear();
        //add all cars
        carTable.getItems().addAll(cars);
        //sort the table
        carCol2.setSortType(TableColumn.SortType.ASCENDING);
        carTable.sort();
    }




    public void initialize() throws SQLException {
        populateOwnerData();
        populateCarData();
    }

}