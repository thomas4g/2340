package edu.gatech.mule.fx;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.graphics.RenderTask;
import edu.gatech.mule.music.MenuMusicTask;

/**
 * Run this main method to start game
 * 
 * @version 0.1
 */
public class FXApplication extends Application {
	
	private final static String TITLE = "M.U.L.E. by 85% Wildebeests";
	
	private final static int WIDTH = 720;
	private final static int HEIGHT = 520;
    
	public static StackPane view;
	
    @Override
    public void start(Stage stage) throws Exception {
    	GameEngine game = new GameEngine();
    	FXScreenHandler handler = new FXScreenHandler(game);
    	game.load(handler);
    	
        Group root = new Group();
        root.getChildren().addAll(view);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle(TITLE);
        stage.show();

        MenuMusicTask music = new MenuMusicTask();
        music.run();
    	Thread renderThread = new Thread(new RenderTask(handler));
    	renderThread.setDaemon(true);
    	renderThread.start();
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
