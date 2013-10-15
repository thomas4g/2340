package edu.gatech.mule.fx;

import java.io.IOException;
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
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

/**
 * Screen handler for graphics
 * 
 * @version 1.0
 */
public class FXScreenHandler extends ScreenHandler {
	
	private Graphics graphics;
	private GameEngine game;
	private StackPane stack;
	private HashMap<ScreenType, Node> screens;
	
	/**
	 * Sets up general graphics upon game start
	 * 
	 * @param game, the game engine
	 */
	@Override
	public void load(GameEngine game) {
		this.game = game;
		screens = new HashMap<ScreenType, Node>();
		stack = new StackPane();
		Graphics.view = stack; 
		loadScreens();
		setScreen(ScreenType.START);
	}

	/**
	 * Launches graphics engine
	 */
	@Override
	public void start() {
		javafx.application.Application.launch(Graphics.class);
	}
	
	/**
	 * some FX XML WTH BBQ stuff
	 * 
	 * @param type, type of screen to be displayed currently
	 * @param controller, IDK
	 */
	private boolean loadScreen(ScreenType type, Initializable controller) {
	    try{
	    	String resource = "/format/" + type.name().toLowerCase() + ".fxml";
	    	System.out.println(resource);
	    	FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
	        controller.initialize(null, null);
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
		loadScreen(ScreenType.START,new FXStartScreen(game));
		loadScreen(ScreenType.SETTINGS, new FXSettingsScreen(game, game.getSettings()));
		loadScreen(ScreenType.RACE_SELECT, new FXRaceSelectScreen(game,game.getSettings()));
		loadScreen(ScreenType.PLAYER_SCREEN, new FXPlayerScreen(game,game.getSettings()));
		loadScreen(ScreenType.GAME_SCREEN, new FXGameScreen(game, game.getSettings()));
	}
	
	/**
	 * Shows screen to current display
	 * 
	 * @param type, type of screen to be displayed
	 */
	//TODO exception handling
	@Override
	public void setScreen(ScreenType type) {
		if(screens.get(type) != null){
			//Is there is more than one screen
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
