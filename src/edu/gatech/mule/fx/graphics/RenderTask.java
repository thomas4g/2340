package edu.gatech.mule.fx.graphics;

import javafx.application.Platform;
import edu.gatech.mule.fx.FXScreenHandler;

/**
 * What makes the constant updates and takes care of drawing
 * @version 1.0
 */
public class RenderTask extends Thread {

	public static boolean paused = false;
	private static final long FPS = 15;
	
	private FXScreenHandler handler;
	
	/**
	 * Constructor for the render task
	 * @param handler, screen handler view
	 */
	public RenderTask(FXScreenHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void run() {
		System.out.println("STARTED");
		while (!paused) {
			Platform.runLater(new Runnable() {
				public void run() {
					if (handler.getCurrentView() != null) {
						handler.getCurrentView().render();
					}
				}
			});
			try {
				Thread.sleep(1000 / FPS);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
}
