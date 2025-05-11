//package org.furniwise.pusl3122_hci_project.Controllers.Client;
//
////import com.dlsc.formsfx.model.structure.Group;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.SubScene;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.Chair3D;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class AccountsController implements Initializable {
//    public SubScene subScene;
//    public AnchorPane chairAnchorPane;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//}

//
//package org.furniwise.pusl3122_hci_project.Controllers.Client;
//
//import javafx.fxml.Initializable;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.Chair3D;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class AccountsController implements Initializable {
//    public AnchorPane chairAnchorPane;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        Chair3D chair3D = new Chair3D();
//        chair3D.start(new Stage()); // Start the 3D chair scene
//        AnchorPane chairRoot = chair3D.getRoot(); // Get the root node of the 3D chair scene
//        chairAnchorPane.getChildren().add(chairRoot); // Add the root node to the AnchorPane
//    }
//}

//
//package org.furniwise.pusl3122_hci_project.Controllers.Client;
//
//import javafx.fxml.Initializable;
//import javafx.scene.Group;
//import javafx.scene.layout.AnchorPane;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.Chair3D;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class AccountsController implements Initializable {
//    public Group chairGroup; // Use Group instead of AnchorPane
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        Chair3D chair3D = new Chair3D();
//        chair3D.start(); // Start the 3D chair scene
//        chairGroup.getChildren().add(chair3D.getRoot()); // Add the root node to the Group
//    }
//}


package org.furniwise.pusl3122_hci_project.Controllers.Client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Common.Chair3D;
import org.furniwise.pusl3122_hci_project.Controllers.Common.Chair2D;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountsController implements Initializable {
//    @FXML
//    private Button chair_2D_btn;
//
//    @FXML
//    private Button chair_3D_btn;
public Button chair_2D_btn;

    public Button chair_3D_btn;


//    private void initialize() {
//        System.out.println("Controller initialized");
//        // Add event handlers for button clicks
//        chair_2D_btn.setOnAction(event -> open2DChairWindow());
//        chair_3D_btn.setOnAction(event -> open3DChairWindow());
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add event handlers for button clicks
        chair_2D_btn.setOnAction(event -> open2DChairWindow());
        chair_3D_btn.setOnAction(event -> open3DChairWindow());

    }

    private void open2DChairWindow() {
        System.out.println("working..");
        Chair2D chair2D = new Chair2D();
        Stage stage = new Stage();
        chair2D.start(stage);
    }

    private void open3DChairWindow() {
        System.out.println("working..3d");

        Chair3D chair3D = new Chair3D();
        Stage stage = new Stage();
        chair3D.start(stage);
    }


//    public Group chairGroup;
//    private Stage stage;
//
//    // Constructor to receive the stage
//    public AccountsController() {
////    public AccountsController(Stage stage) {
//
//        this.stage = stage;
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
////        Chair3D chair3D = new Chair3D();
////        chair3D.start(stage); // Start the 3D chair scene with the provided stage
////        chairGroup.getChildren().add(chair3D.getRoot());
//    }
}
