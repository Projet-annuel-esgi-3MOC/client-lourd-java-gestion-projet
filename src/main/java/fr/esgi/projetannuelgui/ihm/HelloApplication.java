package fr.esgi.projetannuelgui.ihm;

import com.google.gson.Gson;
import fr.esgi.projetannuelgui.bo.Project;
import fr.esgi.projetannuelgui.utils.HttpJsonUtils;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

            String json = HttpJsonUtils.getStringFromrl("https://intermediaire-node.onrender.com/projects/");
            System.out.println(json);
            Gson gson = new Gson();
            Project[] projects = gson.fromJson(json, Project[].class);

            ObservableList<Project> observableList = FXCollections.observableArrayList(projects);
            for (Project proj :
                    projects) {
                System.out.println(proj);
            }
            TableView<Project> projectTableView = ((HelloController)fxmlLoader.getController()).getProjectsList();

            TableColumn<Project, String> nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory((project) -> new SimpleStringProperty(project.getValue().getName()));

            TableColumn<Project, String> startDateCol = new TableColumn<>("Start date");
            startDateCol.setCellValueFactory((project) -> new SimpleStringProperty(HttpJsonUtils.stringOrNullFromDate(project.getValue().getStartDate())));

            TableColumn<Project, String> endDateCol = new TableColumn<>("End date");
            endDateCol.setCellValueFactory((project) -> new SimpleStringProperty(HttpJsonUtils.stringOrNullFromDate(project.getValue().getEndDate())));

            projectTableView.getColumns().add(0, nameCol);
            projectTableView.getColumns().add(1, startDateCol);
            projectTableView.getColumns().add(2, endDateCol);

            projectTableView.setItems(observableList);
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