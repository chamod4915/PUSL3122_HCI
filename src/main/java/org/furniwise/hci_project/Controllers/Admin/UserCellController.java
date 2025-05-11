//package org.furniwise.pusl3122_hci_project.Controllers.Admin;
//
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class UserCellController implements Initializable {
//    public Label joined_date;
//    public Label firstname_lbl;
//    public Label lastname_lbl;
//    public Button delete_btn;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//}

//
//package org.furniwise.pusl3122_hci_project.Controllers.Admin;
//
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class UserCellController implements Initializable {
//    public Label joined_date;
//    public Label firstname_lbl;
//    public Label lastname_lbl;
//    public Button delete_btn;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//
//    // Method to set data in the labels
//    public void setData(String joinedDate, String firstName, String lastName) {
//        joined_date.setText(joinedDate);
//        firstname_lbl.setText(firstName);
//        lastname_lbl.setText(lastName);
//    }
//}

//
//package org.furniwise.pusl3122_hci_project.Controllers.Admin;
//
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class UserCellController implements Initializable {
//    @FXML
//    public AnchorPane root; // Root node of the FXML file
//
//    @FXML
//    public Label joined_date;
//    @FXML
//    public Label firstname_lbl;
//    @FXML
//    public Label lastname_lbl;
//    @FXML
//    public Button delete_btn;
//    public Button update_btn;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//
//    // Method to set data in the labels
//    public void setData(String id, String firstName, String lastName, String payeeAddress,String joinedDateLbl,String username,String email) {
////        System.out.println(id);
////        System.out.println(username);
////
////        System.out.println(email);
////
////        System.out.println(id);
//
//        joined_date.setText(joinedDateLbl);
//        firstname_lbl.setText(username);
//        lastname_lbl.setText(email);
////        joined_date.setText(joinedDateLbl);
//    }
//
//    // Getter for the root node
//    public AnchorPane getRoot() {
//        return root;
//    }
//}
//
//
//package org.furniwise.pusl3122_hci_project.Controllers.Admin;
//
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class UserCellController implements Initializable {
//    @FXML
//    public AnchorPane root; // Root node of the FXML file
//
//    @FXML
//    public Label joined_date;
//    @FXML
//    public Label firstname_lbl;
//    @FXML
//    public Label lastname_lbl;
//    @FXML
//    public Button delete_btn;
//    public Button update_btn;
//
//    private String userId; // ID of the user
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//
//    // Method to set data in the labels
//    public void setData(String id, String firstName, String lastName, String payeeAddress, String joinedDateLbl, String username, String email) {
//        this.userId = id; // Set the userId
//        joined_date.setText(joinedDateLbl);
//        firstname_lbl.setText(username);
//        lastname_lbl.setText(email);
//        // Set the event handler for the delete button
//        delete_btn.setOnAction(event -> handleDelete());
//    }
//
//    // Method to handle delete action
//    private void handleDelete() {
//        // Display confirmation dialog
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation");
//        alert.setHeaderText("Delete User");
//        alert.setContentText("Are you sure you want to delete this user?");
//
//        // Show and wait for user response
//        alert.showAndWait().ifPresent(response -> {
//            if (response == javafx.scene.control.ButtonType.OK) {
//                // Perform deletion from the database using userId
//                // Add your code here to delete the record from the database using userId
//
//                System.out.println("Delete confirmed for user ID: " + userId);
//                // You can call a method from your Model class to delete the record using userId
//            }
//        });
//    }
//
//    // Getter for the root node
//    public AnchorPane getRoot() {
//        return root;
//    }
//}


package org.furniwise.pusl3122_hci_project.Controllers.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Models.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;

public class   UserCellController implements Initializable {
    @FXML
    public AnchorPane root; // Root node of the FXML file

    @FXML
    public Label joined_date;
    @FXML
    public Label firstname_lbl;
    @FXML
    public Label lastname_lbl;
    @FXML
    public Button delete_btn;
    public Button update_btn;

    private String userId; // ID of the user
    private Model model; // Instance of the Model class

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Get an instance of the Model class
        model = Model.getInstance(null); // Pass null for ViewFactory as it's not required here
    }

    // Method to set data in the labels
    public void setData(String id, String firstName, String lastName, String payeeAddress, String joinedDateLbl, String username, String email) {
        this.userId = id; // Set the userId
        joined_date.setText(joinedDateLbl);
        firstname_lbl.setText(username);
        lastname_lbl.setText(email);
        // Set the event handler for the delete button
        delete_btn.setOnAction(event -> handleDelete());
        update_btn.setOnAction(event -> handleUpdate());
    }


    private void handleUpdate() {
        // Open UpdateUserController window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/UpdateUser.fxml"));
        Parent root;
        try {
            root = loader.load();
            UpdateUserController controller = loader.getController();

            // Populate fields with user details

            controller.populateFields(userId, firstname_lbl.getText(), lastname_lbl.getText());

            // Create a new stage for the UpdateUserController window
            Stage stage = new Stage();
            stage.setTitle("Update User");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to handle delete action
    private void handleDelete() {
        // Display confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete User");
        alert.setContentText("Are you sure you want to delete this user?");

        // Show and wait for user response
        alert.showAndWait().ifPresent(response -> {
            if (response == javafx.scene.control.ButtonType.OK) {
                // Perform deletion from the database using userId
                boolean deleted = model.deleteUser(userId); // Call deleteUser method from Model

                if (deleted) {
                    System.out.println("User deleted successfully.");
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("User deleted successfully.");
                    successAlert.showAndWait();


                    // Add any additional actions after successful deletion
                } else {
                    System.out.println("Failed to delete user.");
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Failed to delete user.");
                    errorAlert.showAndWait();
                    // Add any error handling if deletion fails
                }
            }
        });
    }

    // Getter for the root node
    public AnchorPane getRoot() {
        return root;
    }
}
