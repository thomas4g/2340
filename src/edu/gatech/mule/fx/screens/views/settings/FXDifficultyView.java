package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.player.Difficulty;

public class FXDifficultyView extends FXSettingsView {
	
	private final static Difficulty[] difficulties = Difficulty.values();
	
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
		beginner.setTextFill(FXSettingsView.NORMAL);
		standard.setTextFill(FXSettingsView.NORMAL);
		advanced.setTextFill(FXSettingsView.NORMAL);
		switch(toggle) {
		case 0:
			beginner.setTextFill(FXSettingsView.SELECTED);
			break;
		case 1:
			standard.setTextFill(FXSettingsView.SELECTED);
			break;
		case 2:
			advanced.setTextFill(FXSettingsView.SELECTED);
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
