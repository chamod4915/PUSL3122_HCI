package org.furniwise.pusl3122_hci_project.Controllers.Admin;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.furniwise.pusl3122_hci_project.Models.Client;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {
    public FontAwesomeIconView in_icon;
    public Label trans_date_lbl;
    public FontAwesomeIconView out_icon;
    public Label sender_lbl;
    public Label reciever_lbl;
    public Label amount_lbl;
    
    private final Client client;

    public ClientCellController(Client client) {
        this.client = client;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
