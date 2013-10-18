package edu.gatech.mule.fx.screens.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.AbstractRaceSelectScreen;

/**
 * 
 * FX race select screen
 * 
 * @version 1.0
 *
 */
public class FXRaceSelectScreenController extends AbstractRaceSelectScreen implements Initializable {

	/**
	 * 
	 * ???
	 * 
	 * @param engine
	 * @param settings
	 * 
	 */
	public FXRaceSelectScreenController(GameEngine game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnChoice(ActionEvent event){
		CharacterType c = null;
		if(((Button)event.getSource()).getId().equals("flapper"))
			c = CharacterType.FLAPPER;
		if(((Button)event.getSource()).getId().equals("bonzoid"))
			c = CharacterType.BONZOID;
		if(((Button)event.getSource()).getId().equals("humanoid"))
			c = CharacterType.HUMANOID;
		
		Player p = new Player(c);
		settings.setCurrentPlayer(p);
		settings.addPlayer(p);
		done();
	}
	
	/**
	 * 
	 * ???
	 * 
	 * @param location
	 * @param resources
	 * 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	
}
