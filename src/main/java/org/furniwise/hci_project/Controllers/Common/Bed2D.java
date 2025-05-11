package org.furniwise.pusl3122_hci_project.Controllers.Common;//package org.furniwise.pusl3122_hci_project.Controllers.Common;
//
//import javafx.application.Application;
//import javafx.beans.binding.Bindings;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//
//public class Bed2D extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group group = new Group();
//
//        // Load wood image
//        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
//        ImagePattern woodPattern = new ImagePattern(woodImage);
//
//        // Create rectangles for the bed parts
//        // Bed base
//        Rectangle base = new Rectangle(200, 120);
//        base.setFill(woodPattern);
//
//        // Bed headboard
//        Rectangle headboard = new Rectangle(200, 40);
//        headboard.setFill(woodPattern);
//
//        // Bed legs - front left leg
//        Rectangle frontLegLeft = new Rectangle(10, 40);
//        frontLegLeft.setFill(woodPattern);
//
//        // Bed legs - front right leg
//        Rectangle frontLegRight = new Rectangle(10, 40);
//        frontLegRight.setFill(woodPattern);
//
//        // Bed legs - back left leg
//        Rectangle backLegLeft = new Rectangle(10, 40);
//        backLegLeft.setFill(woodPattern);
//
//        // Bed legs - back right leg
//        Rectangle backLegRight = new Rectangle(10, 40);
//        backLegRight.setFill(woodPattern);
//
//        // Add all parts to the group
//        group.getChildren().addAll(base, headboard, frontLegLeft, frontLegRight, backLegLeft, backLegRight);
//
//        Scene scene = new Scene(group, 300, 400);
//        scene.setFill(Color.WHITE);
//
//        // Bind the bed components to the center of the scene
//        base.xProperty().bind(Bindings.createDoubleBinding(() -> scene.getWidth() / 2 - base.getWidth() / 2, scene.widthProperty()));
//        base.yProperty().bind(Bindings.createDoubleBinding(() -> scene.getHeight() / 2, scene.heightProperty()));
//
//        headboard.xProperty().bind(base.xProperty());
//        headboard.yProperty().bind(base.yProperty().subtract(headboard.heightProperty()));
//
//        frontLegLeft.xProperty().bind(base.xProperty());
//        frontLegLeft.yProperty().bind(base.yProperty().add(base.heightProperty()));
//
//        frontLegRight.xProperty().bind(base.xProperty().add(base.widthProperty()).subtract(frontLegRight.widthProperty()));
//        frontLegRight.yProperty().bind(base.yProperty().add(base.heightProperty()));
//
//        backLegLeft.xProperty().bind(base.xProperty());
//        backLegLeft.yProperty().bind(base.yProperty().subtract(backLegLeft.heightProperty()));
//
//        backLegRight.xProperty().bind(base.xProperty().add(base.widthProperty()).subtract(backLegRight.widthProperty()));
//        backLegRight.yProperty().bind(base.yProperty().subtract(backLegRight.heightProperty()));
//
//        primaryStage.setTitle("2D Bed in JavaFX");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bed2D extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group bedGroup = new Group();

        // Load wood image
        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
        ImagePattern woodPattern = new ImagePattern(woodImage);

        // Create rectangles for bed parts
        Rectangle base = new Rectangle(200, 120);
        base.setFill(woodPattern);

        Rectangle headboard = new Rectangle(200, 40);
        headboard.setFill(woodPattern);

        Rectangle frontLegLeft = new Rectangle(10, 40);
        frontLegLeft.setFill(woodPattern);

        Rectangle frontLegRight = new Rectangle(10, 40);
        frontLegRight.setFill(woodPattern);

        Rectangle backLegLeft = new Rectangle(10, 40);
        backLegLeft.setFill(woodPattern);

        Rectangle backLegRight = new Rectangle(10, 40);
        backLegRight.setFill(woodPattern);

        // Add parts to bed group
        bedGroup.getChildren().addAll(base, headboard, frontLegLeft, frontLegRight, backLegLeft, backLegRight);

        // Create the ColorPicker
        ColorPicker colorPicker = new ColorPicker(Color.BEIGE);
        colorPicker.setOnAction(e -> {
            Color selectedColor = colorPicker.getValue();
            base.setFill(selectedColor);
            headboard.setFill(selectedColor);
            frontLegLeft.setFill(selectedColor);
            frontLegRight.setFill(selectedColor);
            backLegLeft.setFill(selectedColor);
            backLegRight.setFill(selectedColor);
        });

        VBox controls = new VBox(10, colorPicker);
        controls.setPadding(new Insets(10));
        controls.setPickOnBounds(false);
        controls.setTranslateX(10);
        controls.setTranslateY(10);

        StackPane root = new StackPane();
        root.getChildren().addAll(bedGroup, controls);

        Scene scene = new Scene(root, 300, 400);
        scene.setFill(Color.WHITE);

        // Bind bed parts to center
        base.xProperty().bind(Bindings.createDoubleBinding(() -> scene.getWidth() / 2 - base.getWidth() / 2, scene.widthProperty()));
        base.yProperty().bind(Bindings.createDoubleBinding(() -> scene.getHeight() / 2 - base.getHeight() / 2, scene.heightProperty()));

        headboard.xProperty().bind(base.xProperty());
        headboard.yProperty().bind(base.yProperty().subtract(headboard.heightProperty()));

        frontLegLeft.xProperty().bind(base.xProperty());
        frontLegLeft.yProperty().bind(base.yProperty().add(base.heightProperty()));

        frontLegRight.xProperty().bind(base.xProperty().add(base.widthProperty()).subtract(frontLegRight.widthProperty()));
        frontLegRight.yProperty().bind(base.yProperty().add(base.heightProperty()));

        backLegLeft.xProperty().bind(base.xProperty());
        backLegLeft.yProperty().bind(base.yProperty().subtract(backLegLeft.heightProperty()));

        backLegRight.xProperty().bind(base.xProperty().add(base.widthProperty()).subtract(backLegRight.widthProperty()));
        backLegRight.yProperty().bind(base.yProperty().subtract(backLegRight.heightProperty()));

        primaryStage.setTitle("2D Bed with Color Picker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
