package org.furniwise.pusl3122_hci_project.Controllers.Common;//package org.furniwise.pusl3122_hci_project.Controllers.Common;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Ellipse;
//import javafx.scene.shape.Line;
//import javafx.stage.Stage;
//
//public class Stool2D extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group root = new Group();
//
//        // Create an ellipse for the seat of the stool
//        Ellipse seat = new Ellipse(200, 150, 100, 20);
//        seat.setFill(Color.SANDYBROWN);
//
//        // Create lines for the legs of the stool
//        // The legs will be simple lines in this 2D view
//        // Front legs
//        Line frontLegLeft = new Line(150, 170, 150, 270);
//        Line frontLegRight = new Line(250, 170, 250, 270);
//
//        // Back legs are partially obscured by the front legs
//        // They are drawn shorter and start a bit higher than the front legs
//        Line backLegLeft = new Line(170, 180, 170, 250);
//        Line backLegRight = new Line(230, 180, 230, 250);
//
//        frontLegLeft.setStrokeWidth(5);
//        frontLegRight.setStrokeWidth(5);
//        backLegLeft.setStrokeWidth(3); // slightly thinner to imply they are further away
//        backLegRight.setStrokeWidth(3); // slightly thinner to imply they are further away
//
//        frontLegLeft.setStroke(Color.SADDLEBROWN);
//        frontLegRight.setStroke(Color.SADDLEBROWN);
//        backLegLeft.setStroke(Color.SADDLEBROWN.darker()); // slightly darker to give depth
//        backLegRight.setStroke(Color.SADDLEBROWN.darker()); // slightly darker to give depth
//
//        // Add the shapes to the group
//        root.getChildren().addAll(seat, backLegLeft, backLegRight, frontLegLeft, frontLegRight);
//
//        Scene scene = new Scene(root, 400, 300, Color.WHITE);
//        primaryStage.setTitle("2D Stool");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.shape.Ellipse;
//import javafx.scene.shape.Line;
//import javafx.stage.Stage;
//
//public class Stool2D extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group root = new Group();
//
//        // Load wood image
//        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
//        ImagePattern woodPattern = new ImagePattern(woodImage);
//
//        // Create an ellipse for the seat of the stool
//        Ellipse seat = new Ellipse(200, 150, 100, 20);
//        seat.setFill(woodPattern);
//
//        // Create lines for the legs of the stool
//        // The legs will be simple lines in this 2D view
//        // Front legs
//        Line frontLegLeft = new Line(150, 170, 150, 270);
//        Line frontLegRight = new Line(250, 170, 250, 270);
//
//        // Back legs are partially obscured by the front legs and attached to the seat
//        Line backLegLeft = new Line(180, 170, 180, 250);
//        Line backLegRight = new Line(220, 170, 220, 250);
//
//        frontLegLeft.setStroke(woodPattern);
//        frontLegRight.setStroke(woodPattern);
//        backLegLeft.setStroke(woodPattern);
//        backLegRight.setStroke(woodPattern);
//
//        frontLegLeft.setStrokeWidth(5);
//        frontLegRight.setStrokeWidth(5);
//        backLegLeft.setStrokeWidth(3); // slightly thinner to imply they are further away
//        backLegRight.setStrokeWidth(3); // slightly thinner to imply they are further away
//
//        // Add the shapes to the group
//        root.getChildren().addAll(seat, backLegLeft, backLegRight, frontLegLeft, frontLegRight);
//
//        Scene scene = new Scene(root, 400, 300);
//        primaryStage.setTitle("2D Stool");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
//

//
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.shape.Ellipse;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//
//public class Stool2D extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group root = new Group();
//
//        // Load wood image
//        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
//        ImagePattern woodPattern = new ImagePattern(woodImage);
//
//        // Create an ellipse for the seat of the stool
//        Ellipse seat = new Ellipse(200, 150, 100, 20);
//        seat.setFill(woodPattern);
//
//        // Create rectangles for the legs of the stool to give them thickness
//        // Front legs
//        Rectangle frontLegLeft = new Rectangle(145, 165, 10, 100);
//        Rectangle frontLegRight = new Rectangle(245, 165, 10, 100);
//
//        // Back legs are partially obscured by the front legs and attached to the seat
//        Rectangle backLegLeft = new Rectangle(154, 165, 7, 80); // slightly thinner
//        Rectangle backLegRight = new Rectangle(239, 165, 7, 80); // slightly thinner
//
//        // Apply wood image pattern to legs
//        frontLegLeft.setFill(woodPattern);
//        frontLegRight.setFill(woodPattern);
//        backLegLeft.setFill(woodPattern);
//        backLegRight.setFill(woodPattern);
//
//        // Add the shapes to the group
//        root.getChildren().addAll(seat, backLegLeft, backLegRight, frontLegLeft, frontLegRight);
//
//        Scene scene = new Scene(root, 400, 300);
//        primaryStage.setTitle("2D Stool");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Stool2D extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Load wood image
        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
        ImagePattern woodPattern = new ImagePattern(woodImage);

        // Create an ellipse for the seat of the stool
        Ellipse seat = new Ellipse(200, 150, 100, 20);
        seat.setFill(woodPattern);

        // Create rectangles for the legs of the stool to give them thickness
        // Front legs
        Rectangle frontLegLeft = new Rectangle(145, 165, 10, 100);
        Rectangle frontLegRight = new Rectangle(245, 165, 10, 100);

        // Back legs are partially obscured by the front legs and attached to the seat
        Rectangle backLegLeft = new Rectangle(154, 165, 7, 80); // slightly thinner
        Rectangle backLegRight = new Rectangle(239, 165, 7, 80); // slightly thinner

        // Apply wood image pattern to legs
        frontLegLeft.setFill(woodPattern);
        frontLegRight.setFill(woodPattern);
        backLegLeft.setFill(woodPattern);
        backLegRight.setFill(woodPattern);

        // Add the shapes to the group
        root.getChildren().addAll(seat, backLegLeft, backLegRight, frontLegLeft, frontLegRight);

        // Center the stool in the scene
//        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("2D Round Table");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
