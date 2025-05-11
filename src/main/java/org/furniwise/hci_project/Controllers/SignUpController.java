//package org.furniwise.pusl3122_hci_project.Controllers;
//
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Models.Model;
//import org.furniwise.pusl3122_hci_project.Views.ViewFactory;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class SignUpController implements Initializable {
//    public Button redirect_login_btn;
//    public Label error_lbl;
//    public TextField username_fld;
//    public TextField email_fld;
//    public TextField password_fld;
//    public TextField password_confirm_fld;
//    public Button signup_btn;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        ViewFactory viewFactory = new ViewFactory();
//
//        redirect_login_btn.setOnAction(event -> onClickLoginRedirect(viewFactory));
//    }
//
//    private void onClickLoginRedirect(ViewFactory viewFactory) {
//        Stage stage = (Stage) error_lbl.getScene().getWindow();
//        Model.getInstance(viewFactory).getViewFactory().showLoginWindow();
//        Model.getInstance(viewFactory).getViewFactory().closeStage(stage);
//    }
//}


package org.furniwise.pusl3122_hci_project.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    public Button redirect_login_btn;
    public Label error_lbl;
    public TextField username_fld;
    public TextField email_fld;
    public TextField password_fld;
    public TextField password_confirm_fld;
    public Button signup_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the ViewFactory
        ViewFactory viewFactory = new ViewFactory();

        // Set action for the signup button
        signup_btn.setOnAction(event -> {
            // Perform basic input validation
            if (username_fld.getText().isEmpty() || email_fld.getText().isEmpty() ||
                    password_fld.getText().isEmpty() || password_confirm_fld.getText().isEmpty()) {
                error_lbl.setText("Please fill in all fields.");
            } else if (!password_fld.getText().equals(password_confirm_fld.getText())) {
                error_lbl.setText("Passwords do not match.");
            } else {
                // Call method to handle signup process
                handleSignUp(viewFactory);
            }
        });

        // Set action for the redirect login button
        redirect_login_btn.setOnAction(event -> onClickLoginRedirect(viewFactory));
    }

    private void handleSignUp(ViewFactory viewFactory) {
        // Get instance of the Model
        Model model = Model.getInstance(viewFactory);

        // Get input values
        String username = username_fld.getText();
        String email = email_fld.getText();
        String password = password_fld.getText();

        // Call method from Model to perform signup
        boolean signUpSuccess = model.performSignUp(username, email, password);

        // Handle signup success or failure
        if (signUpSuccess) {
            // Signup successful, navigate to login screen
            Model.getInstance(viewFactory).getViewFactory().showLoginWindow();
            Stage stage = (Stage) error_lbl.getScene().getWindow();
            Model.getInstance(viewFactory).getViewFactory().closeStage(stage);
        } else {
            // Signup failed, display error message
            error_lbl.setText("Signup failed. Please try again.");
        }
    }

    private void onClickLoginRedirect(ViewFactory viewFactory) {
        // Redirect to login screen
        Model.getInstance(viewFactory).getViewFactory().showLoginWindow();
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance(viewFactory).getViewFactory().closeStage(stage);
    }
}
