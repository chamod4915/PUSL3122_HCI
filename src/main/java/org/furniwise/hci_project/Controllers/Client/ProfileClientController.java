//package org.furniwise.pusl3122_hci_project.Controllers.Client;
//
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class ProfileClientController implements Initializable {
//    public TextField username_fld;
//    public TextField email_fld;
//    public Button update_profile_btn;
//    public TextField current_password_fld;
//    public TextField password_fld;
//    public TextField password_confirm_fld;
//    public Button update_password_btn;
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
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import org.furniwise.pusl3122_hci_project.Models.Model;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class ProfileClientController implements Initializable {
//    public TextField username_fld;
//    public TextField email_fld;
//    public Button update_profile_btn;
//    public TextField current_password_fld;
//    public TextField password_fld;
//    public TextField password_confirm_fld;
//    public Button update_password_btn;
//
//    private Model model;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        model = Model.getInstance(null); // Pass appropriate ViewFactory instance if needed
//
//        // Populate username and email fields
//        String loggedInUsername = model.getLoggedInUsername();
//        if (loggedInUsername != null) {
//            username_fld.setText(loggedInUsername);
//            email_fld.setText(getUserEmail(loggedInUsername));
//        }
//
//        // Add action listener for update profile button
//        update_profile_btn.setOnAction(event -> updateProfile());
//
//        // Add action listener for update password button
//        update_password_btn.setOnAction(event -> updatePassword());
//    }
//
//    private String getUserEmail(String username) {
//        // Retrieve user data from the database and return the email
//        // You can implement this method using the Model class
//        return ""; // Replace with actual implementation
//    }
//
//    private void updateProfile() {
//        String newUsername = username_fld.getText().trim();
//        String newEmail = email_fld.getText().trim();
//
//        if (newUsername.isEmpty() || newEmail.isEmpty()) {
//            showAlert("Error", "Username and Email cannot be empty.");
//            return;
//        }
//
//        // Update user information in the database
//        boolean success = model.updateUserInformation(model.getLoggedInUsername(), newUsername, newEmail);
//        if (success) {
//            showAlert("Success", "Profile updated successfully.");
//            model.setLoggedInUsername(newUsername); // Update the stored username
//        } else {
//            showAlert("Error", "Failed to update profile.");
//        }
//    }
//
//    private void updatePassword() {
//        String newPassword = password_fld.getText().trim();
//        String confirmPassword = password_confirm_fld.getText().trim();
//
//        if (!newPassword.equals(confirmPassword)) {
//            showAlert("Error", "Passwords do not match.");
//            return;
//        }
//
//        // Update password in the database
//        boolean success = model.updatePassword(model.getLoggedInUsername(), newPassword);
//        if (success) {
//            showAlert("Success", "Password updated successfully.");
//        } else {
//            showAlert("Error", "Failed to update password.");
//        }
//    }
//
//    private void showAlert(String title, String message) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//}
//


package org.furniwise.pusl3122_hci_project.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.furniwise.pusl3122_hci_project.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileClientController implements Initializable {
    public TextField username_fld;
    public TextField email_fld;
    public Button update_profile_btn;
    public TextField current_password_fld;
    public TextField password_fld;
    public TextField password_confirm_fld;
    public Button update_password_btn;

    private Model model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = Model.getInstance(null); // Pass appropriate ViewFactory instance if needed

        // Populate username and email fields
        String loggedInUsername = model.getLoggedInUsername();
        String loggedInUserEmail = model.getLoggedInUserEmail();

        if (loggedInUsername != null) {
            username_fld.setText(loggedInUsername);
            email_fld.setText(loggedInUserEmail);
        }

        // Add action listener for update profile button
        update_profile_btn.setOnAction(event -> updateProfile());

        // Add action listener for update password button
        update_password_btn.setOnAction(event -> updatePassword());
    }

    private String getUserEmail(String username) {
        // Retrieve user data from the database and return the email
        // You can implement this method using the Model class
        return ""; // Replace with actual implementation
    }

    private void updateProfile() {
        String newUsername = username_fld.getText().trim();
        String newEmail = email_fld.getText().trim();

        if (newUsername.isEmpty() || newEmail.isEmpty()) {
            showAlert("Error", "Username and Email cannot be empty.");
            return;
        }

        // Update user information in the database
        boolean success = model.updateUserInformation(model.getLoggedInUserID(), newUsername, newEmail);
        if (success) {
            showAlert("Success", "Profile updated successfully.");
            model.setLoggedInUsername(newUsername); // Update the stored username
        } else {
            showAlert("Error", "Failed to update profile.");
        }
    }

    private void updatePassword() {
        String newPassword = password_fld.getText().trim();
        String confirmPassword = password_confirm_fld.getText().trim();

        if (!newPassword.equals(confirmPassword)) {
            showAlert("Error", "Passwords do not match.");
            return;
        }

        // Update password in the database
        boolean success = model.updatePassword(model.getLoggedInUserID(), newPassword);
        if (success) {
            showAlert("Success", "Password updated successfully.");
        } else {
            showAlert("Error", "Failed to update password.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
