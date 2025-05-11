package org.furniwise.pusl3122_hci_project.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewFactory viewFactory = new ViewFactory();

        // Assuming you have access to the Stage instance within the ClientController
//        Stage stage = (Stage) admin_parent.getScene().getWindow();
        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().addListener(((observableValue, oldVal, newVal) ->{

//            switch (newVal) {
//                case TRANSACTIONS:
//                    admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getTransactionView());
//                    break;
//                case ACCOUNTS:
//                    Stage stage = (Stage) admin_parent.getScene().getWindow();
//                    admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getAccountView(stage)); // Pass the Stage instance
//                    break;
//                default:
//                    admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getDashboardView());
//                    break;
//            }
            switch (newVal){
//                case "Transactions" -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getTransactionView());
//                case "Accounts" -> client_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getAccountView());
                case TRANSACTIONS -> admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getTransactionView());
                case ACCOUNTS -> admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getAccountView());
                case ROOMS -> admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getRoomsView());
                case ALLUSERS -> admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getAllUsersView());
                case USERPROFILE -> admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getUserProfileView());
                default -> admin_parent.setCenter(Model.getInstance(viewFactory).getViewFactory().getDashboardView());
            }
        } ));

    }
}
