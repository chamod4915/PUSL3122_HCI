package org.furniwise.pusl3122_hci_project.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.AccountType;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public Label login_date;
    public Label checking_bal;
    public Label checking_acc_num;
    public Label savings_bal;
    public Label savings_acc_num;
    public Label income_lbl;
    public Label expenses_lbl;
    public ListView transaction_listview;
    public TextField payee_fld;
    public TextField amount_fld;
    public TextArea message_fld;
    public Button send_money_btn;

    public Model model;
    public Label user_count_lbl;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.user_name.setText("Admin");
        ViewFactory viewFactory = new ViewFactory();
        // Get reference to the Model
        model = Model.getInstance(viewFactory);

        // Set the username to the user_name text

//         Check if the logged-in user is an admin
//        if (model.getLoginAccountType() == AccountType.ADMIN) {
//            // If the logged-in user is an admin, set the user_name label to "Admin"
//            user_name.setText("Admin");
//
//        } else {
            // If the logged-in user is not an admin, set the user_name label to the username retrieved from the model
            user_name.setText(model.getLoggedInUsername());
//        }


//        user_name.setText(model.getLoggedInUsername());

        model.fetchTotalClientRecords();

        // Set the value of user_count_lbl with the fetched count value
        user_count_lbl.setText(String.valueOf(model.getTotalClientRecords()));

    }
}
