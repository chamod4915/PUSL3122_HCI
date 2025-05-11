//package org.furniwise.pusl3122_hci_project.Controllers.Common;
////
////import javafx.application.Application;
////import javafx.geometry.Insets;
////import javafx.scene.Group;
////import javafx.scene.PerspectiveCamera;
////import javafx.scene.Scene;
////import javafx.scene.control.CheckBox;
////import javafx.scene.layout.HBox;
////import javafx.scene.layout.StackPane;
////import javafx.scene.paint.Color;
////import javafx.scene.paint.PhongMaterial;
////import javafx.scene.shape.Box;
////import javafx.stage.Stage;
////import org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects.ChairNode;
////
////public class FurnitureRoom extends Application {
////
////    private static final double WIDTH = 800;
////    private static final double HEIGHT = 600;
////    private static final double ROOM_WIDTH = 600;
////    private static final double ROOM_HEIGHT = 300;
////    private static final double ROOM_DEPTH = 600;
////
////    private Group roomGroup;
////    private ChairNode chair;
//////    private BedNode bed;
//////    private TableNode table;
////
////    private CheckBox chairCheckBox;
////    private CheckBox bedCheckBox;
////    private CheckBox tableCheckBox;
////
////    @Override
////    public void start(Stage primaryStage) {
////        // Create a material for the walls and floor
////        PhongMaterial wallMaterial = new PhongMaterial();
////        wallMaterial.setDiffuseColor(Color.LIGHTGRAY);
////        PhongMaterial floorMaterial = new PhongMaterial();
////        floorMaterial.setDiffuseColor(Color.GRAY);
////
////        // Create the floor
////        Box floor = new Box(ROOM_WIDTH, 1, ROOM_DEPTH);
////        floor.setMaterial(floorMaterial);
////        floor.setTranslateY(ROOM_HEIGHT / 2 - 60);
////        floor.setTranslateZ(-ROOM_DEPTH / 2 + 300);
////        floor.setTranslateX(-ROOM_WIDTH / 2 + 300);
////        floor.setTranslateY(ROOM_HEIGHT / 2 - 150);
////
////        // Create walls
////        Box wallBack = new Box(ROOM_WIDTH, ROOM_HEIGHT, 1);
////        wallBack.setMaterial(wallMaterial);
////        wallBack.setTranslateY(-ROOM_HEIGHT / 2);
////        wallBack.setTranslateZ(+300);
////
////        Box wallLeft = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
////        wallLeft.setMaterial(wallMaterial);
////        wallLeft.setTranslateX(-ROOM_WIDTH / 2);
////        wallLeft.setTranslateY(-ROOM_HEIGHT / 2);
////
////        Box wallRight = new Box(1, ROOM_HEIGHT, ROOM_DEPTH);
////        wallRight.setMaterial(wallMaterial);
////        wallRight.setTranslateX(ROOM_WIDTH / 2);
////        wallRight.setTranslateY(-ROOM_HEIGHT / 2);
////
////        // Create a group to hold all parts of the room
////        roomGroup = new Group(floor, wallBack, wallLeft, wallRight);
////
////        // Center the room
////        roomGroup.setTranslateX((WIDTH - ROOM_WIDTH) / 2 - 200);
////        roomGroup.setTranslateY((HEIGHT - ROOM_HEIGHT) / 2 - 150);
////
////        // Create furniture objects
////        chair = new ChairNode();
//////        bed = new BedNode();
//////        table = new TableNode();
////
////        // Create checkboxes for furniture selection
////        chairCheckBox = new CheckBox("Chair");
////        bedCheckBox = new CheckBox("Bed");
////        tableCheckBox = new CheckBox("Table");
////
////        // Set up checkbox event handlers
////        chairCheckBox.setOnAction(event -> toggleObjectActivation(chairCheckBox.isSelected(), chair));
//////        bedCheckBox.setOnAction(event -> toggleObjectActivation(bedCheckBox.isSelected(), bed));
//////        tableCheckBox.setOnAction(event -> toggleObjectActivation(tableCheckBox.isSelected(), table));
////
////        // Create a layout pane for 2D content overlay
////        StackPane overlayPane = new StackPane();
////        overlayPane.setPrefSize(WIDTH, HEIGHT);
////
////        // Create the scene with the roomGroup and overlayPane
////        Scene scene = new Scene(new Group(roomGroup, overlayPane), WIDTH, HEIGHT, true);
////        scene.setFill(Color.WHITE);
////
////        // Set up the camera
////        PerspectiveCamera camera = new PerspectiveCamera(true);
////        camera.setTranslateX(-150);
////        camera.setTranslateY(-150);
////        camera.setTranslateZ(-1000);
////        camera.setNearClip(0.1);
////        camera.setFarClip(10000.0);
////        scene.setCamera(camera);
////
////        // Add checkboxes to toggle furniture selection
////        HBox checkBoxes = new HBox(10, chairCheckBox, bedCheckBox, tableCheckBox);
////        checkBoxes.setPadding(new Insets(10));
////        overlayPane.getChildren().add(checkBoxes);
////
////        // Show the stage
////        primaryStage.setTitle("JavaFX Furniture Room");
////        primaryStage.setScene(scene);
////        primaryStage.show();
////    }
////    public abstract class FurnitureNode extends Group {
////        public abstract void activate();
////        public abstract void deactivate();
////    }
////    private void toggleObjectActivation(boolean isSelected, FurnitureNode object) {
////        if (isSelected) {
////            object.activate();
////        } else {
////            object.deactivate();
////        }
////    }
////
////    public static void main(String[] args) {
////        launch(args);
////    }
////}
//
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.control.CheckBox;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.stage.Stage;
//
//public class FurnitureRoom extends Application {
//
//    private static final double WIDTH = 800;
//    private static final double HEIGHT = 600;
//    private static final double ROOM_WIDTH = 600;
//    private static final double ROOM_HEIGHT = 300;
//    private static final double ROOM_DEPTH = 600;
//
//    private Group roomGroup;
//    private FurnitureNode chair;
//    private FurnitureNode bed;
//    private FurnitureNode table;
//
//    private CheckBox chairCheckBox;
//    private CheckBox bedCheckBox;
//    private CheckBox tableCheckBox;
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
//        // Create furniture objects
//        chair = new ChairNode();
////        bed = new BedNode();
////        table = new TableNode();
//
//        // Create checkboxes for furniture selection
//        chairCheckBox = new CheckBox("Chair");
//        bedCheckBox = new CheckBox("Bed");
//        tableCheckBox = new CheckBox("Table");
//
//        // Set up checkbox event handlers
//        chairCheckBox.setOnAction(event -> toggleObjectActivation(chairCheckBox.isSelected(), chair));
////        bedCheckBox.setOnAction(event -> toggleObjectActivation(bedCheckBox.isSelected(), bed));
////        tableCheckBox.setOnAction(event -> toggleObjectActivation(tableCheckBox.isSelected(), table));
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
//        // Add checkboxes to toggle furniture selection
//        HBox checkBoxes = new HBox(10, chairCheckBox, bedCheckBox, tableCheckBox);
//        checkBoxes.setPadding(new Insets(10));
//        overlayPane.getChildren().add(checkBoxes);
//
//        // Show the stage
//        primaryStage.setTitle("JavaFX Furniture Room");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private void toggleObjectActivation(boolean isSelected, FurnitureNode object) {
//        if (isSelected) {
//            object.activate();
//        } else {
//            object.deactivate();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
//
//abstract class FurnitureNode extends Group {
//    public abstract void activate();
//    public abstract void deactivate();
//}
//
//class ChairNode extends FurnitureNode {
//    public ChairNode() {
//        Box seat = new Box(70, 5, 70);
//        seat.setMaterial(new PhongMaterial(Color.BROWN));
//
//        Box leg1 = new Box(10, 50, 10);
//        leg1.setMaterial(new PhongMaterial(Color.BROWN));
//        leg1.setTranslateX(30);
//        leg1.setTranslateZ(30);
//
//        Box leg2 = new Box(10, 50, 10);
//        leg2.setMaterial(new PhongMaterial(Color.BROWN));
//        leg2.setTranslateX(-30);
//        leg2.setTranslateZ(30);
//
//        Box leg3 = new Box(10, 50, 10);
//        leg3.setMaterial(new PhongMaterial(Color.BROWN));
//        leg3.setTranslateX(30);
//        leg3.setTranslateZ(-30);
//
//        Box leg4 = new Box(10, 50, 10);
//        leg4.setMaterial(new PhongMaterial(Color.BROWN));
//        leg4.setTranslateX(-30);
//        leg4.setTranslateZ(-30);
//
//        Box backrest = new Box(5, 80, 70);
//        backrest.setMaterial(new PhongMaterial(Color.BROWN));
//        backrest.setTranslateY(-35);
//
//        getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest);
//    }
//
//    @Override
//    public void activate() {
//
//    }
//
//    @Override
//    public void deactivate() {
//
//    }
//}
////
//public class TableNode extends FurnitureNode {
//    // TableNode implementation here
//    @Override
//    public void activate() {
//        // Activate table node
//    }
//
//    @Override
//    public void deactivate() {
//        // Deactivate table node
//    }
//}
