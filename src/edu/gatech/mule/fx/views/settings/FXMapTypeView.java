package edu.gatech.mule.fx.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import edu.gatech.mule.fx.views.FXSettingsView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.MapType;

/**
 * View for screen to set map type
 * @version 1.0
 */
public class FXMapTypeView extends FXSettingsView {
	
	private static MapType[] mapTypes = Settings.MapType.values();
	
	@FXML
	private Label defaultMap;
	@FXML
	private Label randomMap;
	
	/**
	 * Constructor for map type select view
	 */
	public FXMapTypeView() {
		super("map_type");
		toggleMod = mapTypes.length;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleSelected();
	}
	
	@Override
	protected void toggleSelected() {
		switch (toggle) {
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
	
	@Override
	protected void done() {
		settings.setMapType(mapTypes[toggle]);
		controller.done();
	}

	@Override
	public void render() {}

}
