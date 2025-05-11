package org.furniwise.pusl3122_hci_project.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture.BedRoom;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture.ChairRoom;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture.RoundTableRoom;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture.TableRoom;
import org.furniwise.pusl3122_hci_project.Models.Model;
import org.furniwise.pusl3122_hci_project.Views.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomOneSelectController implements Initializable {
    public Button chair_btn;
    public Button round_table_btn;
    public Button table_btn;
    public Button bed_btn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chair_btn.setOnAction(event -> openChairRoomWindow());
        table_btn.setOnAction(event -> openTableRoomWindow());
        round_table_btn.setOnAction(event -> openRoundTableRoomWindow());
        bed_btn.setOnAction(event -> openBedRoomWindow());




    }

    private void openChairRoomWindow() {
        System.out.println("working..");
        closeCurrentStage();


        ChairRoom chairRoom = new ChairRoom();
        Stage stage = new Stage();
        chairRoom.start(stage);

    }
    private void openTableRoomWindow() {
        System.out.println("working..");
        closeCurrentStage();


        TableRoom tableRoom = new TableRoom();
        Stage stage = new Stage();
        tableRoom.start(stage);

    }
    private void openRoundTableRoomWindow() {
        System.out.println("working..");
        closeCurrentStage();


        RoundTableRoom roundTableRoom = new RoundTableRoom();
        Stage stage = new Stage();
        roundTableRoom.start(stage);

    }

    private void openBedRoomWindow() {
        System.out.println("working..");
        closeCurrentStage();


        BedRoom bedRoom = new BedRoom();
        Stage stage = new Stage();
        bedRoom.start(stage);

    }

    private void closeCurrentStage() {
        Stage currentStage = (Stage) chair_btn.getScene().getWindow();
        currentStage.close();
    }
}
