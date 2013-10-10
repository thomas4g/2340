package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	
	//Blah blah single cases (will fix later)
	@FXML
	private void OnClick(ActionEvent event){
		if(((CheckBox)event.getSource()).getId().equals("beginner")) settings.setDifficulty(Difficulty.BEGINNER);
		else if(((CheckBox)event.getSource()).getId().equals("intermediate")) settings.setDifficulty(Difficulty.INTERMEDIATE);
		else if(((CheckBox)event.getSource()).getId().equals("advanced")) settings.setDifficulty(Difficulty.ADVANCED);
		else if(((CheckBox)event.getSource()).getId().equals("standard")) settings.setMapType(MapType.STANDARD);
		else if(((CheckBox)event.getSource()).getId().equals("random")) settings.setMapType(MapType.RANDOM);
		else return;
	}
	
	@FXML
	private void onButtonClicked(ActionEvent event){
		if(combo.getValue()!=null) settings.updatePlayerCount(Integer.parseInt(combo.getValue().toString()));
		System.out.println(settings.getPlayerCount());
		done();
	}
	
	

}
