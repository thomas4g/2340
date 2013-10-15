package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.AbstractRaceSelectScreen;

/**
 * Graphics for race select screen
 * 
 * @version 1.0
 */
public class FXRaceSelectScreen extends AbstractRaceSelectScreen implements Initializable {

	/**
	 * Constructor for race select screen graphics
	 * 
	 * @param game, the game engine
	 * @param settings, the game config
	 */
	public FXRaceSelectScreen(GameEngine engine,Settings settings) {
		super(engine,settings);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ???
	 * 
	 * @param event, event thrown
	 */
	@FXML
	private void OnChoice(ActionEvent event){
		if(((Button)event.getSource()).getId().equals("human")) settings.setCurrentPlayer(CharacterType.HUMANOID);
		else if(((Button)event.getSource()).getId().equals("monkey")) settings.setCurrentPlayer(CharacterType.BONZOID);
		else if(((Button)event.getSource()).getId().equals("flapper")) settings.setCurrentPlayer(CharacterType.FLAPPER);
		done();
	}
	
	/**
	 * ???
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	
}
