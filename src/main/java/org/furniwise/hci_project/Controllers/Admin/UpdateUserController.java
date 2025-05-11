package org.furniwise.pusl3122_hci_project.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;
//
//public class UpdateUserController implements Initializable {
//    public TextField username_fld;
//    public TextField email_fld;
//    public TextField password_fld;
//    public Button update_user_info_btn;
//
//    public String user_id;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//
//    public void populateFields(String userId, String username, String email) {
//        username_fld.setText(username);
//        email_fld.setText(email);
//        this.user_id = userId;
//
//        // You can populate other fields as needed
//    }
//}


public class UpdateUserController implements Initializable {
    public TextField username_fld;
    public TextField email_fld;
    public TextField password_fld;
    public Button update_user_info_btn;

    private String userId; // ID of the user

    // Method to populate fields with user details
    public void populateFields(String userId, String username, String email) {
        this.userId = userId;
        username_fld.setText(username);
        email_fld.setText(email);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Event handler for update button click
        update_user_info_btn.setOnAction(event -> handleUpdateUserInfo());
    }

    // Method to handle update user info action
    private void handleUpdateUserInfo() {
        ViewFactory viewFactory = new ViewFactory();
        String newUsername = username_fld.getText();
        String newEmail = email_fld.getText();
        String newPassword = password_fld.getText();

        // Call the update user method from the Model
        boolean updated = Model.getInstance(viewFactory).updateUserInfoAdmin(userId, newUsername, newEmail,newPassword);
        if (updated) {
            // Close the window if the user is updated successfully
            Stage stage = (Stage) update_user_info_btn.getScene().getWindow();
            stage.close();
        } else {
            // Show an error message if the update fails
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to update user.");
            errorAlert.showAndWait();
        }
    }
}
