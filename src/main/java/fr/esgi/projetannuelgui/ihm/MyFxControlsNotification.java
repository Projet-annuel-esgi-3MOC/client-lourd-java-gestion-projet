package fr.esgi.projetannuelgui.ihm;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class MyFxControlsNotification {

    public static void notification(Pos pos, String text, String titleText, Boolean darkStyle) {

        Notifications notificationBuilder = Notifications.create()
                .title(titleText != null ? titleText : "")
                .text(text)
                .hideAfter(Duration.seconds(2))
                .position(pos)
                .onAction(e -> System.out.println("Notification clicked on!"))
//                .threshold((int) thresholdSlider.getValue(),
//                        Notifications.create().title("Threshold Notification"))
                ;

        if (darkStyle) {
            notificationBuilder.darkStyle();
        }

        notificationBuilder.show();

    }
}
