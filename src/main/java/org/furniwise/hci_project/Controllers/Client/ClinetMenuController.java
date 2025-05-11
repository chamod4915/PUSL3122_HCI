package org.furniwise.pusl3122_hci_project.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ClientMenuOptions;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ClinetMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button account_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;
    public Button rooms_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ViewFactory viewFactory = new ViewFactory();

        addListeners(viewFactory);
    }

    private void addListeners(ViewFactory viewFactory){
        dashboard_btn.setOnAction(event -> onDashboard(viewFactory));
        transaction_btn.setOnAction(event -> onTransactions(viewFactory));
//        account_btn.setOnAction(event -> onAccounts(viewFactory));
        rooms_btn.setOnAction(event -> onRooms(viewFactory));
        profile_btn.setOnAction(event -> onUserProfile(viewFactory));
        logout_btn.setOnAction(event -> onUserLogout(viewFactory));
    }

    private void onUserLogout(ViewFactory viewFactory) {

        Stage currentStage = (Stage) dashboard_btn.getScene().getWindow();
        Model.getInstance(viewFactory).getViewFactory().closeStage(currentStage);
        Model.getInstance(viewFactory).getViewFactory().showLoginWindow();


    }

    private void onUserProfile(ViewFactory viewFactory) {
        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.USERPROFILE);

    }

    private void onDashboard(ViewFactory viewFactory){
//        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set("Dashboard");
        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);

    }

    private void onTransactions(ViewFactory viewFactory){
//        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set("Transactions");
        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);

    }

    private void onRooms(ViewFactory viewFactory){
//        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set("Rooms");
        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ROOMS);

    }

//    private void onAccounts(ViewFactory viewFactory){
////        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set("Accounts");
//        Model.getInstance(viewFactory).getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
//
//    }
}
