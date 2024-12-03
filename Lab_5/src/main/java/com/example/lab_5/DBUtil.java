package com.example.lab_5;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DBUtil {
    private static Connection connection = null;
    private static Statement statement = null;

    //dbConnect and disconnect
    public static void dbConnect()
    {
        String dbURL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
        String username = "COMP228_F24_sha_40";
        String password = "password";

        try {
            connection = DriverManager.getConnection(dbURL,username,password);
            statement = connection.createStatement();
            System.out.println("DB is connected");
        } catch (SQLException e) {
            System.out.println("DB is not connected!");
            System.out.println(e.getMessage());
        }
    }

    public static void dbDisconnect() throws SQLException
    {
        if(connection != null && !connection.isClosed())
        {
            connection.close();
            System.out.println("DB is disconnected!");
        }
    }

    //create and drop tables
    public static void createOwnerTable() throws SQLException {
        dbConnect();
        String sql = "CREATE TABLE Owner(ownerID INTEGER NOT NULL PRIMARY KEY, name VARCHAR(100) NOT NULL, " +
                "address VARCHAR(200) NOT NULL, phone VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL)";
        statement.execute(sql);
        System.out.println("Owner is created!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void dropOwnerTable() throws SQLException
    {
        dbConnect();
        String sql = "DROP TABLE Owner";
        statement.execute(sql);
        System.out.println("Owner is dropped!");
        if(statement != null) statement.close();
        dbDisconnect();
    }

    public static void createCarTable() throws SQLException {
        dbConnect();
        System.out.println("create car");
        String sql = "CREATE TABLE Car(carID INTEGER NOT NULL PRIMARY KEY, make VARCHAR(100) NOT NULL, " +
                "model VARCHAR(100) NOT NULL, VIN INTEGER NOT NULL, buildYear INTEGER NOT NULL, type VARCHAR(100) NOT NULL)";
        statement.execute(sql);
        System.out.println("Car is created!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void dropCarTable() throws SQLException
    {
        System.out.println("drop car");
        dbConnect();
        String sql = "DROP TABLE Car";
        statement.execute(sql);
        System.out.println("Car is dropped!");
        if(statement != null) statement.close();
        dbDisconnect();
    }




    public static void insertOwnerData(int ownerID, String name, String address, String phone, String email) throws SQLException{
        dbConnect();
        String sql = "INSERT INTO Owner VALUES('" + ownerID + "','" + name+ "','" + address + "','" + phone + "','" + email + "')";
        statement.execute(sql);
        System.out.println("Data is added to the table!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void deleteOwnerData(int id) throws SQLException{
        dbConnect();
        //sql can be changed to delete other table values
        //additionally, we can have a table that automatically changes the "Owner" in sql
        String sql = "DELETE FROM Owner WHERE ownerID = " + id;
        statement.execute(sql);
        System.out.println("Data is deleted from the table!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void updateOwnerData(int ownerID, String name, String address, String phone,
                                  String email) throws SQLException
    {
        dbConnect();
        String sql = "UPDATE Owner SET name = '" + name + "', address = '" + address + "', phone = '"
            + phone + "', email = '" + email + "' where ownerID = " + ownerID;
        statement.execute(sql);
        System.out.println("Data is updated!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void insertCarData(int carID, String make, String model, int VIN,
                                     int buildYear, String type) throws SQLException{
        System.out.println("here");
        dbConnect();
        String sql = "INSERT INTO Car VALUES('" + carID + "','" + make+ "','" + model + "','" + VIN + "','" + buildYear + "','"+
        type + "')";
        statement.execute(sql);
        System.out.println("Data is added to the table!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void deleteCarData(int id) throws SQLException{
        dbConnect();
        String sql = "DELETE FROM Car WHERE carID = " + id;
        statement.execute(sql);
        System.out.println("Data is deleted from the table!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void updateCarData(int carID, String make, String model, int VIN,
                                       int buildYear, String type) throws SQLException
    {
        dbConnect();
        String sql = "UPDATE Car SET make = '" + make + "', model = '" + model + "', VIN = "
                + VIN + ", buildYear = " + buildYear + ", type = '"+type+"' where carID = " + carID;
        statement.execute(sql);
        System.out.println("Data is updated!");
        if (statement != null) statement.close();
        dbDisconnect();
    }



    public static void simpleQuery() throws SQLException {
        //can change the sql depending on the query
        dbConnect();
        String sql = "SELECT * FROM Car";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String s_make = resultSet.getString("make");
            int s_id = resultSet.getInt("carID");
            System.out.println(s_id + " , " + s_make);
        }
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static ResultSet query(String sql) throws SQLException
    {
        dbConnect();
        //this is for javafx
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        ResultSet resultSet = statement.executeQuery(sql);
        //this is for java fx table view
        crs.populate(resultSet);
        if(statement != null) statement.close();
        dbDisconnect();
        return crs;
    }

    //test the DBUtil Methods
    public static void main(String[] args) throws SQLException
    {
////        DBUtil.dbConnect();
////        DBUtil.dbDisconnect();
//        DBUtil.dropOwnerTable();
//        DBUtil.createOwnerTable();
////        DBUtil.insertData(123123123,"Anthony", "Street", "123-123","email.com");
////        DBUtil.simpleQuery();
////        DBUtil.deleteData(123123123);
////        DBUtil.simpleQuery();

//        DBUtil.insertCarData(12312312, "Hond", "Civic", 456, 2020, "Good");
//        DBUtil.simpleQuery();
//        DBUtil.deleteCarData(12312312);
//        DBUtil.simpleQuery();

    }


}

