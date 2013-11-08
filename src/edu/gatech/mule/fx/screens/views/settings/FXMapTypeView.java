package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.MapType;

public class FXMapTypeView extends FXSettingsView {
	
	private static MapType[] mapTypes = Settings.MapType.values();
	
	@FXML
	private Label defaultMap;
	@FXML
	private Label randomMap;
			
	public FXMapTypeView() {
		super("map_type");
		toggleMod = mapTypes.length;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleSelected();
	}
	
	protected void toggleSelected() {
		switch(toggle) {
		case 0:
			defaultMap.setTextFill(FXSettingsView.SELECTED);
			randomMap.setTextFill(FXSettingsView.NORMAL);
			break;
		case 1:
			randomMap.setTextFill(FXSettingsView.SELECTED);
			defaultMap.setTextFill(FXSettingsView.NORMAL);
			break;
		}
	}
	
	protected void done() {
		settings.setMapType(mapTypes[toggle]);
		controller.done();
	}

	@Override
	public void render() {}

}
