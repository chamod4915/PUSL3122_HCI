package org.furniwise.pusl3122_hci_project.Controllers;
//
//
//
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.Camera;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
///**
// * @author afsal villan
// * @version 1.0
// *
// * http://www.genuinecoder.com
// */
//public class Reflection extends Application {
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
//        Box box = prepareBox();
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().add(box);
//
//        Camera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-200);
//
//        Scene scene = new Scene(group, WIDTH, HEIGHT);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        group.translateXProperty().set(0);
//        group.translateYProperty().set(0);
//        group.translateZProperty().set(0);
//
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("Genuine Coder");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
////        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.png"))));
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        material.setSpecularMap(new Image(getClass().getResourceAsStream("/Images/spec.jpg")));
//
//        Box box = new Box(100, 20, 50);
//        box.setMaterial(material);
//        return box;
//    }
//
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.Camera;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
//
//    private static final float WIDTH = 780;
//    private static final float HEIGHT = 360;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    @Override
//    public void start(Stage primaryStage) {
//        Rectangle rectangle = prepareRectangle();
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().add(rectangle);
//
//        Camera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-200);
//
//        Scene scene = new Scene(group, WIDTH, HEIGHT);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        group.translateXProperty().set(0);
//        group.translateYProperty().set(0);
//        group.translateZProperty().set(0);
//
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("Genuine Coder");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Rectangle prepareRectangle() {
//        Image woodImage = new Image(getClass().getResourceAsStream("/Images/wood.jpg"));
//        ImagePattern imagePattern = new ImagePattern(woodImage);
//
//        Rectangle rectangle = new Rectangle(75, 40);
//        rectangle.setFill(imagePattern);
//        return rectangle;
//    }
//
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.application.Application;
//import javafx.scene.*;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
//
//    private static final double WIDTH = 760;
//    private static final double HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double previousTranslateX, previousTranslateY;
//
//    @Override
//    public void start(Stage primaryStage) {
//        Box box = prepareBox();
//
//        Group group = new Group();
//        group.getChildren().add(box);
//
//        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
//        scene.setFill(Color.SILVER);
//
//        box.setOnMousePressed(event -> {
//            anchorX = event.getSceneX();
//            anchorY = event.getSceneY();
//            previousTranslateX = box.getTranslateX();
//            previousTranslateY = box.getTranslateY();
//        });
//
//        box.setOnMouseDragged(event -> {
//            double deltaX = event.getSceneX() - anchorX;
//            double deltaY = event.getSceneY() - anchorY;
//
//            box.setTranslateX(previousTranslateX + deltaX);
//            box.setTranslateY(previousTranslateY + deltaY);
//        });
//
//        primaryStage.setTitle("Draggable Box");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BEIGE);
//        material.setSpecularColor(Color.WHITE);
//
//        Box box = new Box(100, 100, 100);
//        box.setMaterial(material);
//        return box;
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Reflection extends Application {
//
//    private static final double WIDTH = 760;
//    private static final double HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double previousTranslateX, previousTranslateY;
//
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    @Override
//    public void start(Stage primaryStage) {
//        Box box = prepareBox();
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().add(box);
//
//        Camera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-200);
//
//        Scene scene = new Scene(group, WIDTH, HEIGHT);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        group.translateXProperty().set(0);
//        group.translateYProperty().set(0);
//        group.translateZProperty().set(0);
//
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("Genuine Coder");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BEIGE);
//        material.setSpecularColor(Color.WHITE);
//
//        Box box = new Box(100, 20, 50);
//        box.setMaterial(material);
//        return box;
//    }
//
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
//            previousTranslateX = group.getTranslateX();
//            previousTranslateY = group.getTranslateY();
//        });
//
//        scene.setOnMouseDragged(event -> {
//            double deltaX = event.getSceneX() - anchorX;
//            double deltaY = event.getSceneY() - anchorY;
//
//            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//            angleY.set(anchorAngleY + anchorX - event.getSceneX());
//
//            group.setTranslateX(previousTranslateX + deltaX);
//            group.setTranslateY(previousTranslateY + deltaY);
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Reflection extends Application {
//
//    private static final double WIDTH = 760;
//    private static final double HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double previousTranslateX, previousTranslateY;
//
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//
//    private boolean rotationEnabled = false;
//
//    @Override
//    public void start(Stage primaryStage) {
//        Box box = prepareBox();
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().add(box);
//
//        Camera camera = new PerspectiveCamera(true);
//        camera.setNearClip(1);
//        camera.setFarClip(1000);
//        camera.translateZProperty().set(-200);
//
//        Scene scene = new Scene(group, WIDTH, HEIGHT);
//        scene.setFill(Color.SILVER);
//        scene.setCamera(camera);
//
//        group.translateXProperty().set(0);
//        group.translateYProperty().set(0);
//        group.translateZProperty().set(0);
//
//        Button rotateButton = new Button("Enable Rotation");
//        rotateButton.setOnAction(event -> {
//            rotationEnabled = !rotationEnabled;
//            if (rotationEnabled) {
//                rotateButton.setText("Disable Rotation");
//            } else {
//                rotateButton.setText("Enable Rotation");
//            }
//        });
//
//        rotateButton.setTranslateX(10);
//        rotateButton.setTranslateY(10);
//
//        group.getChildren().add(rotateButton);
//
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("Draggable Box");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
////        material.setDiffuseColor(Color.BEIGE);
////        material.setSpecularColor(Color.WHITE);
//                material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood_baseColor.png")));
//        material.setSpecularMap(new Image(getClass().getResourceAsStream("/Images/spec.jpg")));
//
//        Box box = new Box(100, 20, 50);
//        box.setMaterial(material);
//        return box;
//    }
//
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
//            if (!rotationEnabled) {
//                anchorX = event.getSceneX();
//                anchorY = event.getSceneY();
//                previousTranslateX = group.getTranslateX();
//                previousTranslateY = group.getTranslateY();
//            }
//        });
//
//        scene.setOnMouseDragged(event -> {
//            if (!rotationEnabled) {
//                double deltaX = event.getSceneX() - anchorX;
//                double deltaY = event.getSceneY() - anchorY;
//
//                group.setTranslateX(previousTranslateX + deltaX);
//                group.setTranslateY(previousTranslateY + deltaY);
//            }
//        });
//
//        stage.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
//            if (rotationEnabled) {
//                angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
//                angleY.set(anchorAngleY + anchorX - event.getSceneX());
//            }
//        });
//
//        stage.addEventHandler(ScrollEvent.SCROLL, event -> {
//            double delta = event.getDeltaY();
//            group.translateZProperty().set(group.getTranslateZ() + delta);
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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


//-----------------------------------MULTIPLE----------------------------------------------
//
//
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.AmbientLight;
//import javafx.scene.Camera;
//import javafx.scene.Group;
//import javafx.scene.Node;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.PointLight;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Sphere;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.scene.transform.Translate;
//import javafx.stage.Stage;
//
///**
// * @author afsal villan
// * @version 1.0
// *
// * http://www.genuinecoder.com
// */
//public class Reflection extends Application {
//
//    private static final float WIDTH = 760;
//    private static final float HEIGHT = 320;
//
//    private double anchorX, anchorY;
//    private double anchorAngleX = 0;
//    private double anchorAngleY = 0;
//    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
//    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
//    private final PointLight pointLight = new PointLight();
//
//    @Override
//    public void start(Stage primaryStage) {
//        Box box = prepareBox();
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().add(box);
//        group.getChildren().add(prepareSecondBox());
//        group.getChildren().add(new AmbientLight());
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
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
//
//        primaryStage.setTitle("Genuine Coder");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                pointLight.setRotate(pointLight.getRotate() + 1);
//            }
//        };
//        timer.start();
//    }
//
//    private Node prepareSecondBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box box = new Box(20, 100, 100);
//        box.setMaterial(material);
//        return box;
//    }
//
//    private Box prepareBox() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//        Box box = new Box(100, 20, 50);
//        box.setMaterial(material);
//        return box;
//    }
//
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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

//
//import javafx.application.Application;
//import javafx.scene.AmbientLight;
//import javafx.scene.Camera;
//import javafx.scene.Group;
//import javafx.scene.PerspectiveCamera;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Translate;
//import javafx.stage.Stage;
//
//public class ChairExample extends Application {
//
//    private static final float WIDTH = 760;
//    private static final float HEIGHT = 600;
//
//    @Override
//    public void start(Stage primaryStage) {
//        Group root = new Group();
//        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
//
//        // Materials
//        PhongMaterial woodMaterial = new PhongMaterial();
//        woodMaterial.setDiffuseColor(Color.SADDLEBROWN);
//
//        // Chair parts
//        Box seat = new Box(120, 20, 120);
//        seat.setMaterial(woodMaterial);
//
//        Box backRest = new Box(100, 120, 10);
//        backRest.setMaterial(woodMaterial);
//        backRest.setTranslateY(-70);
//        backRest.setTranslateZ(55);
//
//        Box leg1 = new Box(10, 150, 10);
//        leg1.setMaterial(woodMaterial);
//        leg1.setTranslateY(75);
//        leg1.setTranslateX(-55);
//        leg1.setTranslateZ(55);
//
//        Box leg2 = new Box(10, 150, 10);
//        leg2.setMaterial(woodMaterial);
//        leg2.setTranslateY(75);
//        leg2.setTranslateX(55);
//        leg2.setTranslateZ(55);
//
//        Box leg3 = new Box(10, 100, 10);
//        leg3.setMaterial(woodMaterial);
//        leg3.setTranslateY(75);
//        leg3.setTranslateX(-55);
//        leg3.setTranslateZ(-55);
//
//        Box leg4 = new Box(10, 100, 10);
//        leg4.setMaterial(woodMaterial);
//        leg4.setTranslateY(75);
//        leg4.setTranslateX(55);
//        leg4.setTranslateZ(-55);
//
//        // Add all parts to the root group
//        root.getChildren().addAll(seat, backRest, leg1, leg2, leg3, leg4);
//
//        // Lighting
//        AmbientLight light = new AmbientLight();
//        light.setColor(Color.WHITE);
//        root.getChildren().add(light);
//
//        // Camera setup
//        Camera camera = new PerspectiveCamera(true);
//        camera.setNearClip(0.1);
//        camera.setFarClip(1000.0);
//        camera.translateZProperty().set(-500);
//
//        // Adding camera and setting the scene
//        scene.setCamera(camera);
//
//        primaryStage.setTitle("JavaFX Chair Example");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

//
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
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
//    @Override
//    public void start(Stage primaryStage) {
//        Box seat = prepareSeat();
//        Box backrest = prepareBackrest();
//        Box apron1 = prepareApron();
//        Box apron2 = prepareApron();
//        Cylinder spindle1 = prepareSpindle();
//        Cylinder spindle2 = prepareSpindle();
//        Cylinder spindle3 = prepareSpindle();
//        Cylinder spindle4 = prepareSpindle();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, backrest, apron1, apron2, spindle1, spindle2, spindle3, spindle4,
//                leg1, leg2, leg3, leg4);
//        group.getChildren().add(new AmbientLight());
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Chair");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
//    private Box prepareSeat() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box seat = new Box(120, 5, 120);
//        seat.setMaterial(material);
//        seat.setTranslateY(60);
//        return seat;
//    }
//
//    private Box prepareBackrest() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box backrest = new Box(5, 70, 120);
//        backrest.setMaterial(material);
//        backrest.setTranslateY(-30);
//        backrest.setTranslateZ(-60);
//        return backrest;
//    }
//
//    private Box prepareApron() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box apron = new Box(120, 5, 5);
//        apron.setMaterial(material);
//        apron.setTranslateY(25);
//        apron.setTranslateZ(60);
//        return apron;
//    }
//
//    private Cylinder prepareSpindle() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Cylinder spindle = new Cylinder(2, 50);
//        spindle.setMaterial(material);
//        spindle.setTranslateY(25);
//        spindle.setTranslateZ(60);
//        return spindle;
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Cylinder;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
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
//    @Override
//    public void start(Stage primaryStage) {
//        Box seat = prepareSeat();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        group.getChildren().add(new AmbientLight());
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Chair");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
//    private Box prepareSeat() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box seat = new Box(120, 2, 120);
//        seat.setMaterial(material);
//        seat.setTranslateY(25);
//        return seat;
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.application.Application;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.scene.*;
//import javafx.scene.input.ScrollEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.PhongMaterial;
//import javafx.scene.shape.Box;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
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
//    @Override
//    public void start(Stage primaryStage) {
//        Box seat = prepareSeat();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
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
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        group.getChildren().add(new AmbientLight());
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Chair");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
//    private Box prepareSeat() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.BROWN);
//        material.setSpecularColor(Color.WHITE);
//
//        Box seat = new Box(120, 5, 120);
//        seat.setMaterial(material);
//        seat.setTranslateY(25);
//        return seat;
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
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
//    @Override
//    public void start(Stage primaryStage) {
//        Box seat = prepareBox();
//        Box leg1 = prepareLeg();
//        Box leg2 = prepareLeg();
//        Box leg3 = prepareLeg();
//        Box leg4 = prepareLeg();
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
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4);
//        group.getChildren().add(new AmbientLight());
//
//        // Set initial rotation
//        group.setRotationAxis(Rotate.X_AXIS);
//        group.setRotate(-30);
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Chair");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.application.Application;
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
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
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
//    @Override
//    public void start(Stage primaryStage) {
//        Box seat = prepareBox();
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Chair");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
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
//    @Override
//    public void start(Stage primaryStage) {
//        Box seat = prepareBox();
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
//        Box backrest = prepareBackrest();
//        backrest.setTranslateY(-seat.getHeight() / 2); // Adjust position to align with seat edge
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest);
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Chair");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
//    private Box prepareBackrest() {
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
//
//        Box backrest = new Box(120, 50, 2); // Adjust dimensions as needed
//        backrest.setMaterial(material);
//        return backrest;
//    }
//
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Transform;
//import javafx.stage.Stage;
//
//public class Chair3D extends Application {
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
//    @Override
//    public void start(Stage primaryStage) {
//        Box seat = prepareBox();
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
//        Box backrest = prepareBackrest();
//        backrest.setTranslateX(-seat.getWidth() / 2 );
//        backrest.setTranslateY(-seat.getHeight() / 2 + 65);
//        backrest.setTranslateZ(0);
//
//        SmartGroup group = new SmartGroup();
//        group.getChildren().addAll(seat, leg1, leg2, leg3, leg4, backrest);
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
//        initMouseControl(group, scene, primaryStage);
//
//        primaryStage.setTitle("3D Chair");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
//    }
//
//    public static void main(String[] args) {
//        launch(args);
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



import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * @author afsal villan
 * @version 1.0
 *
 * http://www.genuinecoder.com
 */
public class Chair3D extends Application {

    private static final float WIDTH = 1400;
    private static final float HEIGHT = 1000;

    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    private final PointLight pointLight = new PointLight();

    @Override
    public void start(Stage primaryStage) {
        Box box = prepareBox();

        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);
        group.getChildren().add(prepareSecondBox());
        group.getChildren().add(new AmbientLight());

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

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
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

        primaryStage.setTitle("Genuine Coder");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                pointLight.setRotate(pointLight.getRotate() + 1);
            }
        };
        timer.start();
    }

    private Node prepareSecondBox() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
        Box box = new Box(20, 100, 100);
        box.setMaterial(material);
        return box;
    }

    private Box prepareBox() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Images/wood.jpg")));
        Box box = new Box(100, 20, 50);
        box.setMaterial(material);
        return box;
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