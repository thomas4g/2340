package edu.gatech.mule.fx.screens.views;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.screen.screens.controllers.*;

/**
 * 
 * FX player screen
 * 
 * @version 1.0
 *
 */
public class FXPlayerView extends FXView {
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private ImageView imgView;
	
	@FXML
	private Label charDescrip;
	
	@FXML
	private TextField field;
	
	private Color currentColor = Color.PURPLE;
	private PlayerController controller;

	public FXPlayerView() {
		super("player_screen");
	}

	@Override
	public void setController(ScreenController controller) {
		super.setController(controller);
		this.controller = (PlayerController)controller;
	}
	
	/**
	 * ???
	 */
	private Image changeImage(){
		return new Image(controller.getSettings().getCurrentPlayer().getType().getHeadshot() + (currentColor.ordinal()+1) + CharacterType.IMAGE_EXT);
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
		controller.getSettings().getPlayers().remove(controller.getSettings().getCurrentPlayer());
		controller.nextPlayer();
	}
	
	/**
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnAdd(ActionEvent event){
		controller.getSettings().getCurrentPlayer().setColor(currentColor);
		controller.getSettings().getCurrentPlayer().setName(field.getText());
		if(controller.getSettings().getPlayerCount() == controller.getSettings().getPlayers().size()) {
			controller.dispose();
		} else {
			controller.nextPlayer();
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
		charDescrip.setText(controller.getSettings().getCurrentPlayer().getType().getDescripion());
		field.setText(controller.getSettings().getCurrentPlayer().getType().getName());
	}
}
