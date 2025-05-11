package org.furniwise.pusl3122_hci_project.Controllers.Common.RooOneFurniture;
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
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
//
//
//public class ChairRoom extends Application {
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
//
//
//        // Center the room
////        roomGroup.setTranslateX(WIDTH / 2);
////        roomGroup.setTranslateY(HEIGHT / 2);
//        roomGroup.setTranslateX((WIDTH - ROOM_WIDTH) / 2 - 200);
//        roomGroup.setTranslateY((HEIGHT - ROOM_HEIGHT) / 2 - 150);
//
//        // Create the chair
//        ChairNode chair = new ChairNode();
////        chair.setTranslateX(100); // Adjust the X position as needed
////        chair.setTranslateY(50);  // Adjust the Y position as needed
////        chair.setTranslateZ(100); // Adjust the Z position as needed
//
//        // Add the chair to the room group
//        roomGroup.getChildren().add(chair);
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
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
//
//public class ChairRoom extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private Group roomGroup;
//    private ChairNode chair;
//    private double mouseX, mouseY;
//    private boolean isDragging = false;
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
//        // Rotate the chair using arrow keys
//        scene.setOnKeyPressed(event -> {
//            switch (event.getCode()) {
//                case UP:
//                    chair.rotateChair(0, -5, 0);
//                    break;
//                case DOWN:
//                    chair.rotateChair(0, 5, 0);
//                    break;
//                case LEFT:
//                    chair.rotateChair(0, 0, -5);
//                    break;
//                case RIGHT:
//                    chair.rotateChair(0, 0, 5);
//                    break;
//            }
//        });
//
//        // Drag and drop the chair using the mouse
//        scene.setOnMousePressed(event -> {
//            mouseX = event.getSceneX();
//            mouseY = event.getSceneY();
//            isDragging = chair.getBoundsInParent().contains(event.getX(), event.getY());
//        });
//
//        scene.setOnMouseDragged(event -> {
//            if (isDragging) {
//                double deltaX = event.getSceneX() - mouseX;
//                double deltaY = event.getSceneY() - mouseY;
//                chair.adjustTranslation(deltaX, deltaY, 0);
//                mouseX = event.getSceneX();
//                mouseY = event.getSceneY();
//            }
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
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
//
//public class ChairRoom extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private Group roomGroup;
//    private ChairNode chair;
//    private double mouseX, mouseY;
//    private boolean isDragging = false;
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
//        // Drag and drop the chair using the mouse
//        scene.setOnMousePressed(event -> {
//            mouseX = event.getSceneX();
//            mouseY = event.getSceneY();
//            isDragging = chair.getBoundsInParent().contains(event.getX(), event.getY());
//        });
//
//        scene.setOnMouseDragged(event -> {
//            if (isDragging) {
//                double deltaX = event.getSceneX() - mouseX;
//                double deltaY = event.getSceneY() - mouseY;
//                chair.adjustTranslation(deltaX, deltaY, 0);
//                mouseX = event.getSceneX();
//                mouseY = event.getSceneY();
//            }
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
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
//
//public class ChairRoom extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private Group roomGroup;
//    private ChairNode chair;
//    private double mouseX, mouseY;
//    private boolean isDragging = false;
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
//        // Drag and drop the chair using the mouse
//        scene.setOnMousePressed(event -> {
//            mouseX = event.getSceneX();
//            mouseY = event.getSceneY();
//            isDragging = chair.getBoundsInParent().contains(event.getX(), event.getY());
//        });
//
////        scene.setOnMouseDragged(event -> {
////            if (isDragging) {
////                double deltaX = event.getSceneX() - mouseX;
////                double deltaY = event.getSceneY() - mouseY;
////                chair.adjustTranslation(deltaX, deltaY, 0);
////                mouseX = event.getSceneX();
////                mouseY = event.getSceneY();
////            }
////        });
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
//        // Rotate the chair using arrow keys
////        scene.setOnKeyPressed(event -> {
////            double rotateSpeed = 10.0; // You can adjust the rotation speed as needed
////            switch (event.getCode()) {
////                case UP:
////                    chair.rotateChairNode(rotateSpeed, 0, 0);
////                    break;
////                case DOWN:
////                    chair.rotateChairNode(-rotateSpeed, 0, 0);
////                    break;
////                case LEFT:
////                    chair.rotateChairNode(0, rotateSpeed, 0);
////                    break;
////                case RIGHT:
////                    chair.rotateChairNode(0, -rotateSpeed, 0);
////                    break;
////            }
////        });
//
//        scene.setOnKeyPressed(event -> {
//            double rotateSpeed = 5.0; // You can adjust the rotation speed as needed
//            switch (event.getCode()) {
//                case UP:
//                    chair.rotateChairNode(rotateSpeed, 0, 0);
//                    break;
//                case DOWN:
//                    chair.rotateChairNode(-rotateSpeed, 0, 0);
//                    break;
//                case LEFT:
//                    chair.rotateChairNode(0, 0, rotateSpeed);
//                    break;
//                case RIGHT:
//                    chair.rotateChairNode(0, 0, -rotateSpeed);
//                    break;
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
//
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
//
//public class ChairRoom extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private Group roomGroup;
//    private ChairNode chair;
//    private double mouseX, mouseY;
//    private boolean isDragging = false;
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
//        // Create a layout pane for 2D content overlay
//        StackPane overlayPane = new StackPane();
//        overlayPane.setPrefSize(WIDTH, HEIGHT);
//
//        // Create a button and add it to the overlay pane
//        Button button = new Button("Button");
//        button.setStyle("-fx-background-color: #CCCCCC;"); // Set button background color
//        button.setTranslateX(10); // Adjust button position
//        button.setTranslateY(10);
//        overlayPane.getChildren().add(button);
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
//
//        overlayPane.setTranslateZ(-1000);
//
//        // Drag and drop the chair using the mouse
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
//        // Set up keyboard event handlers
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) {
////                chair.rotateY(-10); // Rotate left
//                chair.rotateChairNode(0,-10,0);
//            } else if (event.getCode() == KeyCode.RIGHT) {
////                chair.rotateY(10); // Rotate right
//                chair.rotateChairNode(0,10,0);
//            }
//        });
//
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
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
//
//public class ChairRoom extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//        private double mouseX, mouseY;
//    private boolean isDragging = false;
//
//    private Group roomGroup;
//    private ChairNode chair;
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
////        scene.setOnKeyPressed(event -> {
////            if (event.getCode() == KeyCode.LEFT) {
////                chair.rotateChairNode(0, -10, 0); // Rotate left
////            } else if (event.getCode() == KeyCode.RIGHT) {
////                chair.rotateChairNode(0, 10, 0); // Rotate right
////            }
////        });
//
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) {
//                chair.rotateChairNode(0, -10, 0); // Rotate left
//            } else if (event.getCode() == KeyCode.RIGHT) {
//                chair.rotateChairNode(0, 10, 0); // Rotate right
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
import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;

public class ChairRoom extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double ROOM_WIDTH = 600;
    private static final double ROOM_HEIGHT = 300;
    private static final double ROOM_DEPTH = 600;

    private double mouseX, mouseY;
    private boolean isDragging = false;

    private Group roomGroup;
    private ChairNode chair;


    private static final double ZOOM_SPEED = 50;
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

        // Create a layout pane for 2D content overlay
        StackPane overlayPane = new StackPane();
        overlayPane.setPrefSize(WIDTH, HEIGHT);

        // Create the scene with the roomGroup and overlayPane
        Scene scene = new Scene(new Group(roomGroup, overlayPane), WIDTH, HEIGHT, true);
        scene.setFill(Color.WHITE);

        // Set up the camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
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
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() - 10); // Rotate room left
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() + 10);
            } else if (event.getCode() == KeyCode.D) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() + 10); // Rotate room right
                roomGroup.setRotationAxis(Rotate.Y_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() - 10);
            } else if (event.getCode() == KeyCode.W) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() - 10); // Rotate room left
                roomGroup.setRotationAxis(Rotate.X_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() + 10);
            } else if (event.getCode() == KeyCode.S) {
//                roomGroup.setRotationAxis(javafx.geometry.Point3D.ZERO);
//                roomGroup.setRotate(roomGroup.getRotate() + 10); // Rotate room right
                roomGroup.setRotationAxis(Rotate.X_AXIS);
                roomGroup.setRotate(roomGroup.getRotate() - 10);
            }
            else if (event.getCode() == KeyCode.UP) {
                chair.adjustTranslation(0, 0, -10); // Move chair forward
            } else if (event.getCode() == KeyCode.DOWN) {
                chair.adjustTranslation(0, 0, 10); // Move chair backward
            }else if (event.getCode() == KeyCode.G) {
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
