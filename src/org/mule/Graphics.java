package org.mule;

/**
 * Graphics module
 * @author Thomas Shields
 *
 */
public class Graphics {
	
	private Screen screen;
	
	/*
	 * The current screen is is drawn as a collection of
	 * Textures, GUI elements, and Sprites
	 * @param the scene object passed from the SceneHandler
	 */
	
	public void recieveScreen(Screen screen){
		this.screen=screen;
	}
	
	/*
	 * The current screen is is drawn as a collection of
	 * Textures, GUI elements, and Sprites
	 */
	
	private void drawFrame(){
		//draws GUI
	}
	private void drawWorld(){
		//basically (for Tile t in Map: draw(t))
	}
	
	private void drawEntities(){
		//similiar to drawWorld() but (for Drawable d in entities: draw(d))
	}
	
	public void draw(){
		//this method checks based on the SceneType which draw methods to call
	}
	
}
