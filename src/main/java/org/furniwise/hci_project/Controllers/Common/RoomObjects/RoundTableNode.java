package org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects;
//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.image.Image;
//import javafx.scene.transform.Rotate;
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//import org.furniwise.pusl3122_hci_project.Controllers.Common.Stool3D;
//
//public class RoundTableNode extends Group {
//
//    private static final double WIDTH = 760;
//    private static final double HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//
//
//    public RoundTableNode() {
//        Cylinder seat = prepareSeat();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        // Apply image to legs
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        // Position legs
//        leg1.setTranslateX(seat.getRadius()-40);
//        leg1.setTranslateZ(seat.getRadius()-15);
//
//        leg2.setTranslateX(-seat.getRadius()+40);
//        leg2.setTranslateZ(seat.getRadius()-15);
//
//        leg3.setTranslateX(seat.getRadius()-40);
//        leg3.setTranslateZ(-seat.getRadius()+15);
//
//        leg4.setTranslateX(-seat.getRadius()+40);
//        leg4.setTranslateZ(-seat.getRadius()+15);
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        group.getChildren().add(new AmbientLight());
//
//        // Set initial rotation
//        group.setRotationAxis(Rotate.X_AXIS);
//        group.setRotate(-170);
//
//        Camera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-400);
//
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        group.translateXProperty().set(0);
//        group.translateYProperty().set(0);
//        group.translateZProperty().set(0);
//
////        initMouseControl(group, scene, primaryStage);
////
////        primaryStage.setTitle("3D Round Table");
////        primaryStage.setScene(scene);
////        primaryStage.show();
//
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                // Add any animation logic here if needed
//            }
//        };
//        timer.start();
//    }
//
//
//    private Cylinder prepareSeat() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Cylinder seat = new Cylinder(70, 5);
//        seat.setMaterial(material);
//        seat.setTranslateY(25); // Adjusted to keep it at the same level as the legs
//        return seat;
//    }
//
//    private Box prepareLeg() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box leg = new Box(7, 50, 7);
//        leg.setMaterial(material);
//        return leg;
//    }
//
//    private void applyImageToBox(Box box, String imagePath) {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
//        box.setMaterial(material);
//    }
//
////    private void initMouseControl(Stool3D.SmartGroup group, Scene scene, Stage stage) {
////        Rotate xRotate;
////        Rotate yRotate;
////        group.getTransforms().addAll(
////                xRotate = new Rotate(0, Rotate.X_AXIS),
////                yRotate = new Rotate(0, Rotate.Y_AXIS)
////        );
////        xRotate.angleProperty().bind(angleX);
////        yRotate.angleProperty().bind(angleY);
////
////        scene.setOnMousePressed(event -> {
////            anchorX = event.getSceneX();
////            anchorY = event.getSceneY();
////            anchorAngleX = angleX.get();
////            anchorAngleY = angleY.get();
////        });
////
////        scene.setOnMouseDragged(event -> {
////            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
////            angleY.set(anchorAngleY + anchorX - event.getSceneX());
////        });
////
////        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
////            double delta = event.getDeltaY();
////            group.translateZProperty().set(group.getTranslateZ() + delta);
////        });
////    }
////
////    public static void main(String[] args) {
////        launch(args);
////    }
//
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
//
//
//
//}


import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;

public class RoundTableNode extends Group {

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;

    private double translateX = 0;
    private double translateY = 0;
    private double translateZ = 0;

    private double mouseX, mouseY;
    private double rotateDeltaX = 0;
    private double rotateDeltaY = 0;

    public RoundTableNode() {
        Cylinder seat = prepareSeat();
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
        leg1.setTranslateX(seat.getRadius() - 40);
        leg1.setTranslateZ(seat.getRadius() - 15);

        leg2.setTranslateX(-seat.getRadius() + 40);
        leg2.setTranslateZ(seat.getRadius() - 15);

        leg3.setTranslateX(seat.getRadius() - 40);
        leg3.setTranslateZ(-seat.getRadius() + 15);

        leg4.setTranslateX(-seat.getRadius() + 40);
        leg4.setTranslateZ(-seat.getRadius() + 15);

//        leg1.setTranslateY(-40);
//        leg2.setTranslateY(-40);
//        leg3.setTranslateY(-40);
//        leg4.setTranslateY(-40);

        getChildren().addAll(seat, leg1, leg2, leg3, leg4);
        getChildren().add(new AmbientLight());

        this.setTranslateY(100);
        // Set initial rotation
        setRotationAxis(Rotate.X_AXIS);
        setRotate(-180);
    }

    private Cylinder prepareSeat() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));

        Cylinder seat = new Cylinder(70, 5);
        seat.setMaterial(material);
        seat.setTranslateY(25); // Adjusted to keep it at the same level as the legs
        return seat;
    }

    private Box prepareLeg() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        material.setSpecularColor(Color.WHITE);

        Box leg = new Box(7, 50, 7);
//        leg.setTranslateY(-10);
        leg.setMaterial(material);
        return leg;
    }

    public void adjustTranslation(double deltaX, double deltaY, double deltaZ) {
        this.translateX += deltaX;
        this.translateY += deltaY;
        this.translateZ += deltaZ;
        this.setTranslateX(this.translateX);
        this.setTranslateY(this.translateY);
        this.setTranslateZ(this.translateZ);
    }

    public void setMouseStart(double x, double y) {
        mouseX = x;
        mouseY = y;
    }

    // Method to calculate and apply chair rotation based on mouse movement
    public void rotateRoundTable(double x, double y) {
        // Calculate the difference in mouse position
        double deltaX = x - mouseX;
        double deltaY = y - mouseY;

        // Update the rotation delta values
        rotateDeltaX += deltaX;
        rotateDeltaY += deltaY;

        // Apply rotation to the chair
        rotateRoundTableNode(rotateDeltaY * 0.2, rotateDeltaX * 0.2, 0);

        // Update the starting mouse position
        mouseX = x;
        mouseY = y;
    }


    public void rotateRoundTableNode(double rotateX, double rotateY, double rotateZ) {
        System.out.println("working...rotation..");
//        Rotate rotateXAxis = new Rotate(rotateX, Rotate.X_AXIS);
        Rotate rotateYAxis = new Rotate(rotateY, Rotate.Y_AXIS);
//        Rotate rotateZAxis = new Rotate(rotateZ, Rotate.Z_AXIS);
        this.getTransforms().addAll(rotateYAxis);
    }


    private void applyImageToBox(Box box, String imagePath) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
        box.setMaterial(material);
    }
}
