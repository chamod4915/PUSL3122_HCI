package org.furniwise.pusl3122_hci_project.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomTwoSelectController implements Initializable {
    public Button chair_btn;
    public Button table_btn;
    public Button round_table_btn;
    public Button bed_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chair_btn.setOnAction(event -> openChairRoomAllWindow());
        table_btn.setOnAction(event -> openTableRoomAllWindow());
        round_table_btn.setOnAction(event -> openRoundTableRoomAllWindow());
        bed_btn.setOnAction(event -> openBedRoomAllWindow());

    }

    private void openChairRoomAllWindow() {
        System.out.println("working..");
        closeCurrentStage();


        ChairRoomAll chairRoomAll = new ChairRoomAll();
        Stage stage = new Stage();
        chairRoomAll.start(stage);

    }
    private void openTableRoomAllWindow() {
        System.out.println("working..");
        closeCurrentStage();


        TableRoomAll tableRoomAll = new TableRoomAll();
        Stage stage = new Stage();
        tableRoomAll.start(stage);

    }
    private void openRoundTableRoomAllWindow() {
        System.out.println("working..");
        closeCurrentStage();


        RoundTableRoomAll roundTableRoomAll = new RoundTableRoomAll();
        Stage stage = new Stage();
        roundTableRoomAll.start(stage);

    }

    private void openBedRoomAllWindow() {
        System.out.println("working..");
        closeCurrentStage();


        BedRoomAll bedRoomAll = new BedRoomAll();
        Stage stage = new Stage();
        bedRoomAll.start(stage);

    }

    private void closeCurrentStage() {
        Stage currentStage = (Stage) chair_btn.getScene().getWindow();
        currentStage.close();
    }
}
