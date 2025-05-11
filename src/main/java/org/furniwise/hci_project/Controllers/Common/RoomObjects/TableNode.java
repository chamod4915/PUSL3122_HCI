package org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects;
//import javafx.animation.AnimationTimer;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//
//public class TableNode extends Group {
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
//    public TableNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
//        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);
//
//        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
//        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);
//
//        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
//        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);
//
//        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
//        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        group.getChildren().add(new AmbientLight());
//
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
//        initMouseControl(group, scene);
//
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                // Add any animation logic here if needed
//            }
//        };
//        timer.start();
//
//        this.getChildren().add(group);
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Box box = new Box(120, 2, 120);
//        box.setMaterial(material);
//        box.setTranslateY(25);
//        return box;
//    }
//
//    private Box prepareLeg() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box leg = new Box(5, 50, 5);
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
//    private void initMouseControl(SmartGroup group, Scene scene) {
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
//    }
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
//}
//
//
//import javafx.animation.AnimationTimer;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//
//public class TableNode extends Group {
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
//    public TableNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
//        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);
//
//        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
//        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);
//
//        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
//        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);
//
//        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
//        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        group.getChildren().add(new AmbientLight());
//
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
//        initMouseControl(group, scene);
//
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                // Add any animation logic here if needed
//            }
//        };
//        timer.start();
//
//        this.getChildren().add(group);
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Box box = new Box(120, 2, 120);
//        box.setMaterial(material);
//        box.setTranslateY(25);
//        return box;
//    }
//
//    private Box prepareLeg() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box leg = new Box(5, 50, 5);
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
//    private void initMouseControl(SmartGroup group, Scene scene) {
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
//    }
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
//    public void setMouseStart(double sceneX, double sceneY) {
//        anchorX = sceneX;
//        anchorY = sceneY;
//        anchorAngleX = angleX.get();
//        anchorAngleY = angleY.get();
//    }
//
//    public void rotateTable(double sceneX, double sceneY) {
//        angleX.set(anchorAngleX - (anchorY - sceneY));
//        angleY.set(anchorAngleY + anchorX - sceneX);
//    }
//
//    public void rotateTableNode(double angleX, double angleY,double angleZ) {
//        this.angleX.set(angleX);
//        this.angleY.set(angleY);
//    }
//
//    public void adjustTranslation(double deltaX, double deltaY, double deltaZ) {
//        // Implement translation logic here if needed
//    }
//}

//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//
//public class TableNode extends Group {
//
//    public TableNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
//        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);
//
//        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
//        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);
//
//        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
//        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);
//
//        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
//        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);
//
//        getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        getChildren().add(new javafx.scene.AmbientLight());
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BEIGE);
//
//        Box box = new Box(120, 2, 120);
//        box.setMaterial(material);
//        box.setTranslateY(25);
//        return box;
//    }
//
//    private Box prepareLeg() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//
//        Box leg = new Box(5, 50, 5);
//        leg.setMaterial(material);
//        return leg;
//    }
//
//    private void applyImageToBox(Box box, String imagePath) {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN); // Set a default color if no image is provided
//        if (imagePath != null && !imagePath.isEmpty()) {
//            // Apply image if provided
//            //material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
//        }
//        box.setMaterial(material);
//    }
//}

//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//
//public class TableNode extends Group {
//
//    public TableNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
//        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);
//
//        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
//        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);
//
//        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
//        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);
//
//        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
//        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);
//
//        getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        getChildren().add(new javafx.scene.AmbientLight());
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BEIGE);
//
//        Box box = new Box(120, 2, 120);
//        box.setMaterial(material);
//        box.setTranslateY(25);
//        return box;
//    }
//
//    private Box prepareLeg() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//
//        Box leg = new Box(5, 50, 5);
//        leg.setMaterial(material);
//        return leg;
//    }
//
//    private void applyImageToBox(Box box, String imagePath) {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN); // Set a default color if no image is provided
//        if (imagePath != null && !imagePath.isEmpty()) {
//            // Apply image if provided
//            //material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
//        }
//        box.setMaterial(material);
//    }
//
//    public void adjustTranslation(double deltaY) {
//        setTranslateY(getTranslateY() + deltaY);
//    }
//}
//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//
//public class TableNode extends Group {
//
//    public TableNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
//        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);
//
//        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
//        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);
//
//        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
//        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);
//
//        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
//        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);
//
//        getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        getChildren().add(new javafx.scene.AmbientLight());
//
//        // Create the original table
//        Box originalTable = prepareOriginalTable();
//        getChildren().add(originalTable);
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BEIGE);
//
//        Box box = new Box(120, 2, 120);
//        box.setMaterial(material);
//        box.setTranslateY(25);
//        return box;
//    }
//
//    private Box prepareLeg() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//
//        Box leg = new Box(5, 50, 5);
//        leg.setMaterial(material);
//        return leg;
//    }
//
//    private Box prepareOriginalTable() {
//        // Create the original table as per the Table3D class
//        Box originalTable = new Box(120, 2, 120);
//        originalTable.setMaterial(new PhongMaterial(Color.GREEN));
//        originalTable.setTranslateY(50); // Adjust translation to match the seat
//        return originalTable;
//    }
//
//    private void applyImageToBox(Box box, String imagePath) {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN); // Set a default color if no image is provided
//        if (imagePath != null && !imagePath.isEmpty()) {
//            // Apply image if provided
//            //material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
//        }
//        box.setMaterial(material);
//    }
//
//    public void adjustTranslation(double deltaY) {
//        setTranslateY(getTranslateY() + deltaY);
//    }
//}

