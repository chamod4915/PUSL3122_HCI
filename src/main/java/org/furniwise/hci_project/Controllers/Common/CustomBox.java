package org.furniwise.pusl3122_hci_project.Controllers.Common;

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
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class CustomBox extends Application {

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
    private static final double SHELF_THICKNESS = 5;

    @Override
    public void start(Stage primaryStage) {
        // Constructing the main cupboard structure using custom box
        Group cupboardBody = prepareCupboardBody();

        // Setting up the camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(1000);
        camera.translateZProperty().set(-800);

        // Setting up the scene
        Scene scene = new Scene(cupboardBody, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        // Initializing mouse and keyboard controls
        initMouseControl(cupboardBody, scene, primaryStage);

        primaryStage.setTitle("3D Cupboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to prepare the main cupboard body using custom box
    private Group prepareCupboardBody() {
        // Creating thin rectangles for the top and bottom
        Box top = createThinRectangle(CUPBOARD_WIDTH, SHELF_THICKNESS, CUPBOARD_DEPTH);
        top.setTranslateY(-CUPBOARD_HEIGHT / 2 + SHELF_THICKNESS / 2);
        Box bottom = createThinRectangle(CUPBOARD_WIDTH, SHELF_THICKNESS, CUPBOARD_DEPTH);
        bottom.setTranslateY(CUPBOARD_HEIGHT / 2 - SHELF_THICKNESS / 2);

        // Creating rectangles for the right and left sides
        Box rightSide = createThinRectangle(CUPBOARD_DEPTH, CUPBOARD_HEIGHT - SHELF_THICKNESS * 2, CUPBOARD_DEPTH);
        rightSide.setTranslateX(CUPBOARD_WIDTH / 2 - CUPBOARD_DEPTH / 2);
        Box leftSide = createThinRectangle(CUPBOARD_DEPTH, CUPBOARD_HEIGHT - SHELF_THICKNESS * 2, CUPBOARD_DEPTH);
        leftSide.setTranslateX(-CUPBOARD_WIDTH / 2 + CUPBOARD_DEPTH / 2);

        // Creating a larger thin rectangle for the back side
        Box back = createThinRectangle(CUPBOARD_WIDTH, CUPBOARD_HEIGHT - SHELF_THICKNESS * 2, CUPBOARD_DEPTH);

        // Combining all parts to form the cupboard body
        Group cupboardBody = new Group(top, bottom, rightSide, leftSide, back);

        return cupboardBody;
    }

    // Method to create a thin rectangle
    private Box createThinRectangle(double width, double height, double depth) {
        PhongMaterial material = new PhongMaterial(Color.GRAY);
        Box rectangle = new Box(width, height, depth);
        rectangle.setMaterial(material);
        return rectangle;
    }

    // Method to initialize mouse and keyboard controls
    private void initMouseControl(Group group, Scene scene, Stage stage) {
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
