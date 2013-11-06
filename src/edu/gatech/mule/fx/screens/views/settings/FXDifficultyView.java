package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class FXDifficultyView extends FXSettingsView {
	
	private final static Difficulty[] difficulties = Settings.Difficulty.values();
	
	private Settings settings;
	
	@FXML
	private Label beginner;
	@FXML
	private Label standard;
	@FXML
	private Label advanced;
	
	public FXDifficultyView() {
		super("difficulty");
		toggleMod = difficulties.length;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleSelected();
	}
	
	protected void toggleSelected() {
		beginner.setTextFill(Color.web(SettingsView.NORMAL));
		standard.setTextFill(Color.web(SettingsView.NORMAL));
		advanced.setTextFill(Color.web(SettingsView.NORMAL));
		switch(toggle) {
		case 0:
			beginner.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 1:
			standard.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 2:
			advanced.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		}
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
		toggle = 0;
	}
	
	@Override
	protected void done() {
		settings.setDifficulty(difficulties[toggle]);
		controller.done();
	}

	@Override
	public void render() {}

}
