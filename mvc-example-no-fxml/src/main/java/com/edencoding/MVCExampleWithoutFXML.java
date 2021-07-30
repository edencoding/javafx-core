package com.edencoding;

import com.edencoding.controllers.MainViewControllerNoFXML;
import com.edencoding.views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MVCExampleWithoutFXML extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create View
        MainView mainView = new MainView();

        //Create Controller
        MainViewControllerNoFXML controller = new MainViewControllerNoFXML(mainView);

        //Show stage
        primaryStage.setTitle("MVC Example App");
        primaryStage.getIcons().add(new Image(getClass().getResource("/img/EdenCodingIcon.png").toExternalForm()));
        primaryStage.setScene(new Scene(mainView.getView()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

