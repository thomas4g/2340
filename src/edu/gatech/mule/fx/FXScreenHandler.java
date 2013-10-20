package edu.gatech.mule.fx;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screen.screens.*;
import edu.gatech.mule.fx.screens.*;

/**
 * 
 * FX screen handler
 * 
 * @version 1.0
 *
 */
public class FXScreenHandler extends ScreenHandler {
	
	private static final String FXML_DIR = "/format/";
	
	private StackPane stack;

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
	public void setScreen(ScreenType type) {
		FXScreen scr = (FXScreen)screens.get(type);
		scr.load();
		Node node = scr.getNode();

		if(!stack.getChildren().isEmpty()){
	    	stack.getChildren().remove(0);    
//			stack.getChildren().clear();
	        stack.getChildren().add(0, node);
	    } else {
	    	stack.getChildren().add(node);
	    }
		
		super.setScreen(type);
	}

	
	@Override
	protected AbstractStartScreen loadStartScreen() {
		return new FXStartScreen(game);
	}

	@Override
	protected AbstractSettingsScreen loadSettingsScreen() {
		return new FXSettingsScreen(game);
	}

	@Override
	protected AbstractRaceSelectScreen loadRaceSelectScreen() {
		return new FXRaceSelectScreen(game);
	}

	@Override
	protected AbstractPlayerScreen loadPlayerScreen() {
		return new FXPlayerScreen(game);
	}

	@Override
	protected AbstractGameScreen loadGameScreen() {
		return new FXGameScreen(game);
	}

}
