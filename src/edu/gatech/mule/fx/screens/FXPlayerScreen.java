package edu.gatech.mule.fx.screens;


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
import edu.gatech.mule.fx.FXScreen;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.screen.screens.AbstractPlayerScreen;

/**
 * 
 * FX player screen
 * 
 * @version 1.0
 *
 */
public class FXPlayerScreen extends AbstractPlayerScreen implements Initializable, FXScreen {
	private static final String FXML_DIR = "/format/player_screen.fxml";
	private Node node;
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
		
	}
	
	@Override
	public void load() {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_DIR));
			loader.setController(this);
			node = (Pane)loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node getNode() {
		return node;
	}


	
	

}
