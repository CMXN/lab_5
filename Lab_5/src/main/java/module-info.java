module com.example.lab_5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql.rowset;
    requires com.oracle.database.jdbc;


    opens com.example.lab_5 to javafx.fxml;
    exports com.example.lab_5;
}