package com.example.lab_5;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DBUtil {
    private static Connection connection = null;
    private static Statement statement = null;

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

    public static void createTable() throws SQLException {
        dbConnect();
        String sql = "CREATE TABLE Owner(ownerID INTEGER NOT NULL PRIMARY KEY, name VARCHAR(100) NOT NULL, " +
                "address VARCHAR(200) NOT NULL, phone VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL)";
        statement.execute(sql);
        System.out.println("Owner is created!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void dropTable() throws SQLException
    {
        dbConnect();
        String sql = "DROP TABLE Owner";
        statement.execute(sql);
        System.out.println("Owner is dropped!");
        if(statement != null) statement.close();
        dbDisconnect();
    }

    public static void insertData(int ownerID, String name, String address, String phone, String email) throws SQLException{
        dbConnect();
        String sql = "INSERT INTO Owner VALUES('" + ownerID + "','" + name+ "','" + address + "','" + phone + "','" + email + "')";
        statement.execute(sql);
        System.out.println("Data is added to the table!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void deleteData(int id) throws SQLException{
        dbConnect();
        String sql = "DELETE FROM MyTable WHERE s_id = " + id;
        statement.execute(sql);
        System.out.println("Data is deleted from the table!");
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static void simpleQuery() throws SQLException {
        dbConnect();
        String sql = "SELECT * FROM Owner";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String s_name = resultSet.getString("name");
            int s_id = resultSet.getInt("ownerID");
            System.out.println(s_id + " , " + s_name);
        }
        if (statement != null) statement.close();
        dbDisconnect();
    }

    public static ResultSet query(String sql) throws SQLException
    {
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
//        DBUtil.dbConnect();
//        DBUtil.dbDisconnect();
        DBUtil.dropTable();
        DBUtil.createTable();
        DBUtil.insertData(123123123,"Anthony", "Street", "123-123","email.com");
        DBUtil.simpleQuery();
//        DBUtil.deleteData(100);
//        DBUtil.simpleQuery();

    }


}

