package org.furniwise.pusl3122_hci_project.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane client_parent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewFactory viewFactory = new ViewFactory();
        // Assuming you have access to the Stage instance within the ClientController
//        Stage stage = (Stage) client_parent.getScene().getWindow();
        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
//            switch (newVal) {
//                case TRANSACTIONS:
//                    client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getTransactionView());
//                    break;
//                case ACCOUNTS:
//                    Stage stage = (Stage) client_parent.getScene().getWindow();
//                    client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getAccountView(stage)); // Pass the Stage instance
//                    break;
//                default:
//                    client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getDashboardView());
//                    break;
//            }
            switch (newVal){
//                case "Transactions" -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getTransactionView());
//                case "Accounts" -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getAccountView());
                case TRANSACTIONS -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getTransactionView());
                case ACCOUNTS -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getAccountView());
                case ROOMS -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getRoomsView());
                case USERPROFILE -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getUserProfileView());
                default -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getDashboardView());
            }
        });

    }
}
