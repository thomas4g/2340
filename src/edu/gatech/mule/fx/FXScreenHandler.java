package edu.gatech.mule.fx;

import edu.gatech.mule.fx.graphics.Graphics;
import edu.gatech.mule.screen.ScreenHandler;

public class FXScreenHandler extends ScreenHandler {
	
	private Graphics graphics;
	
	public FXScreenHandler() {
		graphics = new Graphics();
		Graphics.launch(new String[]{});
	}

	@Override
	public void setScreen(ScreenType type) {
		// TODO Auto-generated method stub
		
	}
	

}
