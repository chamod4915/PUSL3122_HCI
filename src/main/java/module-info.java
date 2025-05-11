module org.furniwise.pusl3122_hci_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens org.furniwise.pusl3122_hci_project to javafx.fxml;
    exports org.furniwise.pusl3122_hci_project;
    exports org.furniwise.pusl3122_hci_project.Controllers;
    exports org.furniwise.pusl3122_hci_project.Controllers.Admin;
    exports org.furniwise.pusl3122_hci_project.Controllers.Client;
    exports org.furniwise.pusl3122_hci_project.Controllers.Common;
    exports org.furniwise.pusl3122_hci_project.Models;
    exports org.furniwise.pusl3122_hci_project.Views;
    exports org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture;
}