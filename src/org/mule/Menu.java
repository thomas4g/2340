package org.mule;


 import javafx.application.Application;
 import javafx.scene.Group;
 import javafx.scene.Scene; 
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
 import javafx.scene.paint.Color;
 import javafx.stage.Stage; 

 public class Menu extends Application {
 
     @Override public void start(Stage stage) {
         // load the image
         Image image = new Image("file:/home/dengel6/Desktop/assets/start_menu.png");
 
         // simple displays ImageView the image as is
         ImageView iv1 = new ImageView();
         iv1.setImage(image);

         Group root = new Group();
         Scene scene = new Scene(root);
         scene.setFill(Color.BLACK);
         HBox box = new HBox();
         box.getChildren().add(iv1);
         root.getChildren().add(box);
 
         stage.setTitle("ImageView");
         stage.setWidth(575);
         stage.setHeight(545);
         stage.setScene(scene); 
         stage.sizeToScene(); 
         stage.show(); 
     }

     public static void main(String[] args) {
         Application.launch(args);
     }
     
 }
 