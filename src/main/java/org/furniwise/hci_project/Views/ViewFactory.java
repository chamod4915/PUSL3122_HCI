package org.furniwise.pusl3122_hci_project.Views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Admin.AdminController;
import org.furniwise.pusl3122_hci_project.Controllers.Client.AccountsController;
import org.furniwise.pusl3122_hci_project.Controllers.Client.ClientController;

public class ViewFactory {
//    private final StringProperty clientSelectedMenuItem;

    private AccountType loginAccountType;

    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;

    private AnchorPane dashboardView;
    private AnchorPane transactionView;

    private AnchorPane accountView;

    private AnchorPane roomsView;
    private AnchorPane profileView;

    private AnchorPane allUsersView;

//    admin views

//    private final StringProperty adminSelectedMenuItem;
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;

    private AnchorPane createClientView;


    public ViewFactory() {
        this.loginAccountType = AccountType.CLIENT;
        clientSelectedMenuItem = new SimpleObjectProperty<>();
        adminSelectedMenuItem = new SimpleObjectProperty<>();
//        adminSelectedMenuItem = new SimpleStringProperty("");
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public void viewFactory(){
//        this.clientSelectedMenuItem = new SimpleStringProperty("");
    }

    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem(){
        System.out.println("working....");
        System.out.println(clientSelectedMenuItem);
        return clientSelectedMenuItem;
//        return new SimpleStringProperty("Transactions");
    }

    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionView() {
        if(transactionView == null){
            try{
                transactionView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transactions.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return transactionView;
    }

    public AnchorPane getUserProfileView() {
        if (profileView == null) {
            try {
                profileView = new FXMLLoader(getClass().getResource("/Fxml/Client/ProfileClient.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return profileView;

    }


        public AnchorPane getRoomsView() {
        if(roomsView == null){
            try{
                roomsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Rooms.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return roomsView;
    }

    public AnchorPane getAllUsersView() {
        if(allUsersView == null){
            try{
                allUsersView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AllUsers.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return allUsersView;
    }


    public AnchorPane getAccountView() {
        if(accountView == null){
            try{
                accountView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
//
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return accountView;
    }

//    public AnchorPane getAccountView() {
////        public AnchorPane getAccountView(Stage stage) {
//
//        if(accountView == null){
//            try{
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml"));
//                loader.setController(new AccountsController()); // Pass the Stage instance to the controller
////                loader.setController(new AccountsController(stage)); // Pass the Stage instance to the controller
//
//                accountView = loader.load();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return accountView;
//    }

    public void showRoomOneSelectWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/RoomOneSelect.fxml"));

        createStage(loader);
//        Scene scene = null;
//
//        try{
//            scene = new Scene(loader.load());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        Stage stage = new Stage();
//
//        stage.setScene(scene);
//
//        stage.setTitle("FurniWise");
//
//        stage.show();
    }
    public void showRoomTwoSelectWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/RoomTwoSelect.fxml"));

        createStage(loader);

    }

    public void showUpdateUserInfoWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/UpdateUser.fxml"));

        createStage(loader);

    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));

        createStage(loader);
//        Scene scene = null;
//
//        try{
//            scene = new Scene(loader.load());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        Stage stage = new Stage();
//
//        stage.setScene(scene);
//
//        stage.setTitle("FurniWise");
//
//        stage.show();
    }


    public void showSignUpWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/SignUp.fxml"));

        createStage(loader);
//        Scene scene = null;
//
//        try{
//            scene = new Scene(loader.load());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        Stage stage = new Stage();
//
//        stage.setScene(scene);
//
//        stage.setTitle("FurniWise");
//
//        stage.show();
    }
    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();

        loader.setController(clientController);

createStage(loader);
//        Scene scene = null;
//
//        try{
//            scene = new Scene(loader.load());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        Stage stage = new Stage();
//
//        stage.setScene(scene);
//
//        stage.setTitle("FurniWise");
//
//        stage.show();
    }

    //    admin views

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem(){
        System.out.println("admin working....");
        System.out.println(adminSelectedMenuItem);
        return adminSelectedMenuItem;
//        return new SimpleStringProperty("Transactions");
    }

    public AnchorPane getCreateClientWindow(){
        if(createClientView == null){
            try{
                createClientView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return createClientView;
    }

    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
                Scene scene = null;

        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }

        Stage stage = new Stage();

        stage.setScene(scene);

        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.png"))));
//        stage.setResizable(false);

        stage.setTitle("FurniWise");

        stage.show();

    }

    public void closeStage(Stage stage){
        stage.close();
    }
}
