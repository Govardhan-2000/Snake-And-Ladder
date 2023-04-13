module com.example.snakeladderapr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakeladderapr to javafx.fxml;
    exports com.example.snakeladderapr;
}