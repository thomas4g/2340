package org.mule;

public class Menu extends Screen {

	public Menu(AtariMule game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	public void activate() {
		//do stuff
	}
	public void buttonPressed() {
		game.setScreen(AtariMule.ScreenType.GAMEPLAY);
	}
}
