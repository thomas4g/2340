package edu.gatech.mule.fx.screens.views.settings;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class FXDifficultyView extends FXView implements SettingsView {
	
	@FXML
	private ToggleGroup difficulty;
	private Settings settings;

	public FXDifficultyView() {
		super("difficulty");
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	@FXML
	public void transition(KeyEvent event){
		if (difficulty.getSelectedToggle() != null && event.getCode() == KeyCode.SPACE) {
			if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("beginner"))
				settings.setDifficulty(Difficulty.BEGINNER);
			else if(((RadioButton)difficulty.getSelectedToggle()).getId().equals("standard"))
				settings.setDifficulty(Difficulty.STANDARD);
			
			controller.done();
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
