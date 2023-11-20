module com.example.platformer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.platformer to javafx.fxml;
    exports com.example.platformer;
}