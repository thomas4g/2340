package edu.gatech.mule.fx.screens.views.player;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class FXNameView extends FXView implements SettingsView {
	
	@FXML
	private TextField nameField;
	
	@FXML
	private Label playerAnnouncer;
	
	@FXML
	private ImageView headshot;
	
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
		if(event.getCode() == KeyCode.ENTER) {
			settings.getCurrentPlayer().setName(nameField.getText());
			settings.nextPlayer();
			controller.done();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", enter your name");
		headshot.setImage(new Image(settings.getCurrentPlayer().getType().getHeadshot(settings.getCurrentPlayer().getColor().ordinal()+1)));
		nameField.setText(settings.getCurrentPlayer().getType().getName());
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
