package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class FXDifficultyView extends FXView implements SettingsView {
	
	private Settings settings;
	
	@FXML
	private Label beginner;
	@FXML
	private Label standard;
	@FXML
	private Label advanced;
	
	private int toggle;

	public FXDifficultyView() {
		super("difficulty");
		toggle = 0;
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	@FXML
	private void scrollLeft() {
		toggle = mod(--toggle,3);
		update();
	}
	
	@FXML
	private void scrollRight() {
		toggle = mod(++toggle,3);
		update();
	}
	
	private void update() {
		switch(toggle) {
		case 0:
			beginner.setTextFill(Color.web("#0076a3"));
			standard.setTextFill(Color.web("#2F2F2F"));
			advanced.setTextFill(Color.web("#2F2F2F"));
			break;
		case 1:
			standard.setTextFill(Color.web("#0076a3"));
			beginner.setTextFill(Color.web("#2F2F2F"));
			advanced.setTextFill(Color.web("#2F2F2F"));
			break;
		case 2:
			advanced.setTextFill(Color.web("#0076a3"));
			beginner.setTextFill(Color.web("#2F2F2F"));
			standard.setTextFill(Color.web("#2F2F2F"));
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
				settings.setDifficulty(Difficulty.BEGINNER);
				break;
			case 1:
				settings.setDifficulty(Difficulty.STANDARD);
				break;
			case 2:
				settings.setDifficulty(Difficulty.ADVANCED);
				break;
			}
			controller.done();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		beginner.setTextFill(Color.web("#0076a3"));
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
