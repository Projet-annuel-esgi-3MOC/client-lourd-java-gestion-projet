module fr.esgi.projetannuelgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens fr.esgi.projetannuelgui to javafx.fxml;
    exports fr.esgi.projetannuelgui;
    exports fr.esgi.projetannuelgui.ihm;
    opens fr.esgi.projetannuelgui.ihm to javafx.fxml;
}
