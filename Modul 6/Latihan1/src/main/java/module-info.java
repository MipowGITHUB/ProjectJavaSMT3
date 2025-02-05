module main.latihan1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.latihan1 to javafx.fxml;
    exports main.latihan1;
}