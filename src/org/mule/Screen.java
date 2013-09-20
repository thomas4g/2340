package org.mule;

/**
 * A slide or deck for information and user interaction
 * Could be the start screen or the main gameplay area
 * @author Thomas Shields
 *
 */
public abstract class Screen {

	public enum ScreenType {WELCOME, MENU, GAMEPLAY, AUCTION, ENDING};
	protected ScreenType screenType;
	
	public void setScreenType(ScreenType type){
		this.screenType=type;
	}
	/* Subclasses will have many more things
	 * They will have a Map object, GUI elements, Drawable Entities
	 * There should be a genEntities() method and a getMap() method
	 * so that the GraphicsEngine and GameEngine can access this data
	 */

}
