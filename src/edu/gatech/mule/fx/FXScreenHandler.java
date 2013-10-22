package edu.gatech.mule.fx;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screen.screens.views.*;
import edu.gatech.mule.fx.screens.views.*;

/**
 * 
 * FX screen handler
 * 
 * @version 1.0
 *
 */
public class FXScreenHandler extends ScreenHandler {
	
	private StackPane stack;
	private FXMapView mainMapView;

	public FXScreenHandler(GameEngine game) {
		super(game);
		stack = new StackPane();
		FXApplication.view = stack; //TODO this is bad
	}

	/**
	 * starts the javafx stage
	 */
	@Override
	public void start() {
		javafx.application.Application.launch(FXApplication.class);
	}
	
	    
//	/**
//	 * Removes the screen from the screen stack
//	 */
//	public void disposeScreen(ScreenType type) {
//		if(!screens.containsKey(type))
//			return;					
//		screens.remove(type);
//	}
	
	/**
	 * TODO Move all of this to the display method
	 */
	public void setScreen(final ScreenType type) {
		super.setScreen(type);
    	FXView scr = (FXView)screens.get(type).getView();
		scr.load();
		Node node = scr.getNode();

		if(!stack.getChildren().isEmpty()){
	    	stack.getChildren().remove(0);    
	        stack.getChildren().add(0, node);
	    } else {
	    	stack.getChildren().add(node);
	    }
	}

	protected ScreenView loadStartView() {
		return new FXStartView();
	}

	@Override
	protected SettingsView loadSettingsView() {
		return new FXSettingsView();
	}

	@Override
	protected SettingsView loadRaceSelectView() {
		return new FXRaceSelectView();
	}

	@Override
	protected SettingsView loadPlayerView() {
		return new FXPlayerView();
	}

	@Override
	protected MapView loadGameplayView() {
		if(null == mainMapView)
			mainMapView = new FXMapView();
		return mainMapView;
	}

	@Override
	protected MapView loadLandSelectView() {
		if(null == mainMapView)
			mainMapView = new FXMapView();
		return mainMapView;
	}

}
