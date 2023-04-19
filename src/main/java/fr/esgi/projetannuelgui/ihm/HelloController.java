package fr.esgi.projetannuelgui.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

//    @FXML
//    public void initialize() {
//        notificationPane.getActions().add(new Action("Synchroniser", ae -> {
//            MyFxControlsNotification.notification(
//                    Pos.BASELINE_RIGHT,
//                    "Recupération des projets sur firebase", null, false
//            );
//        }));
//
//        notificationPane.setText("Toto");
//
//        notificationPane.show("Recuperer les données depuis le serveur");
//    }
}