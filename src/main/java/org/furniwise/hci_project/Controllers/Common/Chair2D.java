package org.furniwise.pusl3122_hci_project.Controllers.Common;//package org.furniwise.pusl3122_hci_project.Controllers.Common;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//
//public class Chair2D extends Application {
//
//    private static final float WIDTH = 300;
//    private static final float HEIGHT = 400;
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group group = new Group();
//
//        // Load wood image
//        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
//        ImagePattern woodPattern = new ImagePattern(woodImage);
//
//        // Create rectangles for the chair parts
//        // Chair seat
//        Rectangle seat = new Rectangle(100, 20);
//        seat.setFill(woodPattern);
//        seat.setX(WIDTH / 2 - seat.getWidth() / 2);
//        seat.setY(HEIGHT / 2);
//
//        // Chair backrest
//        Rectangle backrest = new Rectangle(100, 80);
//        backrest.setFill(woodPattern);
//        backrest.setX(WIDTH / 2 - backrest.getWidth() / 2);
//        backrest.setY(seat.getY() - backrest.getHeight());
//
//        // Chair legs - front left leg
//        Rectangle frontLegLeft = new Rectangle(10, 100);
//        frontLegLeft.setFill(woodPattern);
//        frontLegLeft.setX(seat.getX());
//        frontLegLeft.setY(seat.getY() + seat.getHeight());
//
//        // Chair legs - front right leg
//        Rectangle frontLegRight = new Rectangle(10, 100);
//        frontLegRight.setFill(woodPattern);
//        frontLegRight.setX(seat.getX() + seat.getWidth() - frontLegRight.getWidth());
//        frontLegRight.setY(seat.getY() + seat.getHeight());
//
//        // Add all parts to the group
//        group.getChildren().addAll(seat, backrest, frontLegLeft, frontLegRight);
//
//        Scene scene = new Scene(group, WIDTH, HEIGHT);
//        scene.setFill(Color.WHITE);
//
//        primaryStage.setTitle("2D Chair in JavaFX");
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
//public class Chair2D extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group group = new Group();
//
//        // Load wood image
//        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
//        ImagePattern woodPattern = new ImagePattern(woodImage);
//
//        // Create rectangles for the chair parts
//        // Chair seat
//        Rectangle seat = new Rectangle(120, 20); // wider front
//        seat.setFill(woodPattern);
//
//        // Chair backrest
//        Rectangle backrest = new Rectangle(100, 80);
//        backrest.setFill(woodPattern);
//
//        // Chair legs - front left leg
//        Rectangle frontLegLeft = new Rectangle(10, 100);
//        frontLegLeft.setFill(woodPattern);
//
//        // Chair legs - front right leg
//        Rectangle frontLegRight = new Rectangle(10, 100);
//        frontLegRight.setFill(woodPattern);
//
//        // Chair legs - back left leg
//        Rectangle backLegLeft = new Rectangle(10, 90); // slightly shorter
//        backLegLeft.setFill(woodPattern);
//        backLegLeft.setOpacity(0.8); // slightly transparent to indicate depth
//
//        // Chair legs - back right leg
//        Rectangle backLegRight = new Rectangle(10, 90); // slightly shorter
//        backLegRight.setFill(woodPattern);
//        backLegRight.setOpacity(0.8); // slightly transparent to indicate depth
//
//        // Add all parts to the group
//        group.getChildren().addAll(backLegLeft, backLegRight, seat, backrest, frontLegLeft, frontLegRight);
//
//        Scene scene = new Scene(group, 300, 400);
//        scene.setFill(Color.WHITE);
//
//        // Bind the chair components to the center of the scene
//        seat.xProperty().bind(Bindings.createDoubleBinding(() -> scene.getWidth() / 2 - seat.getWidth() / 2, scene.widthProperty()));
//        seat.yProperty().bind(Bindings.createDoubleBinding(() -> scene.getHeight() / 2, scene.heightProperty()));
//
//        backrest.xProperty().bind(Bindings.createDoubleBinding(() -> scene.getWidth() / 2 - backrest.getWidth() / 2, scene.widthProperty()));
//        backrest.yProperty().bind(Bindings.createDoubleBinding(() -> scene.getHeight() / 2 - backrest.getHeight(), scene.heightProperty()));
//
//        frontLegLeft.xProperty().bind(seat.xProperty());
//        frontLegLeft.yProperty().bind(seat.yProperty().add(seat.heightProperty()));
//
//        frontLegRight.xProperty().bind(seat.xProperty().add(seat.widthProperty()).subtract(frontLegRight.widthProperty()));
//        frontLegRight.yProperty().bind(seat.yProperty().add(seat.heightProperty()));
//
//        backLegLeft.xProperty().bind(seat.xProperty().subtract(frontLegLeft.widthProperty()));
//        backLegLeft.yProperty().bind(seat.yProperty().add(seat.heightProperty()));
//
//        backLegRight.xProperty().bind(seat.xProperty().add(seat.widthProperty()));
//        backLegRight.yProperty().bind(seat.yProperty().add(seat.heightProperty()));
//
//        primaryStage.setTitle("2D Chair in JavaFX");
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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chair2D extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        // Load wood image
        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
        ImagePattern woodPattern = new ImagePattern(woodImage);

        // Create rectangles for the chair parts
        // Chair seat
        Rectangle seat = new Rectangle(120, 20); // wider front
        seat.setFill(woodPattern);

        // Chair backrest
        Rectangle backrest = new Rectangle(100, 100);
        backrest.setFill(woodPattern);

        // Chair legs - front left leg
        Rectangle frontLegLeft = new Rectangle(10, 100);
        frontLegLeft.setFill(woodPattern);

        // Chair legs - front right leg
        Rectangle frontLegRight = new Rectangle(10, 100);
        frontLegRight.setFill(woodPattern);

        // Chair legs - back left leg
        Rectangle backLegLeft = new Rectangle(10, 100); // same height as front for visibility
        backLegLeft.setFill(woodPattern);
        backLegLeft.setOpacity(0.8); // slightly transparent to indicate depth

        // Chair legs - back right leg
        Rectangle backLegRight = new Rectangle(10, 100); // same height as front for visibility
        backLegRight.setFill(woodPattern);
        backLegRight.setOpacity(0.8); // slightly transparent to indicate depth

        // Add all parts to the group
        group.getChildren().addAll(backLegLeft, backLegRight, seat, backrest, frontLegLeft, frontLegRight);

        Scene scene = new Scene(group, 300, 400);
        scene.setFill(Color.WHITE);

        // Bind the chair components to the center of the scene
        seat.xProperty().bind(Bindings.createDoubleBinding(() -> scene.getWidth() / 2 - seat.getWidth() / 2, scene.widthProperty()));
        seat.yProperty().bind(Bindings.createDoubleBinding(() -> scene.getHeight() / 2, scene.heightProperty()));

        backrest.xProperty().bind(Bindings.createDoubleBinding(() -> scene.getWidth() / 2 - backrest.getWidth() / 2, scene.widthProperty()));
        backrest.yProperty().bind(Bindings.createDoubleBinding(() -> seat.getY() - backrest.getHeight(), seat.yProperty()));

        // The front legs are positioned normally
        frontLegLeft.xProperty().bind(seat.xProperty());
        frontLegLeft.yProperty().bind(seat.yProperty().add(seat.heightProperty()));

        frontLegRight.xProperty().bind(seat.xProperty().add(seat.widthProperty()).subtract(frontLegRight.widthProperty()));
        frontLegRight.yProperty().bind(seat.yProperty().add(seat.heightProperty()));

        // The back legs are positioned with a slight offset to give the illusion they are behind
        backLegLeft.xProperty().bind(seat.xProperty().add(frontLegLeft.widthProperty()));
        backLegLeft.yProperty().bind(seat.yProperty().add(seat.heightProperty()).subtract(10)); // slight vertical offset

        backLegRight.xProperty().bind(seat.xProperty().add(seat.widthProperty()).subtract(frontLegRight.widthProperty()).subtract(backLegRight.widthProperty()));
        backLegRight.yProperty().bind(seat.yProperty().add(seat.heightProperty()).subtract(10)); // slight vertical offset

        primaryStage.setTitle("2D Chair");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