//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//
//public class TableNode extends Group {
//
//    public TableNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        leg1.setTranslateX(seat.getWidth() / 2 - leg1.getWidth() / 2);
//        leg1.setTranslateZ(seat.getDepth() / 2 - leg1.getDepth() / 2);
//
//        leg2.setTranslateX(-seat.getWidth() / 2 + leg2.getWidth() / 2);
//        leg2.setTranslateZ(seat.getDepth() / 2 - leg2.getDepth() / 2);
//
//        leg3.setTranslateX(seat.getWidth() / 2 - leg3.getWidth() / 2);
//        leg3.setTranslateZ(-seat.getDepth() / 2 + leg3.getDepth() / 2);
//
//        leg4.setTranslateX(-seat.getWidth() / 2 + leg4.getWidth() / 2);
//        leg4.setTranslateZ(-seat.getDepth() / 2 + leg4.getDepth() / 2);
//
//        getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        getChildren().add(new javafx.scene.AmbientLight());
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BEIGE);
//
//        Box box = new Box(120, 2, 120);
//        box.setMaterial(material);
//        box.setTranslateY(25);
//        return box;
//    }
//
//    private Box prepareLeg() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//
//        Box leg = new Box(5, 50, 5);
//        leg.setMaterial(material);
//        return leg;
//    }
//
//    private void applyImageToBox(Box box, String imagePath) {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN); // Set a default color if no image is provided
//        if (imagePath != null && !imagePath.isEmpty()) {
//            // Apply image if provided
//            //material.setDiffuseMap(new Image(getClass().getResourceAsStream(imagePath)));
//        }
//        box.setMaterial(material);
//    }
//
//    public void adjustTranslation(double deltaY) {
//        // Adjust translation to move the table vertically up
//        setTranslateY(getTranslateY() - deltaY);
//    }
//}


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class TableNode extends Group {

    private final double WIDTH = 760;
    private final double HEIGHT = 320;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;

    private double translateX = 0;
    private double translateY = 0;
    private double translateZ = 0;

    private double mouseX, mouseY;
    private double rotateDeltaX = 0;
    private double rotateDeltaY = 0;

    public TableNode() {
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

        getChildren().addAll(seat, leg1, leg2, leg3, leg4);
        getChildren().add(new javafx.scene.AmbientLight());

        // Rotate the chair 180 degrees to flip it
        Rotate flipRotation = new Rotate(180, Rotate.X_AXIS);
        this.getTransforms().add(flipRotation);
    }

    private Box prepareBox() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));

        Box box = new Box(120, 5, 200);
        box.setMaterial(material);
        box.setTranslateY(30);
        return box;
    }

    private Box prepareLeg() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        material.setSpecularColor(Color.WHITE);

        Box leg = new Box(5, 60, 5);
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
    public void rotateTable(double x, double y) {
        // Calculate the difference in mouse position
        double deltaX = x - mouseX;
        double deltaY = y - mouseY;

        // Update the rotation delta values
        rotateDeltaX += deltaX;
        rotateDeltaY += deltaY;

        // Apply rotation to the chair
        rotateTableNode(rotateDeltaY * 0.2, rotateDeltaX * 0.2, 0);

        // Update the starting mouse position
        mouseX = x;
        mouseY = y;
    }


    public void rotateTableNode(double rotateX, double rotateY, double rotateZ) {
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

    // Implement methods for rotation and translation if needed
}
