package edu.gatech.mule.core;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.gatech.mule.fx.FXScreenHandler;
import edu.gatech.mule.fx.graphics.RenderTask;

/**
 * Sets up and launches the application.
 * @version 1.0
 */
public class FXApplication extends Application {

	private static final String TITLE = "M.U.L.E. by 85% Wildebeests";

	public static final int WIDTH = 720;
	public static final int HEIGHT = 520;

	@Override
	public void start(Stage stage) throws Exception {
		GameEngine game = new GameEngine();
		FXScreenHandler handler = new FXScreenHandler(game);
		game.load(handler);

		Group root = new Group();
		root.getChildren().addAll(handler.getStack());
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setScene(scene);
		stage.setTitle(TITLE);
		stage.show();

		Thread renderThread = new Thread(new RenderTask(handler));
		renderThread.setDaemon(true);
		renderThread.start();

		game.start();
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
