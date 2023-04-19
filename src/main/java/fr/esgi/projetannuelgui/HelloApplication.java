package fr.esgi.projetannuelgui;

import fr.esgi.projetannuelgui.ihm.MyFxControlsNotification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        MyFxControlsNotification.notification(
                Pos.BASELINE_RIGHT,
                "Recupération des projets sur firebase", null, false
        );
    }

    public static void main(String[] args) {
        launch();
    }
}