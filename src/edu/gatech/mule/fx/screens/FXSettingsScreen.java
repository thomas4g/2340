package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.AbstractSettingsScreen;

public class FXSettingsScreen extends AbstractSettingsScreen implements Initializable {
	
	public FXSettingsScreen(GameEngine engine, Settings settings) {
		super(engine, settings);
	}
	
	@FXML
	private ComboBox combo;
	
	@FXML
	private ToggleGroup mapType, difficulty;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	
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
		
		if(combo.getValue()!=null) settings.updatePlayerCount(Integer.parseInt(combo.getValue().toString()));
		System.out.println(settings.getPlayerCount());
		done();
	}
	
	

}
