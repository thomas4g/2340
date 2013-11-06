package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class FXMapTypeView extends FXView implements SettingsView {
	
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
	private void scrollLeft() {
		toggle = mod(--toggle,2);
		update();
	}
	
	@FXML
	private void scrollRight() {
		toggle = mod(++toggle,2);
		update();
	}
	
	private void update() {
		switch(toggle) {
		case 0:
			defaultMap.setTextFill(Color.web("#0076a3"));
			randomMap.setTextFill(Color.web("#2F2F2F"));
			break;
		case 1:
			randomMap.setTextFill(Color.web("#0076a3"));
			defaultMap.setTextFill(Color.web("#2F2F2F"));
			break;
		}
	}
	
	@FXML
	public void transition(KeyEvent event){
		if (event.getCode() == KeyCode.LEFT) {
			scrollLeft();
		} else if (event.getCode() == KeyCode.RIGHT) {
			scrollRight();
		} else if (event.getCode() == KeyCode.SPACE) {
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
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		defaultMap.setTextFill(Color.web("#0076a3"));
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
