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
import edu.gatech.mule.fx.screens.FXMenuScreen;
import edu.gatech.mule.screen.ScreenHandler;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

public class FXScreenHandler extends ScreenHandler {
	
	private Graphics graphics;
	private GameEngine game;
	private StackPane stack;
	private HashMap<ScreenType, Node> screens;
	
	@Override
	public void start(GameEngine game) {
		Graphics.view = stack; 
		javafx.application.Application.launch(Graphics.class);
		loadScreens();
	}
	    
	private boolean loadScreen(ScreenType type, String resource, Initializable controller) {
	    try{
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
	    
       
	
	private void loadScreens() {
		loadScreen(ScreenType.MENU, "/Sample.fxml", new FXMenuScreen(game, game.getSettings()));
	}
	
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
