package edu.gatech.mule.fx.graphics;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dengel6
 */
public class Graphics extends Application {
    
     public static final String MAIN = "main"; 
     public static final String MAIN_FXML ="Sample.fxml";
    
    @Override
    public void start(Stage stage) throws Exception {
        ViewHandler handler=new ViewHandler();
        handler.loadScreen(Graphics.MAIN, Graphics.MAIN_FXML);
        handler.setScreen(Graphics.MAIN);
       
        Group root = new Group();
        root.getChildren().addAll(handler);
        Scene scene = new Scene(root,400,400);
        stage.setScene(scene);
        stage.setTitle("Testomatic");
        stage.show();
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}