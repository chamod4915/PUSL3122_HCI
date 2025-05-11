package org.furniwise.pusl3122_hci_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/login.fxml"));
//
//        Scene scene = new Scene(fxmlLoader.load());
//
//        stage.setScene(scene);
//        stage.show();

        ViewFactory viewFactory = new ViewFactory();
//
//        viewFactory.showLoginWindow();

        Model.getInstance(viewFactory).getViewFactory().showLoginWindow();

    }
}


