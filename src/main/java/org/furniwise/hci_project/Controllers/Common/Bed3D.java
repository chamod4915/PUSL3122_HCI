package org.furniwise.pusl3122_hci_project.Controllers.Common;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class Bed3D extends Application {

    private static final double WIDTH = 760;
    private static final double HEIGHT = 500;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);

    private Box seat, leg1, leg2, leg3, leg4, backrest;

    @Override
    public void start(Stage primaryStage) {
        seat = prepareBox();
        leg1 = prepareLeg();
        leg2 = prepareLeg();
        leg3 = prepareLeg();
        leg4 = prepareLeg();
        backrest = prepareBackrest();

        // Apply image to legs
        applyImageToBox(leg1, "/Images/wood.jpg");
        applyImageToBox(leg2, "/Images/wood.jpg");
        applyImageToBox(leg3, "/Images/wood.jpg");
        applyImageToBox(leg4, "/Images/wood.jpg");

        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);

        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);

        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);

        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);

        backrest.setTranslateX(-seat.getWidth() / 2);
        backrest.setTranslateY(-seat.getHeight() / 2 + 50);
        backrest.setTranslateZ(0);

        Box mattress = prepareMattress(seat.getWidth(), seat.getHeight(), seat.getDepth());
        mattress.setTranslateY(25 + 10);

        SmartGroup group = new SmartGroup();
        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest, mattress);
        group.getChildren().add(new AmbientLight());

        group.setRotationAxis(Rotate.X_AXIS);
        group.setRotate(-170);

        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(1000);
        camera.translateZProperty().set(-400);

        SubScene subScene = new SubScene(group, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.SILVER);
        subScene.setCamera(camera);

        initMouseControl(group, subScene, primaryStage);

        ColorPicker colorPicker = new ColorPicker(Color.BEIGE);
        colorPicker.setOnAction(e -> {
            Color selectedColor = colorPicker.getValue();
            PhongMaterial newMaterial = new PhongMaterial(selectedColor);
            seat.setMaterial(newMaterial);
            leg1.setMaterial(newMaterial);
            leg2.setMaterial(newMaterial);
            leg3.setMaterial(newMaterial);
            leg4.setMaterial(newMaterial);
            backrest.setMaterial(newMaterial);
        });

        VBox controls = new VBox(10, colorPicker);
        controls.setPadding(new Insets(10));
        controls.setPickOnBounds(false);
        controls.setTranslateX(WIDTH - 120);
        controls.setTranslateY(HEIGHT - 60);

        StackPane root = new StackPane();
        root.getChildren().addAll(subScene, controls);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.G) {
                camera.setTranslateZ(camera.getTranslateZ() - 50);
            } else if (event.getCode() == KeyCode.T) {
                camera.setTranslateZ(camera.getTranslateZ() + 50);
            }
        });

        primaryStage.setTitle("3D Bed with Color Picker");
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Optional animation logic
            }
        }.start();
    }

    private Box prepareBox() {
        Box box = new Box(120, 5, 120);
        applyImageToBox(box, "/Images/wood.jpg");
        box.setTranslateY(25);
        return box;
    }

    private Box prepareLeg() {
        Box leg = new Box(5, 50, 5);
        return leg;
    }

    private Box prepareMattress(double width, double height, double depth) {
        PhongMaterial material = new PhongMaterial(Color.WHITE);
        Box mattress = new Box(width, height + 12, depth);
        mattress.setMaterial(material);
        return mattress;
    }

    private void applyImageToBox(Box box, String imagePath) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
        box.setMaterial(material);
    }

    private Box prepareBackrest() {
        Box back = new Box(2, 50, 120);
        applyImageToBox(back, "/Images/wood.jpg");
        return back;
    }

    private void initMouseControl(SmartGroup group, SubScene scene, Stage stage) {
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