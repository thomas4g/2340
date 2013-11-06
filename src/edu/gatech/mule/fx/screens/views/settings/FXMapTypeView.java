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

public class FXMapTypeView extends FXView implements SettingsView {
	
	@FXML
	private ToggleGroup mapType;
	private Settings settings;
	
	public FXMapTypeView() {
		super("map_type");
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	@FXML
	public void transition(KeyEvent event){
		if (mapType.getSelectedToggle() != null && event.getCode() == KeyCode.SPACE) {
			if(((RadioButton)mapType.getSelectedToggle()).getId().equals("default"))
				settings.setMapType(MapType.DEFAULT);
			else if(((RadioButton)mapType.getSelectedToggle()).getId().equals("random"))
				settings.setMapType(MapType.RANDOM);
			
			controller.done();
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
