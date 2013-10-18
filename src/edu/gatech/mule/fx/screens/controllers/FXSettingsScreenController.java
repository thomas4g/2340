package edu.gatech.mule.fx.screens.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.AbstractSettingsScreen;

/**
 * 
 * FX settings screen
 * 
 * @version 1.0
 *
 */
public class FXSettingsScreenController extends AbstractSettingsScreen implements Initializable {
	
	/**
	 * 
	 * ???
	 * 
	 * @param engine
	 * @param settings
	 * 
	 */
	public FXSettingsScreenController(GameEngine game) {
		super(game);
	}
	
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private ToggleGroup mapType, difficulty;
	
	private int playerCount;
	
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
		playerCount = 2;
	}
	
	public void onSelect(ActionEvent event) {
		playerCount = Integer.parseInt(combo.getValue());
	}
	
	/**
	 * 
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void onButtonClicked(ActionEvent event){
		if(((RadioButton)mapType.getSelectedToggle()).getId().equals("default"))
			settings.setMapType(MapType.DEFAULT);
		else if(((RadioButton)mapType.getSelectedToggle()).getId().equals("random"))
			settings.setMapType(MapType.RANDOM);
		
		if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("beginner"))
			settings.setDifficulty(Difficulty.BEGINNER);
		else if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("standard"))
			settings.setDifficulty(Difficulty.STANDARD);
		else if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("advanced"))
			settings.setDifficulty(Difficulty.ADVANCED);
		
		settings.setPlayerCount(playerCount);		
		done();
	}
	
	

}
