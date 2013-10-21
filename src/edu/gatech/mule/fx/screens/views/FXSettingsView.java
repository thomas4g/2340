package edu.gatech.mule.fx.screens.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.controllers.SettingsController;

/**
 * 
 * FX settings screen
 * 
 * @version 1.0
 *
 */
public class FXSettingsView extends FXView implements Initializable {
	@FXML
	private ComboBox<String> combo;
	@FXML
	private ToggleGroup mapType, difficulty;
	private int playerCount;
	private SettingsController controller;
	
	public FXSettingsView() {
		super("settings");
	}
	
	@Override
	public void setController(ScreenController controller) {
		super.setController(controller);
		this.controller = (SettingsController)controller;
	}
	
	/**
	 * initializes view
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerCount = 2;
	}
	
	public void onSelect(ActionEvent event) {
		playerCount = Integer.parseInt(combo.getValue());
	}
	
	@FXML
	public void onButtonClicked(ActionEvent event){
		if(((RadioButton)mapType.getSelectedToggle()).getId().equals("default"))
			controller.getSettings().setMapType(MapType.DEFAULT);
		else if(((RadioButton)mapType.getSelectedToggle()).getId().equals("random"))
			controller.getSettings().setMapType(MapType.RANDOM);
		
		if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("beginner"))
			controller.getSettings().setDifficulty(Difficulty.BEGINNER);
		else if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("standard"))
			controller.getSettings().setDifficulty(Difficulty.STANDARD);
		else if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("advanced"))
			controller.getSettings().setDifficulty(Difficulty.ADVANCED);
		
		controller.getSettings().setPlayerCount(playerCount);		
		controller.dispose();
	}
}
