package org.furniwise.pusl3122_hci_project.Controllers.Common;//package org.furniwise.pusl3122_hci_project.Controllers.Common;
//
//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.AmbientLight;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.stage.Stage;
//
//public class Cupboard3D extends Application {
//
//    private static final float WIDTH = 1400;
//    private static final float HEIGHT = 1000;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Constructing the main cupboard structure using boxes and cuboids
//        Box cupboardBody = prepareCupboardBody();
//        Box cupboardDoor = prepareCupboardDoor();
//        Cylinder handle = prepareHandle();
//
//        // Grouping the components together
//        Group group = new Group(cupboardBody, cupboardDoor, handle, new AmbientLight());
//
//        // Setting up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-400);
//
//        // Setting up the scene
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        // Initializing mouse and keyboard controls
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Cupboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Method to prepare the main cupboard body using boxes and cuboids
//    private Box prepareCupboardBody() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardBody = new Box(200, 300, 50);
//        cupboardBody.setMaterial(material);
//        return cupboardBody;
//    }
//
//    // Method to prepare the cupboard door using a box
//    private Box prepareCupboardDoor() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardDoor = new Box(100, 300, 50);
//        cupboardDoor.setMaterial(material);
//        cupboardDoor.setTranslateX(150); // Position the door next to the cupboard body
//        return cupboardDoor;
//    }
//
//    // Method to prepare the handle using a cylinder
//    private Cylinder prepareHandle() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BLACK);
//        Cylinder handle = new Cylinder(5, 40);
//        handle.setMaterial(material);
//        handle.setTranslateX(250); // Position the handle on the door
//        return handle;
//    }
//
//    // Method to initialize mouse and keyboard controls
//    private void initMouseControl(Group group, Scene scene, Stage stage) {
//        Rotate xRotate;
//        Rotate yRotate;
//        group.getTransforms().addAll(
//                xRotate = new Rotate(0, Rotate.X_AXIS),
//                yRotate = new Rotate(0, Rotate.Y_AXIS)
//        );
//        xRotate.angleProperty().bind(angleX);
//        yRotate.angleProperty().bind(angleY);
//
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = angleX.get();
//            anchorAngleY = angleY.get();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//
//        // Handling keyboard input for movement and rotation
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            switch (event.getCode()) {
//                case W:
//                    group.translateZProperty().set(group.getTranslateZ() + 100);
//                    break;
//                case S:
//                    group.translateZProperty().set(group.getTranslateZ() - 100);
//                    break;
//                case Q:
//                    group.rotateByX(10);
//                    break;
//                case E:
//                    group.rotateByX(-10);
//                    break;
//                case NUMPAD6:
//                    group.rotateByY(10);
//                    break;
//                case NUMPAD4:
//                    group.rotateByY(-10);
//                    break;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom group class for rotation
//    class SmartGroup extends Group {
//
//        Rotate r;
//        Transform t = new Rotate();
//
//        void rotateByX(int ang) {
//            r = new Rotate(ang, Rotate.X_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//
//        void rotateByY(int ang) {
//            r = new Rotate(ang, Rotate.Y_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//    }
//}
//
//
//package org.furniwise.pusl3122_hci_project.Controllers.Common;
//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Cupboard3D extends Application {
//
//    private static final float WIDTH = 1400;
//    private static final float HEIGHT = 1000;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Constructing the main cupboard structure using boxes and cuboids
//        Box cupboardBody = prepareCupboardBody();
//        Box cupboardDoor = prepareCupboardDoor();
//        Cylinder handle = prepareHandle();
//
//        // Grouping the components together using SmartGroup
//        SmartGroup group = new SmartGroup(cupboardBody, cupboardDoor, handle, new AmbientLight());
//
//        // Setting up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-800);
//
//        // Setting up the scene
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        // Initializing mouse and keyboard controls
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Cupboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Method to prepare the main cupboard body using boxes and cuboids
//    private Box prepareCupboardBody() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardBody = new Box(200, 300, 50);
//        cupboardBody.setMaterial(material);
//        return cupboardBody;
//    }
//
//    // Method to prepare the cupboard door using a box
//    private Box prepareCupboardDoor() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardDoor = new Box(100, 300, 50);
//        cupboardDoor.setMaterial(material);
//        cupboardDoor.setTranslateX(150); // Position the door next to the cupboard body
//        return cupboardDoor;
//    }
//
//    // Method to prepare the handle using a cylinder
//    private Cylinder prepareHandle() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BLACK);
//        Cylinder handle = new Cylinder(5, 40);
//        handle.setMaterial(material);
//        handle.setTranslateX(250); // Position the handle on the door
//        return handle;
//    }
//
//    // Method to initialize mouse and keyboard controls
//    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
//        Rotate xRotate;
//        Rotate yRotate;
//        group.getTransforms().addAll(
//                xRotate = new Rotate(0, Rotate.X_AXIS),
//                yRotate = new Rotate(0, Rotate.Y_AXIS)
//        );
//        xRotate.angleProperty().bind(angleX);
//        yRotate.angleProperty().bind(angleY);
//
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = angleX.get();
//            anchorAngleY = angleY.get();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//
//        // Handling keyboard input for movement and rotation
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            switch (event.getCode()) {
//                case W:
//                    group.translateZProperty().set(group.getTranslateZ() + 100);
//                    break;
//                case S:
//                    group.translateZProperty().set(group.getTranslateZ() - 100);
//                    break;
//                case Q:
//                    group.rotateByX(10);
//                    break;
//                case E:
//                    group.rotateByX(-10);
//                    break;
//                case NUMPAD6:
//                    group.rotateByY(10);
//                    break;
//                case NUMPAD4:
//                    group.rotateByY(-10);
//                    break;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom SmartGroup class for rotation
//    class SmartGroup extends Group {
//
//        Rotate r;
//        Transform t = new Rotate();
//
//        SmartGroup(Node... nodes) {
//            super(nodes);
//        }
//
//        void rotateByX(int ang) {
//            r = new Rotate(ang, Rotate.X_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//
//        void rotateByY(int ang) {
//            r = new Rotate(ang, Rotate.Y_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//    }
//}
//
//
//package org.furniwise.pusl3122_hci_project.Controllers.Common;
//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Cupboard3D extends Application {
//
//    private static final float WIDTH = 760;
//    private static final float HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    // Constants for cupboard dimensions
//    private static final double CUPBOARD_HEIGHT = 300;
//    private static final double CUPBOARD_WIDTH = 200;
//    private static final double CUPBOARD_DEPTH = 50;
//    private static final double DOOR_WIDTH = 100;
//    private static final double SHELF_THICKNESS = 5;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Constructing the main cupboard structure using boxes and cuboids
//        Box cupboardBody = prepareCupboardBody();
//        Box cupboardDoor = prepareCupboardDoor();
//        Cylinder handle = prepareHandle();
//
//        // Add shelves inside the cupboard
//        Box shelf1 = prepareShelf();
//        shelf1.setTranslateY(-100);
//        Box shelf2 = prepareShelf();
//        shelf2.setTranslateY(0);
//        Box shelf3 = prepareShelf();
//        shelf3.setTranslateY(100);
//
//        // Adjust door to appear as open
//        cupboardDoor.setRotationAxis(Rotate.Y_AXIS);
//        cupboardDoor.setRotate(30); // Door opened by 30 degrees for illustration
//
//        // Position the handle correctly according to the open door
//        handle.setRotationAxis(Rotate.Y_AXIS);
//        handle.setRotate(30); // Rotate the handle same as the door
//        handle.setTranslateX(cupboardDoor.getTranslateX() + DOOR_WIDTH / 2);
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//
//        // Grouping the components together using SmartGroup
//        SmartGroup group = new SmartGroup(cupboardBody, cupboardDoor, handle, shelf1, shelf2, shelf3, new AmbientLight());
//
//        // Setting up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-800);
//
//        // Setting up the scene
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        // Initializing mouse and keyboard controls
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Cupboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Method to prepare the main cupboard body using boxes and cuboids
//    private Box prepareCupboardBody() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardBody = new Box(CUPBOARD_WIDTH, CUPBOARD_HEIGHT, CUPBOARD_DEPTH);
//        cupboardBody.setMaterial(material);
//        return cupboardBody;
//    }
//
//    // Method to prepare the cupboard door using a box
//    private Box prepareCupboardDoor() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardDoor = new Box(DOOR_WIDTH, CUPBOARD_HEIGHT, CUPBOARD_DEPTH);
//        cupboardDoor.setMaterial(material);
//        cupboardDoor.setTranslateX(CUPBOARD_WIDTH / 2); // Position the door next to the cupboard body
//        return cupboardDoor;
//    }
//
//    // Method to prepare the handle using a cylinder
//    private Cylinder prepareHandle() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BLACK);
//        Cylinder handle = new Cylinder(5, 40);
//        handle.setMaterial(material);
//        handle.setTranslateX(CUPBOARD_WIDTH / 2 + DOOR_WIDTH / 2); // Position the handle on the door
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//        return handle;
//    }
//
//    // Method to prepare the shelf using a box
//    private Box prepareShelf() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box shelf = new Box(CUPBOARD_WIDTH, SHELF_THICKNESS, CUPBOARD_DEPTH);
//        shelf.setMaterial(material);
//        return shelf;
//    }
//
//    // Method to initialize mouse and keyboard controls
//    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
//        Rotate xRotate;
//        Rotate yRotate;
//        group.getTransforms().addAll(
//                xRotate = new Rotate(0, Rotate.X_AXIS),
//                yRotate = new Rotate(0, Rotate.Y_AXIS)
//        );
//        xRotate.angleProperty().bind(angleX);
//        yRotate.angleProperty().bind(angleY);
//
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = angleX.get();
//            anchorAngleY = angleY.get();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//
//        // Handling keyboard input for movement and rotation
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            switch (event.getCode()) {
//                case W:
//                    group.translateZProperty().set(group.getTranslateZ() + 100);
//                    break;
//                case S:
//                    group.translateZProperty().set(group.getTranslateZ() - 100);
//                    break;
//                case Q:
//                    group.rotateByX(10);
//                    break;
//                case E:
//                    group.rotateByX(-10);
//                    break;
//                case NUMPAD6:
//                    group.rotateByY(10);
//                    break;
//                case NUMPAD4:
//                    group.rotateByY(-10);
//                    break;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom SmartGroup class for rotation
//    class SmartGroup extends Group {
//
//        Rotate r;
//        Transform t = new Rotate();
//
//        SmartGroup(Node... nodes) {
//            super(nodes);
//        }
//
//        void rotateByX(int ang) {
//            r = new Rotate(ang, Rotate.X_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//
//        void rotateByY(int ang) {
//            r = new Rotate(ang, Rotate.Y_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//    }
//}
//
//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Cupboard3D extends Application {
//
//    private static final float WIDTH = 760;
//    private static final float HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    // Constants for cupboard dimensions
//    private static final double CUPBOARD_HEIGHT = 300;
//    private static final double CUPBOARD_WIDTH = 200;
//    private static final double CUPBOARD_DEPTH = 50;
//    private static final double DOOR_WIDTH = 100;
//    private static final double DOOR_THICKNESS = 2; // Thin door
//    private static final double SHELF_THICKNESS = 2; // Thin shelves
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Constructing the main cupboard structure using thin rectangles
//        Box cupboardBody = prepareCupboardBody();
//        Box cupboardDoor = prepareCupboardDoor();
//        Cylinder handle = prepareHandle();
//
//        // Add thin shelves inside the cupboard
//        Box shelf1 = prepareShelf();
//        shelf1.setTranslateY(-100);
//        Box shelf2 = prepareShelf();
//        shelf2.setTranslateY(0);
//        Box shelf3 = prepareShelf();
//        shelf3.setTranslateY(100);
//
//        // Adjust door to appear as open
//        cupboardDoor.setRotationAxis(Rotate.Y_AXIS);
//        cupboardDoor.setRotate(30); // Door opened by 30 degrees for illustration
//
//        // Position the handle correctly according to the open door
//        handle.setRotationAxis(Rotate.Y_AXIS);
//        handle.setRotate(30); // Rotate the handle same as the door
//        handle.setTranslateX(cupboardDoor.getTranslateX() + DOOR_WIDTH / 2);
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//
//        // Grouping the components together using SmartGroup
//        SmartGroup group = new SmartGroup(cupboardBody, cupboardDoor, handle, shelf1, shelf2, shelf3, new AmbientLight());
//
//        // Setting up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-800);
//
//        // Setting up the scene
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        // Initializing mouse and keyboard controls
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Cupboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Method to prepare the main cupboard body using thin rectangles
//    private Box prepareCupboardBody() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardBody = new Box(CUPBOARD_WIDTH, CUPBOARD_HEIGHT, CUPBOARD_DEPTH);
//        cupboardBody.setMaterial(material);
//        return cupboardBody;
//    }
//
//    // Method to prepare the cupboard door using a thin rectangle
//    private Box prepareCupboardDoor() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardDoor = new Box(DOOR_WIDTH, CUPBOARD_HEIGHT, DOOR_THICKNESS); // Thin door
//        cupboardDoor.setMaterial(material);
//        cupboardDoor.setTranslateX(CUPBOARD_WIDTH / 2); // Position the door next to the cupboard body
//        return cupboardDoor;
//    }
//
//    // Method to prepare the handle using a cylinder
//    private Cylinder prepareHandle() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BLACK);
//        Cylinder handle = new Cylinder(2, 20); // Adjust handle size
//        handle.setMaterial(material);
//        handle.setTranslateX(CUPBOARD_WIDTH / 2 + DOOR_WIDTH / 2); // Position the handle on the door
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//        return handle;
//    }
//
//    // Method to prepare the shelf using a thin rectangle
//    private Box prepareShelf() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box shelf = new Box(CUPBOARD_WIDTH, SHELF_THICKNESS, CUPBOARD_DEPTH); // Thin shelf
//        shelf.setMaterial(material);
//        return shelf;
//    }
//
//    // Method to initialize mouse and keyboard controls
//    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
//        Rotate xRotate;
//        Rotate yRotate;
//        group.getTransforms().addAll(
//                xRotate = new Rotate(0, Rotate.X_AXIS),
//                yRotate = new Rotate(0, Rotate.Y_AXIS)
//        );
//        xRotate.angleProperty().bind(angleX);
//        yRotate.angleProperty().bind(angleY);
//
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = angleX.get();
//            anchorAngleY = angleY.get();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//
//        // Handling keyboard input for movement and rotation
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            switch (event.getCode()) {
//                case W:
//                    group.translateZProperty().set(group.getTranslateZ() + 100);
//                    break;
//                case S:
//                    group.translateZProperty().set(group.getTranslateZ() - 100);
//                    break;
//                case Q:
//                    group.rotateByX(10);
//                    break;
//                case E:
//                    group.rotateByX(-10);
//                    break;
//                case NUMPAD6:
//                    group.rotateByY(10);
//                    break;
//                case NUMPAD4:
//                    group.rotateByY(-10);
//                    break;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom SmartGroup class for rotation
//    class SmartGroup extends Group {
//
//        Rotate r;
//        Transform t = new Rotate();
//
//        SmartGroup(Node... nodes) {
//            super(nodes);
//        }
//
//        void rotateByX(int ang) {
//            r = new Rotate(ang, Rotate.X_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//
//        void rotateByY(int ang) {
//            r = new Rotate(ang, Rotate.Y_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//    }
//}

//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Cupboard3D extends Application {
//
//    private static final float WIDTH = 760;
//    private static final float HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    // Constants for cupboard dimensions
//    private static final double CUPBOARD_HEIGHT = 300;
//    private static final double CUPBOARD_WIDTH = 200;
//    private static final double CUPBOARD_DEPTH = 50;
//    private static final double DOOR_WIDTH = 100;
//    private static final double DOOR_THICKNESS = 2; // Thin door
//    private static final double SHELF_THICKNESS = 2; // Thin shelves
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Constructing the main cupboard structure using thin rectangles
//        Box cupboardBody = prepareCupboardBody();
//        Box cupboardDoor = prepareCupboardDoor();
//        Cylinder handle = prepareHandle();
//
//        // Add thin shelves inside the cupboard
//        Box shelf1 = prepareShelf();
//        shelf1.setTranslateY(-100);
//        Box shelf2 = prepareShelf();
//        shelf2.setTranslateY(0);
//        Box shelf3 = prepareShelf();
//        shelf3.setTranslateY(100);
//
//        // Adjust door to appear as open
////        cupboardDoor.setRotationAxis(Rotate.Y_AXIS);
////        cupboardDoor.setRotate(30); // Door opened by 30 degrees for illustration
//
//        // Position the handle correctly according to the open door
//        handle.setRotationAxis(Rotate.Y_AXIS);
//        handle.setRotate(30); // Rotate the handle same as the door
//        handle.setTranslateX(cupboardDoor.getTranslateX() + DOOR_WIDTH / 2);
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//
//        // Grouping the components together using SmartGroup
//        SmartGroup group = new SmartGroup(cupboardBody, cupboardDoor, handle, shelf1, shelf2, shelf3, new AmbientLight());
//
//        // Setting up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-800);
//
//        // Setting up the scene
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        // Initializing mouse and keyboard controls
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Cupboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Method to prepare the main cupboard body using thin rectangles
//    private Box prepareCupboardBody() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        // Creating four thin rectangles to form the cupboard body
//        Box side1 = new Box(CUPBOARD_DEPTH, CUPBOARD_HEIGHT, DOOR_WIDTH / 2);
//        side1.setMaterial(material);
//        side1.setTranslateX(-CUPBOARD_WIDTH / 2 + CUPBOARD_DEPTH / 2);
//        side1.setTranslateY(0);
//        side1.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        Box side2 = new Box(CUPBOARD_DEPTH, CUPBOARD_HEIGHT, DOOR_WIDTH / 2);
//        side2.setMaterial(material);
//        side2.setTranslateX(CUPBOARD_WIDTH / 2 - CUPBOARD_DEPTH / 2);
//        side2.setTranslateY(0);
//        side2.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        Box top = new Box(CUPBOARD_WIDTH - 2 * CUPBOARD_DEPTH, CUPBOARD_DEPTH, DOOR_WIDTH / 2);
//        top.setMaterial(material);
//        top.setTranslateX(0);
//        top.setTranslateY(-CUPBOARD_HEIGHT / 2 + CUPBOARD_DEPTH / 2);
//        top.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        Box bottom = new Box(CUPBOARD_WIDTH - 2 * CUPBOARD_DEPTH, CUPBOARD_DEPTH, DOOR_WIDTH / 2);
//        bottom.setMaterial(material);
//        bottom.setTranslateX(0);
//        bottom.setTranslateY(CUPBOARD_HEIGHT / 2 - CUPBOARD_DEPTH / 2);
//        bottom.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        // Combining the four rectangles into one group
//        Group cupboardBody = new Group(side1, side2, top, bottom);
//        return new Box();
//    }
//
//    // Method to prepare the cupboard door using a thin rectangle
//    private Box prepareCupboardDoor() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardDoor = new Box(DOOR_WIDTH, CUPBOARD_HEIGHT, DOOR_THICKNESS); // Thin door
//        cupboardDoor.setMaterial(material);
//        cupboardDoor.setTranslateX(CUPBOARD_WIDTH / 2); // Position the door next to the cupboard body
//        return cupboardDoor;
//    }
//
//    // Method to prepare the handle using a cylinder
//    private Cylinder prepareHandle() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BLACK);
//        Cylinder handle = new Cylinder(2, 20); // Adjust handle size
//        handle.setMaterial(material);
//        handle.setTranslateX(CUPBOARD_WIDTH / 2 + DOOR_WIDTH / 2); // Position the handle on the door
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//        return handle;
//    }
//
//    // Method to prepare the shelf using a thin rectangle
//    private Box prepareShelf() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box shelf = new Box(CUPBOARD_WIDTH, SHELF_THICKNESS, CUPBOARD_DEPTH); // Thin shelf
//        shelf.setMaterial(material);
//        return shelf;
//    }
//
//    // Method to initialize mouse and keyboard controls
//    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
//        Rotate xRotate;
//        Rotate yRotate;
//        group.getTransforms().addAll(
//                xRotate = new Rotate(0, Rotate.X_AXIS),
//                yRotate = new Rotate(0, Rotate.Y_AXIS)
//        );
//        xRotate.angleProperty().bind(angleX);
//        yRotate.angleProperty().bind(angleY);
//
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = angleX.get();
//            anchorAngleY = angleY.get();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//
//        // Handling keyboard input for movement and rotation
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            switch (event.getCode()) {
//                case W:
//                    group.translateZProperty().set(group.getTranslateZ() + 100);
//                    break;
//                case S:
//                    group.translateZProperty().set(group.getTranslateZ() - 100);
//                    break;
//                case Q:
//                    group.rotateByX(10);
//                    break;
//                case E:
//                    group.rotateByX(-10);
//                    break;
//                case NUMPAD6:
//                    group.rotateByY(10);
//                    break;
//                case NUMPAD4:
//                    group.rotateByY(-10);
//                    break;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom SmartGroup class for rotation
//    class SmartGroup extends Group {
//
//        Rotate r;
//        Transform t = new Rotate();
//
//        SmartGroup(Node... nodes) {
//            super(nodes);
//        }
//
//        void rotateByX(int ang) {
//            r = new Rotate(ang, Rotate.X_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//
//        void rotateByY(int ang) {
//            r = new Rotate(ang, Rotate.Y_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//    }
//}

//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Cupboard3D extends Application {
//
//    private static final float WIDTH = 760;
//    private static final float HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    // Constants for cupboard dimensions
//    private static final double CUPBOARD_HEIGHT = 300;
//    private static final double CUPBOARD_WIDTH = 200;
//    private static final double CUPBOARD_DEPTH = 50;
//    private static final double DOOR_WIDTH = 100;
//    private static final double DOOR_THICKNESS = 2; // Thin door
//    private static final double SHELF_THICKNESS = 2; // Thin shelves
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Constructing the main cupboard structure using thin rectangles
//        Box cupboardBody = prepareCupboardBody();
//        Box cupboardDoor = prepareCupboardDoor();
//        Cylinder handle = prepareHandle();
//
//        // Add thin shelves inside the cupboard
//        Box shelf1 = prepareShelf();
//        shelf1.setTranslateY(-CUPBOARD_HEIGHT / 2 + SHELF_THICKNESS / 2); // Connect shelf to the back
//        Box shelf2 = prepareShelf();
//        shelf2.setTranslateY(-CUPBOARD_HEIGHT / 2 + 3 * SHELF_THICKNESS / 2); // Connect shelf to the back
//        Box shelf3 = prepareShelf();
//        shelf3.setTranslateY(-CUPBOARD_HEIGHT / 2 + 5 * SHELF_THICKNESS / 2); // Connect shelf to the back
//
//        // Adjust door to appear as open
//        cupboardDoor.setRotationAxis(Rotate.Y_AXIS);
//        cupboardDoor.setRotate(30); // Door opened by 30 degrees for illustration
//
//        // Position the handle correctly according to the open door
//        handle.setRotationAxis(Rotate.Y_AXIS);
//        handle.setRotate(30); // Rotate the handle same as the door
//        handle.setTranslateX(cupboardDoor.getTranslateX() + DOOR_WIDTH / 2);
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//
//        // Grouping the components together using SmartGroup
//        SmartGroup group = new SmartGroup(cupboardBody, cupboardDoor, handle, shelf1, shelf2, shelf3, new AmbientLight());
//
//        // Setting up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-800);
//
//        // Setting up the scene
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        // Initializing mouse and keyboard controls
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Cupboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Method to prepare the main cupboard body using thin rectangles
//    private Box prepareCupboardBody() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        // Creating four thin rectangles to form the cupboard body
//        Box side1 = new Box(CUPBOARD_DEPTH, CUPBOARD_HEIGHT, DOOR_WIDTH / 2);
//        side1.setMaterial(material);
//        side1.setTranslateX(-CUPBOARD_WIDTH / 2 + CUPBOARD_DEPTH / 2);
//        side1.setTranslateY(0);
//        side1.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        Box side2 = new Box(CUPBOARD_DEPTH, CUPBOARD_HEIGHT, DOOR_WIDTH / 2);
//        side2.setMaterial(material);
//        side2.setTranslateX(CUPBOARD_WIDTH / 2 - CUPBOARD_DEPTH / 2);
//        side2.setTranslateY(0);
//        side2.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        Box top = new Box(CUPBOARD_WIDTH - 2 * CUPBOARD_DEPTH, CUPBOARD_DEPTH, DOOR_WIDTH / 2);
//        top.setMaterial(material);
//        top.setTranslateX(0);
//        top.setTranslateY(-CUPBOARD_HEIGHT / 2 + CUPBOARD_DEPTH / 2);
//        top.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        Box bottom = new Box(CUPBOARD_WIDTH - 2 * CUPBOARD_DEPTH, CUPBOARD_DEPTH, DOOR_WIDTH / 2);
//        bottom.setMaterial(material);
//        bottom.setTranslateX(0);
//        bottom.setTranslateY(CUPBOARD_HEIGHT / 2 - CUPBOARD_DEPTH / 2);
//        bottom.setTranslateZ(-CUPBOARD_DEPTH / 2);
//
//        // Combining the four rectangles into one group
//        Group cupboardBody = new Group(side1, side2, top, bottom);
//        return new Box();
//    }
//
//    // Method to prepare the cupboard door using a thin rectangle
//    private Box prepareCupboardDoor() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardDoor = new Box(DOOR_WIDTH, CUPBOARD_HEIGHT, DOOR_THICKNESS); // Thin door
//        cupboardDoor.setMaterial(material);
//        cupboardDoor.setTranslateX(CUPBOARD_WIDTH / 2); // Position the door next to the cupboard body
//        return cupboardDoor;
//    }
//
//    // Method to prepare the handle using a cylinder
//    private Cylinder prepareHandle() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BLACK);
//        Cylinder handle = new Cylinder(2, 20); // Adjust handle size
//        handle.setMaterial(material);
//        handle.setTranslateX(CUPBOARD_WIDTH / 2 + DOOR_WIDTH / 2); // Position the handle on the door
//        handle.setTranslateY(0);
//        handle.setTranslateZ(-CUPBOARD_DEPTH / 2); // Position handle on the edge of the door
//        return handle;
//    }
//
//    // Method to prepare the shelf using a thin rectangle
//    private Box prepareShelf() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box shelf = new Box(CUPBOARD_WIDTH - 2 * CUPBOARD_DEPTH, SHELF_THICKNESS, CUPBOARD_DEPTH); // Thin shelf
//        shelf.setMaterial(material);
//        return shelf;
//    }
//
//    // Method to initialize mouse and keyboard controls
//    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
//        Rotate xRotate;
//        Rotate yRotate;
//        group.getTransforms().addAll(
//                xRotate = new Rotate(0, Rotate.X_AXIS),
//                yRotate = new Rotate(0, Rotate.Y_AXIS)
//        );
//        xRotate.angleProperty().bind(angleX);
//        yRotate.angleProperty().bind(angleY);
//
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = angleX.get();
//            anchorAngleY = angleY.get();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//
//        // Handling keyboard input for movement and rotation
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            switch (event.getCode()) {
//                case W:
//                    group.translateZProperty().set(group.getTranslateZ() + 100);
//                    break;
//                case S:
//                    group.translateZProperty().set(group.getTranslateZ() - 100);
//                    break;
//                case Q:
//                    group.rotateByX(10);
//                    break;
//                case E:
//                    group.rotateByX(-10);
//                    break;
//                case NUMPAD6:
//                    group.rotateByY(10);
//                    break;
//                case NUMPAD4:
//                    group.rotateByY(-10);
//                    break;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom SmartGroup class for rotation
//    class SmartGroup extends Group {
//
//        Rotate r;
//        Transform t = new Rotate();
//
//        SmartGroup(Node... nodes) {
//            super(nodes);
//        }
//
//        void rotateByX(int ang) {
//            r = new Rotate(ang, Rotate.X_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//
//        void rotateByY(int ang) {
//            r = new Rotate(ang, Rotate.Y_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//    }
//}
//
//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.shape.Line;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Cupboard3D extends Application {
//
//    private static final float WIDTH = 760;
//    private static final float HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    // Constants for cupboard dimensions
//    private static final double CUPBOARD_HEIGHT = 300;
//    private static final double CUPBOARD_WIDTH = 200;
//    private static final double CUPBOARD_DEPTH = 50;
//    private static final double DOOR_WIDTH = 100;
//    private static final int DOOR_THICKNESS = 2; // Thin door
//    private static final double SHELF_THICKNESS = 2; // Thin shelves
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Constructing the main cupboard structure using thin rectangles
//        Box cupboardBody = prepareCupboardBody();
//        Cylinder dividingLine = prepareDividingLine();
//        Cylinder leftDoor = prepareDoor();
//        Cylinder rightDoor = prepareDoor();
//        Cylinder leftHandle = prepareHandle();
//        Cylinder rightHandle = prepareHandle();
//
//        // Add thin shelves inside the cupboard
//        Box shelf1 = prepareShelf();
//        shelf1.setTranslateY(-100);
//        Box shelf2 = prepareShelf();
//        shelf2.setTranslateY(0);
//        Box shelf3 = prepareShelf();
//        shelf3.setTranslateY(100);
//
//        // Position the doors and handles
//        double doorTranslateX = DOOR_WIDTH / 2 + DOOR_THICKNESS / 2;
//        leftDoor.setTranslateX(-CUPBOARD_WIDTH / 4 + doorTranslateX);
//        rightDoor.setTranslateX(CUPBOARD_WIDTH / 4 - doorTranslateX);
//        leftHandle.setTranslateX(leftDoor.getTranslateX());
//        rightHandle.setTranslateX(rightDoor.getTranslateX());
//
//        // Grouping the components together using SmartGroup
//        SmartGroup group = new SmartGroup(
//                cupboardBody, dividingLine, leftDoor, rightDoor, leftHandle, rightHandle,
//                shelf1, shelf2, shelf3, new AmbientLight()
//        );
//
//        // Setting up the camera
//        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-800);
//
//        // Setting up the scene
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        // Initializing mouse and keyboard controls
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Cupboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Method to prepare the main cupboard body using thin rectangles
//    private Box prepareCupboardBody() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box cupboardBody = new Box(CUPBOARD_WIDTH, CUPBOARD_HEIGHT, CUPBOARD_DEPTH);
//        cupboardBody.setMaterial(material);
//        return cupboardBody;
//    }
//
//    // Method to prepare the dividing line between the doors
//    private Cylinder prepareDividingLine() {
//        Cylinder line = new Cylinder(1, CUPBOARD_HEIGHT, 1);
//        line.setMaterial(new PhongMaterial(Color.BLACK));
//        return line;
//    }
//
//    // Method to prepare a door using a thin rectangle
//    private Cylinder prepareDoor() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Cylinder door = new Cylinder(DOOR_WIDTH / 2, CUPBOARD_HEIGHT, DOOR_THICKNESS); // Thin door
//        door.setMaterial(material);
//        return door;
//    }
//
//    // Method to prepare the handle using a cylinder
//    private Cylinder prepareHandle() {
//        Cylinder handle = new Cylinder(2, 20); // Adjust handle size
//        handle.setMaterial(new PhongMaterial(Color.BLACK));
//        return handle;
//    }
//
//    // Method to prepare the shelf using a thin rectangle
//    private Box prepareShelf() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box shelf = new Box(CUPBOARD_WIDTH, SHELF_THICKNESS, CUPBOARD_DEPTH); // Thin shelf
//        shelf.setMaterial(material);
//        return shelf;
//    }
//
//    // Method to initialize mouse and keyboard controls
//    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
//        Rotate xRotate;
//        Rotate yRotate;
//        group.getTransforms().addAll(
//                xRotate = new Rotate(0, Rotate.X_AXIS),
//                yRotate = new Rotate(0, Rotate.Y_AXIS)
//        );
//        xRotate.angleProperty().bind(angleX);
//        yRotate.angleProperty().bind(angleY);
//
//        scene.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            anchorAngleX = angleX.get();
//            anchorAngleY = angleY.get();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//
//        // Handling keyboard input for movement and rotation
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            switch (event.getCode()) {
//                case W:
//                    group.translateZProperty().set(group.getTranslateZ() + 100);
//                    break;
//                case S:
//                    group.translateZProperty().set(group.getTranslateZ() - 100);
//                    break;
//                case Q:
//                    group.rotateByX(10);
//                    break;
//                case E:
//                    group.rotateByX(-10);
//                    break;
//                case NUMPAD6:
//                    group.rotateByY(10);
//                    break;
//                case NUMPAD4:
//                    group.rotateByY(-10);
//                    break;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    // Custom SmartGroup class for rotation
//    class SmartGroup extends Group {
//
//        Rotate r;
//        Transform t = new Rotate();
//
//        SmartGroup(Node... nodes) {
//            super(nodes);
//        }
//
//        void rotateByX(int ang) {
//            r = new Rotate(ang, Rotate.X_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//
//        void rotateByY(int ang) {
//            r = new Rotate(ang, Rotate.Y_AXIS);
//            t = t.createConcatenation(r);
//            this.getTransforms().clear();
//            this.getTransforms().addAll(t);
//        }
//    }
//}
//



import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class Cupboard3D extends Application {

    private static final float WIDTH = 760;
    private static final float HEIGHT = 320;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);

    // Constants for cupboard dimensions
    private static final double CUPBOARD_HEIGHT = 300;
    private static final double CUPBOARD_WIDTH = 200;
    private static final double CUPBOARD_DEPTH = 50;
    private static final double DOOR_WIDTH = 100;
    private static final double DOOR_THICKNESS = 2; // Thin door
    private static final double SHELF_THICKNESS = 2; // Thin shelves

    @Override
    public void start(Stage primaryStage) {
        // Constructing the main cupboard structure using thin rectangles
        Box cupboardBody = prepareCupboardBody();
        Box leftDoor = prepareDoor();
        Box rightDoor = prepareDoor();
        Cylinder leftHandleTop = prepareHandle();
        Cylinder leftHandleBottom = prepareHandle();
        Cylinder rightHandleTop = prepareHandle();
        Cylinder rightHandleBottom = prepareHandle();

        // Add thin shelves inside the cupboard
        Box shelf1 = prepareShelf();
        shelf1.setTranslateY(-100);
        Box shelf2 = prepareShelf();
        shelf2.setTranslateY(0);
        Box shelf3 = prepareShelf();
        shelf3.setTranslateY(100);

        // Position the doors and handles
        double doorTranslateX = DOOR_WIDTH / 2 + DOOR_THICKNESS / 2;
        leftDoor.setTranslateX(-CUPBOARD_WIDTH / 4 + doorTranslateX);
        rightDoor.setTranslateX(CUPBOARD_WIDTH / 4 - doorTranslateX);

        double handleTranslateX = DOOR_WIDTH / 4;
        leftHandleTop.setTranslateX(leftDoor.getTranslateX() + handleTranslateX);
        leftHandleBottom.setTranslateX(leftDoor.getTranslateX() + handleTranslateX);
        rightHandleTop.setTranslateX(rightDoor.getTranslateX() - handleTranslateX);
        rightHandleBottom.setTranslateX(rightDoor.getTranslateX() - handleTranslateX);

        // Positioning handles near the black line
        double handleTranslateY = CUPBOARD_HEIGHT / 2;
        leftHandleTop.setTranslateY(-handleTranslateY);
        leftHandleBottom.setTranslateY(handleTranslateY);
        rightHandleTop.setTranslateY(-handleTranslateY);
        rightHandleBottom.setTranslateY(handleTranslateY);

        // Add black dividing line between the doors
        Line dividingLine = prepareDividingLine();

        // Grouping the components together using SmartGroup
        SmartGroup group = new SmartGroup(
                cupboardBody, leftDoor, rightDoor,
                leftHandleTop, leftHandleBottom, rightHandleTop, rightHandleBottom,
                shelf1, shelf2, shelf3, dividingLine, new AmbientLight()
        );

        // Setting up the camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(1000);
        camera.translateZProperty().set(-800);

        // Setting up the scene
        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        // Initializing mouse and keyboard controls
        initMouseControl(group, scene, primaryStage);

        primaryStage.setTitle("3D Cupboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to prepare the main cupboard body using thin rectangles
    private Box prepareCupboardBody() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
        Box cupboardBody = new Box(CUPBOARD_WIDTH, CUPBOARD_HEIGHT, CUPBOARD_DEPTH);
        cupboardBody.setMaterial(material);
        return cupboardBody;
    }

    // Method to prepare a door using a thin rectangle
    private Box prepareDoor() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
        Box door = new Box(DOOR_WIDTH, CUPBOARD_HEIGHT, DOOR_THICKNESS); // Thin door
        door.setMaterial(material);
        return door;
    }

    // Method to prepare the handle using a cylinder
    private Cylinder prepareHandle() {
        Cylinder handle = new Cylinder(2, 20); // Adjust handle size
        handle.setMaterial(new PhongMaterial(Color.BLACK));
        return handle;
    }

    // Method to prepare the shelf using a thin rectangle
    private Box prepareShelf() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
        Box shelf = new Box(CUPBOARD_WIDTH, SHELF_THICKNESS, CUPBOARD_DEPTH); // Thin shelf
        shelf.setMaterial(material);
        return shelf;
    }

    // Method to prepare the black dividing line between the doors
    private Line prepareDividingLine() {
        Line dividingLine = new Line(-DOOR_WIDTH / 2, 0, DOOR_WIDTH / 2, 0);
        dividingLine.setStroke(Color.BLACK);
        dividingLine.setTranslateY(-CUPBOARD_HEIGHT / 2);
        return dividingLine;
    }

    // Method to initialize mouse and keyboard controls
    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
        Rotate xRotate;
        Rotate yRotate;
        group.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS)
        );
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        scene.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });

        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleY.set(anchorAngleY + anchorX - event.getSceneX());
        });

        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
            double delta = event.getDeltaY();
            group.translateZProperty().set(group.getTranslateZ() + delta);
        });

        // Handling keyboard input for movement and rotation
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    group.translateZProperty().set(group.getTranslateZ() + 100);
                    break;
                case S:
                    group.translateZProperty().set(group.getTranslateZ() - 100);
                    break;
                case Q:
                    group.rotateByX(10);
                    break;
                case E:
                    group.rotateByX(-10);
                    break;
                case NUMPAD6:
                    group.rotateByY(10);
                    break;
                case NUMPAD4:
                    group.rotateByY(-10);
                    break;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Custom SmartGroup class for rotation
    class SmartGroup extends Group {

        Rotate r;
        Transform t = new Rotate();

        SmartGroup(Node... nodes) {
            super(nodes);
        }

        void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }
}
