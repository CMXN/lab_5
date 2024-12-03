module com.example.lab_5_repo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.lab_5_repo to javafx.fxml;
    exports com.example.lab_5_repo;
}