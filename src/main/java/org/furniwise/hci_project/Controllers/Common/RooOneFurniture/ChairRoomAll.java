package org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.BedNode;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.TableNode;
//
//public class ChairRoomAll extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private double mouseX, mouseY;
//    private boolean isDragging = false;
//
//    private Group roomGroup;
//    private ChairNode chair;
//    private TableNode table;
//
//    private BedNode bed;
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
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 60);
//        floor.setTranslateZ(-ROOM_DEPTH / 2 + 300);
//        floor.setTranslateX(-ROOM_WIDTH / 2 + 300);
//        floor.setTranslateY(ROOM_HEIGHT / 2 - 150);
//
//        // Create walls
//        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);
//        wallBack.setMaterial(wallMaterial);
//        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
//        wallBack.setTranslateZ(+300);
//
//        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
//        wallLeft.setMaterial(wallMaterial);
//        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
//        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
//
//        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
//        wallRight.setMaterial(wallMaterial);
//        wallRight.setTranslateX(ROOM_WIDTH / 2);
//        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
//
//        // Create a group to hold all parts of the room
//        roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
//
//        // Center the room
//        roomGroup.setTranslateX((WIDTH - ROOM_WIDTH) / 2 - 200);
//        roomGroup.setTranslateY((HEIGHT - ROOM_HEIGHT) / 2 - 150);
//
//        // Create the chair
//        chair = new ChairNode();
//        roomGroup.getChildren().add(chair);
//
//        // Create the table
//        table = new TableNode();
//        table.setTranslateX(-200); // Adjust position as needed
//        table.setTranslateZ(200); // Adjust position as needed
//        table.setTranslateY(-23);
//        roomGroup.getChildren().add(table);
//
//        bed = new BedNode();
//        bed.setTranslateX(200); // Adjust position as needed
//        bed.setTranslateZ(150); // Adjust position as needed
//        bed.setTranslateY(-72);
//        bed.rotateBed(-450,0);
//        roomGroup.getChildren().add(bed);
//
//        // Create a layout pane for 2D content overlay
//        StackPane overlayPane = new StackPane();
//        overlayPane.setPrefSize(WIDTH, HEIGHT);
//
//        // Create the scene with the roomGroup and overlayPane
//        Scene scene = new Scene(new Group(roomGroup, overlayPane), WIDTH, HEIGHT, true);
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
//        // Set up mouse event handlers for chair rotation
//        scene.setOnMousePressed(event -> {
//            chair.setMouseStart(event.getSceneX(), event.getSceneY());
//        });
//
//        scene.setOnMouseDragged(event -> {
//            chair.rotateChair(event.getSceneX(), event.getSceneY());
//        });
//
//        // Set up keyboard event handlers
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) {
//                chair.rotateChairNode(0, -10, 0); // Rotate chair left
//            } else if (event.getCode() == KeyCode.RIGHT) {
//                chair.rotateChairNode(0, 10, 0); // Rotate chair right
//            } else if (event.getCode() == KeyCode.A) {
//                roomGroup.setRotationAxis(Rotate.Y_AXIS);
//                roomGroup.setRotate(roomGroup.getRotate() + 10);
//            } else if (event.getCode() == KeyCode.D) {
//                roomGroup.setRotationAxis(Rotate.Y_AXIS);
//                roomGroup.setRotate(roomGroup.getRotate() - 10);
//            } else if (event.getCode() == KeyCode.W) {
//                roomGroup.setRotationAxis(Rotate.X_AXIS);
//                roomGroup.setRotate(roomGroup.getRotate() + 10);
//            } else if (event.getCode() == KeyCode.S) {
//                roomGroup.setRotationAxis(Rotate.X_AXIS);
//                roomGroup.setRotate(roomGroup.getRotate() - 10);
//            } else if (event.getCode() == KeyCode.UP) {
//                chair.adjustTranslation(0, 0, -10); // Move chair forward
//            } else if (event.getCode() == KeyCode.DOWN) {
//                chair.adjustTranslation(0, 0, 10); // Move chair backward
//            }
//        });
//
//        scene.setOnMousePressed(event -> {
//            mouseX = event.getSceneX();
//            mouseY = event.getSceneY();
//            isDragging = chair.getBoundsInParent().contains(event.getX(), event.getY());
//        });
//
//        scene.setOnMouseDragged(event -> {
//            double deltaX = event.getSceneX() - mouseX;
//            double deltaY = event.getSceneY() - mouseY;
//            chair.adjustTranslation(deltaX, deltaY, 0);
//            mouseX = event.getSceneX();
//            mouseY = event.getSceneY();
//        });
//
//        scene.setOnMouseReleased(event -> {
//            isDragging = false;
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
//


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.BedNode;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.RoundTableNode;
import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.TableNode;

public class ChairRoomAll extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double ROOM_WIDTH = 600;
    private static final double ROOM_HEIGHT = 300;
    private static final double ROOM_DEPTH = 600;
    private static final double ZOOM_SPEED = 50;

    private double mouseX, mouseY;
    private boolean isDragging = false;

    private Group roomGroup;
    private ChairNode chair;
    private TableNode table;
    private BedNode bed;
    private RoundTableNode roundTable;
    private PerspectiveCamera camera;

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
        floor.setTranslateY(ROOM_HEIGHT / 2 - 60);
        floor.setTranslateZ(-ROOM_DEPTH / 2 + 300);
        floor.setTranslateX(-ROOM_WIDTH / 2 + 300);
        floor.setTranslateY(ROOM_HEIGHT / 2 - 150);

        // Create walls
        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);
        wallBack.setMaterial(wallMaterial);
        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
        wallBack.setTranslateZ(+300);

        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
        wallLeft.setMaterial(wallMaterial);
        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);

        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
        wallRight.setMaterial(wallMaterial);
        wallRight.setTranslateX(ROOM_WIDTH / 2);
        wallRight.setTranslateY(-ROOM_HEIGHT / 2);

        // Create a group to hold all parts of the room
        roomGroup = new Group(floor, wallBack, wallLeft, wallRight);

        // Center the room
        roomGroup.setTranslateX((WIDTH - ROOM_WIDTH) / 2 - 200);
        roomGroup.setTranslateY((HEIGHT - ROOM_HEIGHT) / 2 - 150);

        // Create the chair
        chair = new ChairNode();
        roomGroup.getChildren().add(chair);

        // Create the table
        table = new TableNode();
        table.setTranslateX(-220); // Adjust position as needed
        table.setTranslateZ(-170); // Adjust position as needed
        table.setTranslateY(-30);
        roomGroup.getChildren().add(table);

        // Create the table
        roundTable = new RoundTableNode();
        roundTable.setTranslateX(-200); // Adjust position as needed
        roundTable.setTranslateZ(200); // Adjust position as needed
        roundTable.setTranslateY(-30);
        roomGroup.getChildren().add(roundTable);

        // Create the bed
        bed = new BedNode();
        bed.setTranslateX(200); // Adjust position as needed
        bed.setTranslateZ(150); // Adjust position as needed
        bed.setTranslateY(-72);
        bed.rotateBed(-450, 0);
        roomGroup.getChildren().add(bed);

        // Create a layout pane for 2D content overlay
        StackPane overlayPane = new StackPane();
        overlayPane.setPrefSize(WIDTH, HEIGHT);

        // Create the scene with the roomGroup and overlayPane
        Scene scene = new Scene(new Group(roomGroup, overlayPane), WIDTH, HEIGHT, true);
        scene.setFill(Color.WHITE);

        // Set up the camera
        camera = new PerspectiveCamera(true);
        camera.setTranslateX(-150);
        camera.setTranslateY(-150);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        scene.setCamera(camera);

        // Set up mouse event handlers for chair rotation
        scene.setOnMousePressed(event -> {
            chair.setMouseStart(event.getSceneX(), event.getSceneY());
        });

        scene.setOnMouseDragged(event -> {
            chair.rotateChair(event.getSceneX(), event.getSceneY());
        });

        // Set up keyboard event handlers
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                chair.rotateChairNode(0, -10, 0); // Rotate chair left
            } else if (event.getCode() == KeyCode.RIGHT) {
                chair.rotateChairNode(0, 10, 0); // Rotate chair right
            } else if (event.getCode() == KeyCode.A) {
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() + 10);
            } else if (event.getCode() == KeyCode.D) {
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() - 10);
            } else if (event.getCode() == KeyCode.W) {
                roomGroup.setRotationAxis(Rotate.X_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() + 10);
            } else if (event.getCode() == KeyCode.S) {
                roomGroup.setRotationAxis(Rotate.X_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() - 10);
            } else if (event.getCode() == KeyCode.UP) {
                chair.adjustTranslation(0, 0, -10); // Move chair forward
            } else if (event.getCode() == KeyCode.DOWN) {
                chair.adjustTranslation(0, 0, 10); // Move chair backward
            } else if (event.getCode() == KeyCode.G) {
                camera.setTranslateZ(camera.getTranslateZ() - ZOOM_SPEED); // Zoom in
            } else if (event.getCode() == KeyCode.T) {
                camera.setTranslateZ(camera.getTranslateZ() + ZOOM_SPEED); // Zoom out
            }
        });

        scene.setOnMousePressed(event -> {
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
            isDragging = chair.getBoundsInParent().contains(event.getX(), event.getY());
        });

        scene.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseX;
            double deltaY = event.getSceneY() - mouseY;
            chair.adjustTranslation(deltaX, deltaY, 0);
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
        });

        scene.setOnMouseReleased(event -> {
            isDragging = false;
        });

        primaryStage.setTitle("JavaFX 3D Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
