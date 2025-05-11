package org.furniwise.pusl3122_hci_project.Controllers.Common;
//import javafx.application.Application;
//import javafx.scene.*;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.stage.Stage;
//
//public class Room3D extends Application {
//
//    private static final double ROOM_WIDTH = 800;
//    private static final double ROOM_HEIGHT = 600;
//    private static final double ROOM_DEPTH = 600;
//    private static final double WALL_THICKNESS = 10;
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group root = new Group();
//
//        // Create floor
//        Box floor = new Box(ROOM_WIDTH, ROOM_HEIGHT, WALL_THICKNESS);
//        floor.setTranslateY(ROOM_HEIGHT / 2);
//        floor.setMaterial(new PhongMaterial(Color.GRAY));
//
//        // Create walls
//        Box leftWall = new Box(WALL_THICKNESS, ROOM_HEIGHT, ROOM_DEPTH / 2 - WALL_THICKNESS / 2);
//        leftWall.setTranslateX(-ROOM_WIDTH / 2 + WALL_THICKNESS / 2);
//        leftWall.setTranslateZ(-ROOM_DEPTH / 4 + WALL_THICKNESS / 4);
//        leftWall.setMaterial(new PhongMaterial(Color.LIGHTGRAY));
//
//        Box rightWall = new Box(WALL_THICKNESS, ROOM_HEIGHT, ROOM_DEPTH / 2 - WALL_THICKNESS / 2);
//        rightWall.setTranslateX(ROOM_WIDTH / 2 - WALL_THICKNESS / 2);
//        rightWall.setTranslateZ(-ROOM_DEPTH / 4 + WALL_THICKNESS / 4);
//        rightWall.setMaterial(new PhongMaterial(Color.LIGHTGRAY));
//
//        Box backWall = new Box(ROOM_WIDTH, ROOM_HEIGHT, WALL_THICKNESS);
//        backWall.setTranslateZ(-ROOM_DEPTH / 4 + WALL_THICKNESS / 4);
//        backWall.setMaterial(new PhongMaterial(Color.LIGHTGRAY));
//
//        // Create ceiling
//        Box ceiling = new Box(ROOM_WIDTH, WALL_THICKNESS, ROOM_DEPTH);
//        ceiling.setTranslateY(-ROOM_HEIGHT / 2 + WALL_THICKNESS / 2);
//        ceiling.setMaterial(new PhongMaterial(Color.WHITE));
//
//        root.getChildren().addAll(floor, leftWall, rightWall, backWall, ceiling);
//
//        // Center the room
//        root.translateXProperty().set(ROOM_WIDTH / 2);
//        root.translateYProperty().set(ROOM_HEIGHT / 2);
//        root.translateZProperty().set(ROOM_DEPTH / 4);
//
//        Scene scene = new Scene(root, ROOM_WIDTH, ROOM_HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("3D Room");
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class Room3D extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a material for the walls and floor
//        PhongMaterial wallMaterial = new PhongMaterial();
//        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
//        PhongMaterial floorMaterial = new PhongMaterial();
//        floorMaterial.setDiffuseColor(Color.GRAY);
//
//        // Create the floor
//        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
//        floor.setMaterial(floorMaterial);
//        floor.setTranslateY(-150);
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);  // back wall
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // left wall
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // right wall
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        Group roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
//
//        // Create the scene
//        Scene scene = new Scene(roomGroup, WIDTH, HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        // Set up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setTranslateX(-150);
//        camera.setTranslateY(-150);
//        camera.setTranslateZ(-800);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        scene.setCamera(camera);
//
//        // Rotate the group for a better initial view
//        roomGroup.setRotationAxis(Rotate.Y_AXIS);
//        roomGroup.setRotate(30);
//
//        primaryStage.setTitle("JavaFX 3D Room");
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
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class Room3D extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a material for the walls and floor
//        PhongMaterial wallMaterial = new PhongMaterial();
//        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
//        PhongMaterial floorMaterial = new PhongMaterial();
//        floorMaterial.setDiffuseColor(Color.GRAY);
//
//        // Create the floor
//        Box floor = new Box(ROOM_WIDTH, ROOM_DEPTH, 1); // Updated to add a floor
//        floor.setMaterial(floorMaterial);
//        floor.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);  // back wall
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // left wall
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // right wall
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        Group roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
//
//        // Create the scene
//        Scene scene = new Scene(roomGroup, WIDTH, HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        // Set up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setTranslateX(-150);
//        camera.setTranslateY(-150);
//        camera.setTranslateZ(-800);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        scene.setCamera(camera);
//
//        // Rotate the group for a better initial view
//        roomGroup.setRotationAxis(Rotate.Y_AXIS);
//        roomGroup.setRotate(30);
//
//        primaryStage.setTitle("JavaFX 3D Room");
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
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class Room3D extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a material for the walls and floor
//        PhongMaterial wallMaterial = new PhongMaterial();
//        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
//        PhongMaterial floorMaterial = new PhongMaterial();
//        floorMaterial.setDiffuseColor(Color.GRAY);
//
//        // Create the floor
//        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
//        floor.setMaterial(floorMaterial);
//        floor.setTranslateY(ROOM_HEIGHT / 2); // Align the floor horizontally
//        floor.setTranslateX(-ROOM_WIDTH / 2); // Move the floor to the left edge
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);  // back wall
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // left wall
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // right wall
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        Group roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
//
//        // Create the scene
//        Scene scene = new Scene(roomGroup, WIDTH, HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        // Set up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setTranslateX(-150);
//        camera.setTranslateY(-150);
//        camera.setTranslateZ(-800);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        scene.setCamera(camera);
//
//        // Rotate the group for a better initial view
//        roomGroup.setRotationAxis(Rotate.Y_AXIS);
//        roomGroup.setRotate(30);
//
//        primaryStage.setTitle("JavaFX 3D Room");
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
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class Room3D extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a material for the walls and floor
//        PhongMaterial wallMaterial = new PhongMaterial();
//        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
//        PhongMaterial floorMaterial = new PhongMaterial();
//        floorMaterial.setDiffuseColor(Color.GRAY);
//
//        // Create the floor
//        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
//        floor.setMaterial(floorMaterial);
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 60); // Adjust the floor position closer to the walls
//        floor.setTranslateX(-ROOM_WIDTH / 2 - 60); // Move the floor to the left edge
//        floor.setTranslateZ(125);
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);  // back wall
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // left wall
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // right wall
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        Group roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
//
//        // Create the scene
//        Scene scene = new Scene(roomGroup, WIDTH, HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        // Set up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setTranslateX(-150);
//        camera.setTranslateY(-150);
//        camera.setTranslateZ(-800);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        scene.setCamera(camera);
//
//        // Rotate the group for a better initial view
//        roomGroup.setRotationAxis(Rotate.Y_AXIS);
//        roomGroup.setRotate(30);
//
//        primaryStage.setTitle("JavaFX 3D Room");
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
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class Room3D extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private Group roomGroup;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a material for the walls and floor
//        PhongMaterial wallMaterial = new PhongMaterial();
//        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
//        PhongMaterial floorMaterial = new PhongMaterial();
//        floorMaterial.setDiffuseColor(Color.GRAY);
//
//        // Create the floor
//        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
//        floor.setMaterial(floorMaterial);
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 60); // Adjust the floor position closer to the walls
//        floor.setTranslateZ(-ROOM_DEPTH / 2); // Align floor with back wall
//        floor.setTranslateX(-ROOM_WIDTH / 2);
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);  // back wall
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // left wall
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // right wall
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
//
//        // Create the scene
//        Scene scene = new Scene(roomGroup, WIDTH, HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        // Set up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setTranslateX(-150);
//        camera.setTranslateY(-150);
//        camera.setTranslateZ(-800);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        scene.setCamera(camera);
//
//        // Add rotation feature
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) {
//                roomGroup.setRotationAxis(Rotate.Y_AXIS);
//                roomGroup.setRotate(roomGroup.getRotate() + 10);
//            } else if (event.getCode() == KeyCode.RIGHT) {
//                roomGroup.setRotationAxis(Rotate.Y_AXIS);
//                roomGroup.setRotate(roomGroup.getRotate() - 10);
//            }
//        });
//
//        primaryStage.setTitle("JavaFX 3D Room");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Room3D extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double ROOM_WIDTH = 600;
    private static final double ROOM_HEIGHT = 300;
    private static final double ROOM_DEPTH = 600;

    private Group roomGroup;

    @Override
    public void start(Stage primaryStage) {
        // Create a material for the walls and floor
        PhongMaterial wallMaterial = new PhongMaterial();
        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
        PhongMaterial floorMaterial = new PhongMaterial();
        floorMaterial.setDiffuseColor(Color.GRAY);

        // Create the floor
        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
        floor.setMaterial(floorMaterial);
        floor.setTranslateY(ROOM_HEIGHT / 2 - 60); // Adjust the floor position closer to the walls
        floor.setTranslateZ(-ROOM_DEPTH / 2 + 300); // Align floor with back wall
        floor.setTranslateX(-ROOM_WIDTH / 2 + 300);
        floor.setTranslateY(ROOM_HEIGHT / 2 - 150); // Vertically align the floor with the bottom edge of the walls

        // Create walls
        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);  // back wall
        wallBack.setMaterial(wallMaterial);
        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
        wallBack.setTranslateZ(+300);

        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // left wall
        wallLeft.setMaterial(wallMaterial);
        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);

        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // right wall
        wallRight.setMaterial(wallMaterial);
        wallRight.setTranslateX(ROOM_WIDTH / 2);
        wallRight.setTranslateY(-ROOM_HEIGHT / 2);

        // Create a group to hold all parts of the room
        roomGroup = new Group(floor, wallBack, wallLeft, wallRight);

        // Create the scene
        Scene scene = new Scene(roomGroup, WIDTH, HEIGHT, true);
        scene.setFill(Color.WHITE);

        // Set up the camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateX(-150);
        camera.setTranslateY(-150);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        scene.setCamera(camera);

        // Add rotation feature
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() + 10);
            } else if (event.getCode() == KeyCode.RIGHT) {
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() - 10);
            }
        });

        primaryStage.setTitle("JavaFX 3D Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class Room3D extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private SampleGroup roomGroup;
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a material for the walls and floor
//        PhongMaterial wallMaterial = new PhongMaterial();
//        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
//        PhongMaterial floorMaterial = new PhongMaterial();
//        floorMaterial.setDiffuseColor(Color.GRAY);
//
//        // Create the floor
//        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
//        floor.setMaterial(floorMaterial);
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 60); // Adjust the floor position closer to the walls
//        floor.setTranslateZ(-ROOM_DEPTH / 2 + 300); // Align floor with back wall
//        floor.setTranslateX(-ROOM_WIDTH / 2 + 300);
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 150); // Vertically align the floor with the bottom edge of the walls
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);  // back wall
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//        wallBack.setTranslateZ(+300);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // left wall
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);  // right wall
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        roomGroup = new SampleGroup(floor, wallBack, wallLeft, wallRight);
//
//        // Center the room
////        roomGroup.setTranslateX(WIDTH / 2);
////        roomGroup.setTranslateY(HEIGHT / 2);
//        roomGroup.setTranslateX((WIDTH - ROOM_WIDTH) / 2 - 200);
//        roomGroup.setTranslateY((HEIGHT - ROOM_HEIGHT) / 2 - 150);
//
//        // Create the scene
//        Scene scene = new Scene(roomGroup, WIDTH, HEIGHT, true);
//        scene.setFill(Color.WHITE);
//
//        // Set up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setTranslateX(-150);
//        camera.setTranslateY(-150);
//        camera.setTranslateZ(-1000);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        scene.setCamera(camera);
//
//        // Rotate the room using mouse drag
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = roomGroup.getRotateX();
//            anchorAngleY = roomGroup.getRotateY();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            roomGroup.setRotateX(anchorAngleX - (anchorY - event.getSceneY()));
//            roomGroup.setRotateY(anchorAngleY + (anchorX - event.getSceneX()));
//        });
//
//        primaryStage.setTitle("JavaFX 3D Room");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom SampleGroup class
//    class SampleGroup extends Group {
//        SampleGroup(Box... boxes) {
//            super(boxes);
//        }
//
//        double getRotateX() {
//            return getRotateX();
//        }
//
//        double getRotateY() {
//            return getRotateY();
//        }
//
//        void setRotateX(double angle) {
//            setRotate(angle);
//        }
//
//        void setRotateY(double angle) {
//            setRotate(angle);
//        }
//    }
//}
