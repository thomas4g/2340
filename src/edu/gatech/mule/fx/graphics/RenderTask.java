package edu.gatech.mule.fx.graphics;

import javafx.application.Platform;
import javafx.concurrent.Task;
import edu.gatech.mule.fx.FXScreenHandler;

public class RenderTask extends Thread {

	public static boolean paused = false;
	private static final long FPS = 15;
	
	private FXScreenHandler handler;
	
	public RenderTask(FXScreenHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void run() {
		System.out.println("STARTED");
		while(!paused) {
			Platform.runLater(new Runnable() {
				public void run() {
					if(handler.getCurrentView() != null)
						handler.getCurrentView().render();
				}
			});
			try {
				Thread.sleep(1000 / FPS);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
}
