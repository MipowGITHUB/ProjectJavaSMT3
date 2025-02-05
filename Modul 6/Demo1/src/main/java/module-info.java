module main.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.demo1 to javafx.fxml;
    exports main.demo1;
}