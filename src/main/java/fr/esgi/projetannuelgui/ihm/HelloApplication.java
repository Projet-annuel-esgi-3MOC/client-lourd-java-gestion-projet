package fr.esgi.projetannuelgui.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SpotLight;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        NotificationPane notificationPane = new NotificationPane(stage.getScene().getRoot());
        notificationPane.getActions().add(new Action("Synchroniser", ae -> {
            MyFxControlsNotification.notification(
                    Pos.BASELINE_RIGHT,
                    "Recupération des projets sur firebase", null, false
            );
        }));

        notificationPane.setText("Toto");

        // https://stackoverflow.com/questions/43651057/notificationpane-doesnt-show-up-in-scene
        scene = new Scene(notificationPane, scene.getWidth(), scene.getHeight());
        stage.setScene(scene);
//        stage.setScene(new SpotLight(Color.ALICEBLUE).getScene());
        notificationPane.show("Recuperer les données depuis le serveur");
    }

    public static void main(String[] args) {
        launch();
    }
}