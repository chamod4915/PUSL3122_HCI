package org.furniwise.pusl3122_hci_project.Controllers.Common;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class Stool3D extends Application {

    private static final double WIDTH = 760;
    private static final double HEIGHT = 320;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);

    @Override
    public void start(Stage primaryStage) {
        Cylinder seat = prepareSeat();
        Box leg1 = prepareLeg();
        Box leg2 = prepareLeg();
        Box leg3 = prepareLeg();
        Box leg4 = prepareLeg();

        // Apply initial wood texture to legs
        applyImageToBox(leg1, "/Images/wood.jpg");
        applyImageToBox(leg2, "/Images/wood.jpg");
        applyImageToBox(leg3, "/Images/wood.jpg");
        applyImageToBox(leg4, "/Images/wood.jpg");

        // Position legs
        leg1.setTranslateX(seat.getRadius() - 40);
        leg1.setTranslateZ(seat.getRadius() - 15);

        leg2.setTranslateX(-seat.getRadius() + 40);
        leg2.setTranslateZ(seat.getRadius() - 15);

        leg3.setTranslateX(seat.getRadius() - 40);
        leg3.setTranslateZ(-seat.getRadius() + 15);

        leg4.setTranslateX(-seat.getRadius() + 40);
        leg4.setTranslateZ(-seat.getRadius() + 15);

        SmartGroup group = new SmartGroup();
        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
        group.getChildren().add(new AmbientLight());

        group.setRotationAxis(Rotate.X_AXIS);
        group.setRotate(-170);

        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(1000);
        camera.translateZProperty().set(-400);

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.SILVER);

        SubScene subScene = new SubScene(group, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);
        subScene.setCamera(camera);
        subScene.setFill(Color.SILVER);
        root.setCenter(subScene);

        // Color Pickers
        ColorPicker seatColorPicker = new ColorPicker(Color.BROWN);
        ColorPicker legColorPicker = new ColorPicker(Color.BROWN);
        HBox controlPanel = new HBox(10, seatColorPicker, legColorPicker);
        controlPanel.setStyle("-fx-padding: 10; -fx-background-color: #eeeeee;");
        root.setBottom(controlPanel);

        // Event: Seat color change (removes texture)
        seatColorPicker.setOnAction(e -> {
            PhongMaterial seatMaterial = new PhongMaterial();
            seatMaterial.setDiffuseColor(seatColorPicker.getValue());
            seat.setMaterial(seatMaterial);
        });

        // Event: Leg color change (removes texture)
        legColorPicker.setOnAction(e -> {
            PhongMaterial legMaterial = new PhongMaterial();
            legMaterial.setDiffuseColor(legColorPicker.getValue());
            leg1.setMaterial(legMaterial);
            leg2.setMaterial(legMaterial);
            leg3.setMaterial(legMaterial);
            leg4.setMaterial(legMaterial);
        });

        initMouseControl(group, scene, primaryStage);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.G) {
                camera.setTranslateZ(camera.getTranslateZ() - 50); // Zoom in
            } else if (event.getCode() == KeyCode.T) {
                camera.setTranslateZ(camera.getTranslateZ() + 50); // Zoom out
            }
        });

        primaryStage.setTitle("3D Round Stool");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Optional animation
            }
        };
        timer.start();
    }

    private Cylinder prepareSeat() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));

        Cylinder seat = new Cylinder(70, 5);
        seat.setMaterial(material);
        seat.setTranslateY(25);
        return seat;
    }

    private Box prepareLeg() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        material.setSpecularColor(Color.WHITE);

        Box leg = new Box(7, 50, 7);
        leg.setMaterial(material);
        return leg;
    }

    private void applyImageToBox(Box box, String imagePath) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
        box.setMaterial(material);
    }

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
