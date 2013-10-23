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
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for settings config
 */
public class FXSettingsView extends FXView implements SettingsView {
	
	@FXML
	private ComboBox<String> combo;
	@FXML
	private ToggleGroup mapType, difficulty;
	private int playerCount;
	private Settings settings;
	
	/**
	 * Constructor for settings config screen
	 */
	public FXSettingsView() {
		super("settings");
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
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
		controller.done();
	}
}
