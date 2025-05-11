package org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects;
//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.image.Image;
//
//public class ChairNode extends Group {
//
//    private double translateX = 0;
//    private double translateY = 0;
//    private double translateZ = 0;
//
//    public ChairNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//        Box backrest = prepareBackrest();
//
//        // Apply image to legs
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        // Position legs
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
//        backrest.setTranslateX(-seat.getWidth() / 2 );
//        backrest.setTranslateY(-seat.getHeight() / 2 + 65);
//        backrest.setTranslateZ(0);
//
//        getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest);
//        getChildren().add(new javafx.scene.AmbientLight());
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Box box = new Box(70, 5, 70);
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
//        Box leg = new Box(10, 50, 10);
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
//    private Box prepareBackrest() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Box backrest = new Box(5, 80, 70); // Adjust dimensions as needed
//        backrest.setMaterial(material);
//        return backrest;
//    }
//
//    public void adjustTranslation(double deltaX, double deltaY, double deltaZ) {
//        this.translateX += deltaX;
//        this.translateY += deltaY;
//        this.translateZ += deltaZ;
//        this.setTranslateX(this.translateX);
//        this.setTranslateY(this.translateY);
//        this.setTranslateZ(this.translateZ);
//    }
//}



//package org.furniwise.pusl3122_hci_project.Controllers.Common.RoomObjects;
//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.image.Image;
//import javafx.scene.transform.Rotate;
//
//public class ChairNode extends Group {
//
//    private double translateX = 0;
//    private double translateY = 0;
//    private double translateZ = 0;
//
//    public ChairNode() {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//        Box backrest = prepareBackrest();
//
//        // Apply image to legs
//        applyImageToBox(leg1, "/Images/wood.jpg");
//        applyImageToBox(leg2, "/Images/wood.jpg");
//        applyImageToBox(leg3, "/Images/wood.jpg");
//        applyImageToBox(leg4, "/Images/wood.jpg");
//
//        // Position legs
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
//        backrest.setTranslateX(-seat.getWidth() / 2 );
//        backrest.setTranslateY(-seat.getHeight() / 2 + 65);
//        backrest.setTranslateZ(0);
//
//        getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest);
//        getChildren().add(new javafx.scene.AmbientLight());
//
//        // Adjust the chair's translation to lift it vertically
//        adjustTranslation(0, -25, 0);
//
//        // Rotate the chair 180 degrees to flip it
//        Rotate flipRotation = new Rotate(180, Rotate.X_AXIS);
//        this.getTransforms().add(flipRotation);
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Box box = new Box(70, 5, 70);
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
//        Box leg = new Box(10, 50, 10);
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
//    private Box prepareBackrest() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Box backrest = new Box(5, 80, 70); // Adjust dimensions as needed
//        backrest.setMaterial(material);
//        return backrest;
//    }
//
//    public void adjustTranslation(double deltaX, double deltaY, double deltaZ) {
//        this.translateX += deltaX;
//        this.translateY += deltaY;
//        this.translateZ += deltaZ;
//        this.setTranslateX(this.translateX);
//        this.setTranslateY(this.translateY);
//        this.setTranslateZ(this.translateZ);
//    }
//}



import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class ChairNode extends Group {

    private double translateX = 0;
    private double translateY = 0;
    private double translateZ = 0;

    private double mouseX, mouseY;
    private double rotateDeltaX = 0;
    private double rotateDeltaY = 0;

    public ChairNode() {
        Box seat = prepareBox();
        Box leg1 = prepareLeg();
        Box leg2 = prepareLeg();
        Box leg3 = prepareLeg();
        Box leg4 = prepareLeg();
        Box backrest = prepareBackrest();

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

        backrest.setTranslateX(-seat.getWidth() / 2 );
        backrest.setTranslateY(-seat.getHeight() / 2 + 65);
        backrest.setTranslateZ(0);

        getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest);
        getChildren().add(new javafx.scene.AmbientLight());

        // Adjust the chair's translation to lift it vertically
        adjustTranslation(0, -25, 0);

        // Rotate the chair 180 degrees to flip it
        Rotate flipRotation = new Rotate(180, Rotate.X_AXIS);
        this.getTransforms().add(flipRotation);
    }

    private Box prepareBox() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));

        Box box = new Box(70, 5, 70);
        box.setMaterial(material);
        box.setTranslateY(25);
        return box;
    }

    private Box prepareLeg() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        material.setSpecularColor(Color.WHITE);

        Box leg = new Box(10, 50, 10);
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

        Box backrest = new Box(5, 80, 70); // Adjust dimensions as needed
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

//    public void rotateChairNode(double angleX, double angleY, double angleZ) {
//        Rotate rotation = new Rotate(angleX, angleY, angleZ);
//        this.getTransforms().add(rotation);
//    }

//    public void rotateChairNode(double rotateX, double rotateY, double rotateZ) {
//        Rotate rotate = new Rotate(rotateX, rotateY, rotateZ);
//        this.getTransforms().add(rotate);
//    }

    public void setMouseStart(double x, double y) {
        mouseX = x;
        mouseY = y;
    }

    // Method to calculate and apply chair rotation based on mouse movement
    public void rotateChair(double x, double y) {
        // Calculate the difference in mouse position
        double deltaX = x - mouseX;
        double deltaY = y - mouseY;

        // Update the rotation delta values
        rotateDeltaX += deltaX;
        rotateDeltaY += deltaY;

        // Apply rotation to the chair
        rotateChairNode(rotateDeltaY * 0.2, rotateDeltaX * 0.2, 0);

        // Update the starting mouse position
        mouseX = x;
        mouseY = y;
    }


    public void rotateChairNode(double rotateX, double rotateY, double rotateZ) {
        System.out.println("working...rotation..");
//        Rotate rotateXAxis = new Rotate(rotateX, Rotate.X_AXIS);
        Rotate rotateYAxis = new Rotate(rotateY, Rotate.Y_AXIS);
//        Rotate rotateZAxis = new Rotate(rotateZ, Rotate.Z_AXIS);
        this.getTransforms().addAll(rotateYAxis);
    }



}
