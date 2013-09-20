package org.mule;

/**
 * Graphics module
 * @author Thomas Shields
 *
 */
public class Graphics {
	
	private Screen currentScreen;
	
	public void setScreen(Screen currentScreen) {
		this.currentScreen=currentScreen;
	}
	
	public Screen getScreen(){
		return currentScreen;
	}

	public void loadScreen(){
		//each screen will have a different method of loading
		//The most important thing is just to note that each
		//is basically a mixture of ImageAssets
	}
}
