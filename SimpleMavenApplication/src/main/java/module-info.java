module SimpleMavenApplication {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.edencoding to javafx.fxml;

    exports com.edencoding;
}