package edu.gatech.mule.fx;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.FXGameScreen;
import edu.gatech.mule.fx.screens.FXPlayerScreen;
import edu.gatech.mule.fx.screens.FXRaceSelectScreen;
import edu.gatech.mule.fx.screens.FXSettingsScreen;
import edu.gatech.mule.fx.screens.FXStartScreen;
import edu.gatech.mule.screen.ScreenHandler;

/**
 * 
 * FX screen handler
 * 
 * @version 1.0
 *
 */
public class FXScreenHandler extends ScreenHandler {
	
	private static final String FXML_DIR = "/format/";
	
	private GameEngine game;
	private StackPane stack;
	private HashMap<ScreenType, Node> screens;
	private HashMap<ScreenType, Class<?>> classes;
	
	/**
	 * 
	 * ???
	 * 
	 * @param game
	 */
	@Override
	public void load(GameEngine game) {
		this.game = game;
		screens = new HashMap<ScreenType, Node>();
		classes = new HashMap<ScreenType, Class<?>>();
		stack = new StackPane();
		FXApplication.view = stack; //TODO this is bad
		loadScreens();
		setScreen(ScreenType.START);
	}

	/**
	 * starts the javafx stage
	 */
	@Override
	public void start() {
		javafx.application.Application.launch(FXApplication.class);
	}
	
	public StackPane getScreenStack() {
		return stack;
	}
	    
       
	/**
	 * Loads the screen classes upon game start
	 */
	private void loadScreens() {
//		screens.put(ScreenType.START, new FXStartScreen(game));
//		screens.put(ScreenType.SETTINGS, new FXSettingsScreen(game));
//		screens.put(ScreenType.RACE_SELECT, new FXRaceSelectScreen(game));
//		screens.put(ScreenType.PLAYER_SCREEN, new FXPlayerScreen(game));
//		screens.put(ScreenType.GAME_SCREEN, new FXGameScreen(game));
		
		classes.put(ScreenType.START, FXStartScreen.class);
		classes.put(ScreenType.SETTINGS, FXSettingsScreen.class);
		classes.put(ScreenType.RACE_SELECT, FXRaceSelectScreen.class);
		classes.put(ScreenType.PLAYER_SCREEN, FXPlayerScreen.class);
		classes.put(ScreenType.GAME_SCREEN, FXGameScreen.class);
	}
	
	/**
	 * Removes the screen from the screen stack
	 */
	public void disposeScreen(ScreenType type) {
		if(!screens.containsKey(type))
			return;					
		screens.remove(type);
	}
	
	public void setScreen(Parent node) {
		if(!stack.getChildren().isEmpty()){
	    	stack.getChildren().remove(0);    
	        stack.getChildren().add(0, node);
	    } else {
	    	stack.getChildren().add(node);
	    }
	}
	
	/**
	 * Changes the currently displayed screen
	 * 
	 * @param type the Screen Type
	 */
	@Override
	public void setScreen(ScreenType type) {
		try {
			if(screens.get(type) == null) {
				Class<?> clazz = classes.get(type);
				Constructor<?> con = clazz.getConstructor(GameEngine.class);
				Parent node = (Parent)con.newInstance(game);
				screens.put(type, node);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(screens.get(type) != null){
		    if(!stack.getChildren().isEmpty()){
		    	stack.getChildren().remove(0);    
		        stack.getChildren().add(0, screens.get(type));
		    } else {
		    	stack.getChildren().add(screens.get(type));
		    }
		}
	}
	

}
