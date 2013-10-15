package edu.gatech.mule.fx.graphics;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Graphics engine
 *
 * @author dengel6
 * @version 1.0
 */
public class Graphics extends Application {
    
	public static StackPane view;

	/**
	 * Sets up the main frame for the game
	 * 
	 * @param stage, the main frame of the game
	 */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        root.getChildren().addAll(view);
        Scene scene = new Scene(root,533,500);
        stage.setScene(scene);
        stage.setTitle("Mule");
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