package edu.gatech.mule.screen;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screens.presenters.*;
import edu.gatech.mule.screens.views.fx.*;
import edu.gatech.mule.screens.views.text.*;

/**
 * Handles screens
 * Perhaps this could be abstracted even further?
 * an IScreenHandler and a FXScreenHandler, for example?
 * The concern then is where exactly are presenters created, etc.
 * @author tshields
 *
 */
public class ScreenHandler {
	
	private Screen currentScreen;
	
	public enum Screen {
		MENU(new MenuPresenter(new TextMenuView())),
		PLAYER(new PlayerConfigPresenter(new TextPlayerConfigView()));
		
		public ScreenPresenter presenter;
		
		Screen(ScreenPresenter presenter) {
			this.presenter = presenter;
		}
	};
	
	public void setCurrentScreen(Screen current) {
		currentScreen = current;
		currentScreen.presenter.init();
	}
	
	
}
