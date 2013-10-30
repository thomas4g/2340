package edu.gatech.mule.fx;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.fx.screens.views.FXPlayerView;
import edu.gatech.mule.fx.screens.views.FXRaceSelectView;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.fx.screens.views.FXStartView;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.screen.ScreenHandler;
import edu.gatech.mule.screen.screens.views.MapView;
import edu.gatech.mule.screen.screens.views.ScreenView;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * FX screen handler
 * @version 0.1
 */
public class FXScreenHandler extends ScreenHandler {
	
	private StackPane stack;
	private FXMapView mainMapView;
	private HashMap<ScreenType, FXView> loadedScreens;
	private FXView currentView;
	
	/**
	 * Constructor for FX screen handler
	 * @param game, game engine
	 */
	public FXScreenHandler(GameEngine game) {
		super(game);
		stack = new StackPane();
		loadedScreens = new HashMap<>();
		FXApplication.view = stack; //TODO this is bad
	}
	
	

	/**
	 * Starts the javafx stage
	 */
	@Override
	public void start() {
//		javafx.application.Application.launch(FXApplication.class);
	}
	
	public FXView getCurrentView() {
		return this.currentView;
	}
	
	@Override
	public void setScreen(final ScreenType type) {
		Platform.runLater(new Runnable() {
			public void run() {
				setFXScreen(type);
			}
		});
	}
	
	private void setFXScreen(ScreenType type) {
		FXView view = null;
		super.setScreen(type);

		if(!loadedScreens.containsKey(type)) {
	    	view = (FXView)screens.get(type).getView();
			loadedScreens.put(type, view);
		} else {
			view = loadedScreens.get(type);
		}
		
		view.load();
		this.currentView = view;

		if(!stack.getChildren().isEmpty()){
	    	stack.getChildren().remove(0);
	        stack.getChildren().add(0, view.getNode());
	    } else {
	    	stack.getChildren().add(view.getNode());
	    }
	}

	@Override
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

	@Override
	protected MapView loadTownView() {
		if(null == mainMapView)
			mainMapView = new FXMapView();
		return mainMapView;
	}

}
