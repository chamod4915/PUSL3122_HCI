package org.furniwise.pusl3122_hci_project.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Common.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {
    public ListView transactions_listview;
    public Button chair_2D_btn;
    public Button chair_3D_btn;
    public Button table_2D_btn;
    public Button table_3D_btn;
    public Button round_table_2d_btn;
    public Button round_table_3d_btn;
    public Button bed_2d_btn;
    public Button bed_3d_btn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("wokring...Transactions..");
        // Add event handlers for button clicks
        chair_2D_btn.setOnAction(event -> open2DChairWindow());
        chair_3D_btn.setOnAction(event -> open3DChairWindow());
        table_2D_btn.setOnAction(event -> open2DTableWindow());
        table_3D_btn.setOnAction(event -> open3DTableWindow());
        round_table_2d_btn.setOnAction(event -> open2DRoundTableWindow());
        round_table_3d_btn.setOnAction(event -> open3DRoundTableWindow());
        bed_2d_btn.setOnAction(event -> open2DBedWindow());
        bed_3d_btn.setOnAction(event -> open3DBedWindow());


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

    private void open2DTableWindow() {
        System.out.println("working..");
        Table2D table2D = new Table2D();
        Stage stage = new Stage();
        table2D.start(stage);
    }

    private void open3DTableWindow() {
        System.out.println("working..3d");

        Table3D table3D = new Table3D();
        Stage stage = new Stage();
        table3D.start(stage);
    }


    private void open2DBedWindow() {
        System.out.println("working..");
        Bed2D bed2D = new Bed2D();
        Stage stage = new Stage();
        bed2D.start(stage);
    }

    private void open3DBedWindow() {
        System.out.println("working..3d");

        Bed3D bed3D = new Bed3D();
        Stage stage = new Stage();
        bed3D.start(stage);
    }


    private void open2DRoundTableWindow() {
        System.out.println("working..");
        Stool2D stool2D = new Stool2D();
        Stage stage = new Stage();
        stool2D.start(stage);
    }

    private void open3DRoundTableWindow() {
        System.out.println("working..3d");

        Stool3D stool3D = new Stool3D();
        Stage stage = new Stage();
        stool3D.start(stage);
    }
}
