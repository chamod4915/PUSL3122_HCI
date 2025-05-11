package org.furniwise.pusl3122_hci_project.Controllers.Common;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class Table2D extends Application {

    private static final double WIDTH = 760;
    private static final double HEIGHT = 320;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    private Group root; // Added field to hold the root Group

    @Override
    public void start(Stage primaryStage) {
        Box seat = prepareBox();
        Box leg1 = prepareLeg();
        Box leg2 = prepareLeg();
        Box leg3 = prepareLeg();
        Box leg4 = prepareLeg();

        // Apply image to legs
        applyImageToBox(leg1, "/Images/wood.jpg");
        applyImageToBox(leg2, "/Images/wood.jpg");
        applyImageToBox(leg3, "/Images/wood.jpg");
        applyImageToBox(leg4, "/Images/wood.jpg");

        // Position legs
        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);

        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);

        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);

        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);

        SmartGroup group = new SmartGroup();
        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
        group.getChildren().add(new AmbientLight());

        // Set initial rotation
        group.setRotationAxis(Rotate.X_AXIS);
        group.setRotate(-170);

        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(1000);
        camera.translateZProperty().set(-400);

        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        group.translateXProperty().set(0);
        group.translateYProperty().set(0);
        group.translateZProperty().set(0);

        initMouseControl(group, scene, primaryStage);

        primaryStage.setTitle("2D Table");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Add any animation logic here if needed
            }
        };
        timer.start();

        root = group; // Set the root Group
    }

    public Group getRoot() {
        return root; // Return the root Group
    }

    private Box prepareBox() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));

        Box box = new Box(120, 2, 120);
        box.setMaterial(material);
        box.setTranslateY(25);
        return box;
    }

    private Box prepareLeg() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        material.setSpecularColor(Color.WHITE);

        Box leg = new Box(5, 50, 5);
        leg.setMaterial(material);
        return leg;
    }

    private void applyImageToBox(Box box, String imagePath) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
        box.setMaterial(material);
    }

    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
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
    }

    public static void main(String[] args) {
        launch(args);
    }

    class SmartGroup extends Group {

        Rotate r;
        Transform t = new Rotate();

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
