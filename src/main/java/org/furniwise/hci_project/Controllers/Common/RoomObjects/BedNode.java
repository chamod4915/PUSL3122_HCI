package org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects;



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


public class BedNode extends Group {

    private static final double WIDTH = 760;
    private static final double HEIGHT = 320;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);


    private double translateX = 0;
    private double translateY = 0;
    private double translateZ = 0;

    private double mouseX, mouseY;
    private double rotateDeltaX = 0;
    private double rotateDeltaY = 0;


    public BedNode() {
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

        Box backrest = prepareBackrest();
        backrest.setTranslateX(-seat.getWidth() / 2 );
        backrest.setTranslateY(-seat.getHeight() / 2 + 50);
        backrest.setTranslateZ(0);

        // Add the mattress box
        Box mattress = prepareMattress(seat.getWidth(), seat.getHeight(), seat.getDepth());
        mattress.setTranslateY(25 + 10); // Position it on top of the seat box

//        SmartGroup group = new SmartGroup();
        getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest, mattress);
        getChildren().add(new AmbientLight());

        // Set initial rotation
        setRotationAxis(Rotate.X_AXIS);
        setRotate(-180);

        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(1000);
        camera.translateZProperty().set(-400);

//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        group.translateXProperty().set(0);
//        group.translateYProperty().set(0);
//        group.translateZProperty().set(0);

        // Rotate the chair 180 degrees to flip it
//        Rotate flipRotation = new Rotate(180, Rotate.X_AXIS);
//        this.getTransforms().add(flipRotation);
    }

    private Box prepareMattress(double width, double height, double depth) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.WHITE);
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/mattres.jpg")));

        // Create a thicker box for the mattress
        Box mattress = new Box(width , height+10, depth); // Add extra thickness
        mattress.setMaterial(material);
        return mattress;
    }

    private Box prepareBox() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));

        Box box = new Box(200, 10, 150);
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

    private Box prepareBackrest() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));

        Box backrest = new Box(5, 50, 150); // Adjust dimensions as needed
        backrest.setMaterial(material);
        return backrest;
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
    public void rotateBed(double x, double y) {
        // Calculate the difference in mouse position
        double deltaX = x - mouseX;
        double deltaY = y - mouseY;

        // Update the rotation delta values
        rotateDeltaX += deltaX;
        rotateDeltaY += deltaY;

        // Apply rotation to the chair
        rotateBedNode(rotateDeltaY * 0.2, rotateDeltaX * 0.2, 0);

        // Update the starting mouse position
        mouseX = x;
        mouseY = y;
    }


    public void rotateBedNode(double rotateX, double rotateY, double rotateZ) {
        System.out.println("working...rotation..");
//        Rotate rotateXAxis = new Rotate(rotateX, Rotate.X_AXIS);
        Rotate rotateYAxis = new Rotate(rotateY, Rotate.Y_AXIS);
//        Rotate rotateZAxis = new Rotate(rotateZ, Rotate.Z_AXIS);
        this.getTransforms().addAll(rotateYAxis);
    }




}
