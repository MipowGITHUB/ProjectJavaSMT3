module main.latihan2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.latihan2 to javafx.fxml;
    exports main.latihan2;
}