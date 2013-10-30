package edu.gatech.mule.fx.screens.views;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for player config
 * @version 0.1
 */
public class FXPlayerView extends FXView implements SettingsView {
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private ImageView imgView;
	
	@FXML
	private Label charDescrip;
	
	@FXML
	private TextField field;
	
	private Color currentColor = Color.PURPLE;
	private Settings settings;

	/**
	 * Constructor for player screen
	 */
	public FXPlayerView() {
		super("player_screen");
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	/**
	 * Change headshot image
	 * @return next headshot image
	 */
	private Image changeImage(){
		return new Image(settings.getCurrentPlayer().getType().getHeadshot(currentColor.ordinal()+1));
	}
	
	@FXML
	private void onSelect(ActionEvent event) {
		if(combo.getValue() != null) {
			currentColor = Color.valueOf(combo.getValue().toString().toUpperCase());
			imgView.setImage(changeImage());
		}
	}
	
	@FXML
	private void OnBack(ActionEvent event) {
		settings.getPlayers().remove(settings.getCurrentPlayer());

		controller.done();
	}
	
	@FXML
	private void OnAdd(ActionEvent event){
		settings.getCurrentPlayer().setColor(currentColor);
		settings.getCurrentPlayer().setName(field.getText());
		controller.done();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imgView.setImage(changeImage());
		charDescrip.setText(settings.getCurrentPlayer().getType().getDescripion());
		field.setText(settings.getCurrentPlayer().getType().getName());
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
