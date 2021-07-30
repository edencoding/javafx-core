module com.edencoding {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.edencoding.controllers to javafx.fxml;
    exports com.edencoding;
}