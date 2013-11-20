package edu.gatech.mule.fx;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.views.FXView;
import edu.gatech.mule.fx.views.gameplay.FXMapView;
import edu.gatech.mule.fx.views.main.FXHelpView;
import edu.gatech.mule.fx.views.main.FXPersistenceView;
import edu.gatech.mule.fx.views.main.FXStartView;
import edu.gatech.mule.fx.views.player.FXColorSelectView;
import edu.gatech.mule.fx.views.player.FXNameChooseView;
import edu.gatech.mule.fx.views.player.FXRaceSelectView;
import edu.gatech.mule.fx.views.settings.FXDifficultyView;
import edu.gatech.mule.fx.views.settings.FXMapTypeView;
import edu.gatech.mule.fx.views.settings.FXNumPlayersView;
import edu.gatech.mule.screen.ScreenHandler;
import edu.gatech.mule.screen.views.MapView;
import edu.gatech.mule.screen.views.PersistenceView;
import edu.gatech.mule.screen.views.ScreenView;
import edu.gatech.mule.screen.views.SettingsView;
import edu.gatech.mule.screen.views.TownMapView;

/**
 * View representation of the screen handler.
 * @version 1.0
 */
public class FXScreenHandler extends ScreenHandler {

	private StackPane stack;
	private FXMapView mainMapView;
	private HashMap<ScreenType, FXView> loadedScreens;
	private FXView currentView;

	/**
	 * Constructor for FX screen handler.
	 * @param game engine associated with the game
	 */
	public FXScreenHandler(GameEngine game) {
		super(game);
		stack = new StackPane();
		loadedScreens = new HashMap<>();
	}

	/**
	 * Returns the current view.
	 * @return the current view
	 */
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

	/**
	 * Sets the screen's view based on the screen type.
	 * @param type the screen type
	 */
	private void setFXScreen(ScreenType type) {
		FXView view = null;
		super.setScreen(type);

		if (!loadedScreens.containsKey(type)) {
	    	view = (FXView) screens.get(type).getView();
			loadedScreens.put(type, view);
		} else {
			view = loadedScreens.get(type);
		}

		view.load();
		this.currentView = view;

		// stack.getChildren() is JavaFX norm :(
		if (!stack.getChildren().isEmpty()) {
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
	protected PersistenceView loadPersistenceView() {
		return new FXPersistenceView();
	}

	@Override
	protected ScreenView loadHelpView() {
		return new FXHelpView();
	}

	@Override
	protected SettingsView loadDifficultyView() {
		return new FXDifficultyView();
	}

	@Override
	protected SettingsView loadMapTypeView() {
		return new FXMapTypeView();
	}

	@Override
	protected SettingsView loadNumPlayersView() {
		return new FXNumPlayersView();
	}

	@Override
	protected SettingsView loadRaceSelectView() {
		return new FXRaceSelectView();
	}

	@Override
	protected SettingsView loadColorView() {
		return new FXColorSelectView();
	}

	@Override
	protected SettingsView loadNameView() {
		return new FXNameChooseView();
	}

	@Override
	protected MapView loadGameplayView() {
		if (null == mainMapView) {
			mainMapView = new FXMapView();
		}
		return mainMapView;
	}

	@Override
	protected MapView loadLandSelectView() {
		if (null == mainMapView) {
			mainMapView = new FXMapView();
		}
		return mainMapView;
	}

	@Override
	protected TownMapView loadTownView() {
		if (null == mainMapView) {
			mainMapView = new FXMapView();
		}
		return mainMapView;
	}

	/**
	 * Gets the main stack pane.
	 * @return a stackpane
	 */
	public StackPane getStack() {
		return stack;
	}

}
