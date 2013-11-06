package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class FXMapTypeView extends FXSettingsView {
	
	@FXML
	private Label defaultMap;
	@FXML
	private Label randomMap;
	
	private Settings settings;
	
	private int toggle;
	
	public FXMapTypeView() {
		super("map_type");
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
		toggle = 0;
	}
	
	@FXML
	protected void scrollLeft() {
		toggle = mod(--toggle,2);
		update();
	}
	
	@FXML
	protected void scrollRight() {
		toggle = mod(++toggle,2);
		update();
	}
	
	protected void update() {
		switch(toggle) {
		case 0:
			defaultMap.setTextFill(Color.web(SettingsView.SELECTED));
			randomMap.setTextFill(Color.web(SettingsView.NORMAL));
			break;
		case 1:
			randomMap.setTextFill(Color.web(SettingsView.SELECTED));
			defaultMap.setTextFill(Color.web(SettingsView.NORMAL));
			break;
		}
	}
	
	protected void done() {
		switch(toggle) {
		case 0:
			settings.setMapType(MapType.DEFAULT);
			break;
		case 1:
			settings.setMapType(MapType.RANDOM);
			break;
		}
		controller.done();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		defaultMap.setTextFill(Color.web(SettingsView.SELECTED));
	}

	@Override
	public void render() {}

}
