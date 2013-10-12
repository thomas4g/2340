package edu.gatech.mule.fx;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.graphics.Graphics;
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
	
	private Graphics graphics;
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
		Graphics.view = stack; 
		loadScreens();
		setScreen(ScreenType.START);
	}

	/**
	 * ???
	 */
	@Override
	public void start() {
		javafx.application.Application.launch(Graphics.class);
	}
	
	/**
	 * 
	 * ???
	 * 
	 * @param type
	 * @param controller
	 * 
	 */
	private boolean loadScreen(ScreenType type, Initializable controller) {
	    try{
	    	String resource = "/format/" + type.name().toLowerCase() + ".fxml";
	    	FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
	    	System.out.println(resource);
	        myLoader.setController(controller);
	        Parent node = (Parent) myLoader.load();
	        screens.put(type, node);
	        return true;
	    }
	    catch(IOException io) {
	    	return false;
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	        return false;
	    }
	}
	    
       
	/**
	 * Loads screens upon game start
	 */
	private void loadScreens() {
		classes.put(ScreenType.START, FXStartScreen.class);
		classes.put(ScreenType.SETTINGS, FXSettingsScreen.class);
		classes.put(ScreenType.RACE_SELECT, FXRaceSelectScreen.class);
		classes.put(ScreenType.PLAYER_SCREEN, FXPlayerScreen.class);
		classes.put(ScreenType.GAME_SCREEN, FXGameScreen.class);
	}
	
	public void disposeScreen(ScreenType type) {
		if(!screens.containsKey(type))
			return;					
		screens.remove(type);
	}
	
	/**
	 * ???
	 * 
	 * @param type
	 */
	//TODO exception handling
	@Override
	public void setScreen(ScreenType type) {
		try {
			if(screens.get(type) == null) {
				Class<?> clazz = classes.get(type);
				Constructor<?> con = clazz.getConstructor(GameEngine.class);
				Initializable controller = (Initializable)con.newInstance(game);
				loadScreen(type, controller);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(screens.get(type) != null){
			//If there is more than one screen
		    if(!stack.getChildren().isEmpty()){
		    	stack.getChildren().remove(0);    
		        stack.getChildren().add(0, screens.get(type));
		    }
		    else{
		    	//no one else been displayed, then just show
		    	stack.getChildren().add(screens.get(type));
		    }
		}
	}
	

}
