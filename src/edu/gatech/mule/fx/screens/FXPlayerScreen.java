package edu.gatech.mule.fx.screens;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.screen.screens.AbstractPlayerScreen;

/**
 * 
 * FX player screen
 * 
 * @version 1.0
 *
 */
public class FXPlayerScreen extends AbstractPlayerScreen implements Initializable {

	/**
	 * 
	 * ???
	 * 
	 * @param engine
	 * @param settings
	 * 
	 */
	public FXPlayerScreen(GameEngine game) {
		super(game);
		// TODO Auto-generated constructor stub

	}
	
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private ImageView imgView;
	
	@FXML
	private Label charDescrip;
	
	@FXML
	private TextField field;
	
	private Color currentColor = Color.PURPLE;

	/**
	 * ???
	 */
	private Image changeImage(){
		return new Image(settings.getCurrentPlayer().getType().getResPrefix() + (currentColor.ordinal()+1) + ".png");
	}
	
	@FXML
	private void onSelect(ActionEvent event) {
		if(combo.getValue() != null) {
			currentColor = Color.valueOf(combo.getValue().toString().toUpperCase());
			imgView.setImage(changeImage());
		}
	}
	
	/**
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnBack(ActionEvent event) {
		settings.getPlayers().remove(settings.getCurrentPlayer());
		nextPlayer();
	}
	
	/**
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnAdd(ActionEvent event){
		settings.getCurrentPlayer().setColor(currentColor);
		settings.getCurrentPlayer().setName(field.getText());
		if(settings.getPlayerCount() == settings.getPlayers().size()) {
			done();
		} else {
			nextPlayer();
		}
	}
	
	/**
	 * ???
	 * 
	 * @param location
	 * @param resources
	 * 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imgView.setImage(changeImage());
		charDescrip.setText(settings.getCurrentPlayer().getType().getDescripion());
		field.setText(settings.getCurrentPlayer().getType().getDefaultName());
	}
	
	

}
