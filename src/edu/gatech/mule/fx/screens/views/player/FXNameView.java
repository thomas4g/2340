package edu.gatech.mule.fx.screens.views.player;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class FXNameView extends FXView implements SettingsView {
	
	@FXML
	private TextField nameField;
	
	private Settings settings;

	public FXNameView() {
		super("name");
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	@FXML
	private void transition(KeyEvent event){
		if(event.getCode() == KeyCode.SPACE) {
			settings.getCurrentPlayer().setName(nameField.getText());
			settings.nextPlayer();
			controller.done();
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
