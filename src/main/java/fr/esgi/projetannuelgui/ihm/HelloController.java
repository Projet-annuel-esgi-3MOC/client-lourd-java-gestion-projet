package fr.esgi.projetannuelgui.ihm;

import fr.esgi.projetannuelgui.bo.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    public TableView<Project> projectsList;

    @FXML
    private Label welcomeText;

    public TableView<Project> getProjectsList() {
        return projectsList;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize() {
        VBox.setVgrow(welcomeText, Priority.ALWAYS);
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
    }
}