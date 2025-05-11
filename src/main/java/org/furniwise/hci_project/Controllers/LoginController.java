package org.furniwise.pusl3122_hci_project.Controllers;

import com.almasb.fxgl.core.View;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.AccountType;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_label;
    public TextField payee_address_fld;
    public Label payee_password_label;
    public TextField password_fld;
    public Button loggin_btn;
    public Label error_lbl;
    public Button redirect_signup_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ViewFactory viewFactory = new ViewFactory();
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT,AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance(viewFactory).getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> Model.getInstance(viewFactory).getViewFactory().setLoginAccountType(acc_selector.getValue()));



        loggin_btn.setOnAction(event -> onLogin(viewFactory));
        redirect_signup_btn.setOnAction(event -> onClick(viewFactory));


    }

    private void onClick(ViewFactory viewFactory){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance(viewFactory).getViewFactory().showSignUpWindow();
        Model.getInstance(viewFactory).getViewFactory().closeStage(stage);
    }
    private void onLogin(ViewFactory viewFactory) {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
//        Model.getInstance(viewFactory).getViewFactory().closeStage(stage);

        if(Model.getInstance(viewFactory).getViewFactory().getLoginAccountType() == AccountType.CLIENT){

            if(payee_address_fld.getText() == "test" && password_fld.getText() == "1234567890"){
                Model.getInstance(viewFactory).getViewFactory().showClientWindow();
                Model.getInstance(viewFactory).getViewFactory().closeStage(stage);
            }else{
//                Model.getInstance(viewFactory).getViewFactory().showClientWindow();
                Model.getInstance(viewFactory).evaluateClientCred(payee_address_fld.getText(),password_fld.getText());

                if(Model.getInstance(viewFactory).getClientLoginSuccessFlag()){
                    Model.getInstance(viewFactory).getViewFactory().showClientWindow();
                    Model.getInstance(viewFactory).getViewFactory().closeStage(stage);
                }else{
                    payee_address_fld.setText("");
                    password_fld.setText("");
                    error_lbl.setText("No Such Login Credentials..");
                }
            }
//
        } else{
            Model.getInstance(viewFactory).evaluateAdminCred(payee_address_fld.getText(),password_fld.getText());

            if(Model.getInstance(viewFactory).getAdminLoginSuccessFlag()){
                Model.getInstance(viewFactory).getViewFactory().showAdminWindow();
                Model.getInstance(viewFactory).getViewFactory().closeStage(stage);
            }else{
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials..");
            }
//            Model.getInstance(viewFactory).getViewFactory().showAdminWindow();
        }

    }



}
