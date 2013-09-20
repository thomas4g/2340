package org.mule;

public class ScreenHandler {

	//private Input input;
	private Screen screen;
	private Graphics graphicsEngine;
	private GameEngine gameEngine;
	
	
	public ScreenHandler(Screen screen,Graphics graphics, GameEngine engine) {
		this.screen=screen;
		this.graphicsEngine=graphics;
		this.gameEngine=engine;
	}
	//This method gives the scene to the engine so that it can be 
	//manipulated and returned as a new scene with new data or
	// a new scene altogether
	
	public void changeScreen(Screen screen){
		this.screen=screen;
	}
	
	public void handleInput(){
		gameEngine.recieveInput(/*Input input*/);
		gameEngine.recieveScene(screen);
		changeScreen(gameEngine.getScreen());
	}
	
	public void paint(){
		graphicsEngine.recieveScreen(screen);
		graphicsEngine.draw();
	}

}
