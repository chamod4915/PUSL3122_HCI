package org.furniwise.pusl3122_hci_project.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.AdminMenuOptions;
import org.furniwise.pusl3122_hci_project.Views.ClientMenuOptions;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button account_btn;
    public Button account_btn1;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;
    public Button rooms_btn;
    public Button all_users_btn;

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
        all_users_btn.setOnAction(event -> onAllUsers(viewFactory));
    }

    private void onAllUsers(ViewFactory viewFactory) {
        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.ALLUSERS);

    }

    private void onRooms(ViewFactory viewFactory) {
        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.ROOMS);


    }

    private void onUserLogout(ViewFactory viewFactory) {
        Stage currentStage = (Stage) dashboard_btn.getScene().getWindow();
        Model.getInstance(viewFactory).getViewFactory().closeStage(currentStage);
        Model.getInstance(viewFactory).getViewFactory().showLoginWindow();

    }

    private void onUserProfile(ViewFactory viewFactory) {
        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.USERPROFILE);

    }

    private void onDashboard(ViewFactory viewFactory){
        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DASHBOARD);
//        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set("Dashboard");
    }

    private void onTransactions(ViewFactory viewFactory){
//        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set("Transactions");
        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.TRANSACTIONS);

    }

//    private void onAccounts(ViewFactory viewFactory){
//        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.ACCOUNTS);
////        Model.getInstance(viewFactory).getViewFactory().getAdminSelectedMenuItem().set("Accounts");
//
//    }
}
