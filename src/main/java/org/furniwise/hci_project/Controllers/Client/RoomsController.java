package org.furniwise.pusl3122_hci_project.Controllers.Client;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Common.Chair2D;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture.ChairRoom;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomsController implements Initializable {
    public Button room1_3D_btn;
    public Button room2_3D_btn;

    private AnchorPane loginView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        room1_3D_btn.setOnAction(event -> openRoom1Window());
        room2_3D_btn.setOnAction(event -> openRoom2Window());

    }

    private void openRoom1Window() {
        System.out.println("working..");

        ViewFactory viewFactory = new ViewFactory();
//
//        viewFactory.showLoginWindow();

        Model.getInstance(viewFactory).getViewFactory().showRoomOneSelectWindow();

//        try{
//             loginView = new FXMLLoader(getClass().getResource("/Fxml/Client/Login.fxml")).load();
////            Stage stage = new Stage();
////        loginView.start(stage);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        ChairRoom chairRoom = new ChairRoom();
//        Stage stage = new Stage();
//        chairRoom.start(stage);
//        Chair2D chair2D = new Chair2D();
//        Stage stage = new Stage();
//        chair2D.start(stage);
    }
    private void openRoom2Window() {
        System.out.println("working..");

        ViewFactory viewFactory = new ViewFactory();
//
//        viewFactory.showLoginWindow();

        Model.getInstance(viewFactory).getViewFactory().showRoomTwoSelectWindow();
//        Model.getInstance(viewFactory).getViewFactory().showUpdateUserInfoWindow();


    }
}
