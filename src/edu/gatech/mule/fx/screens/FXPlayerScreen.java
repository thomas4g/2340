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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Settings;
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
	public FXPlayerScreen(GameEngine engine, Settings settings) {
		super(engine, settings);
		// TODO Auto-generated constructor stub

	}
	
	@FXML
	private ComboBox combo;
	
	@FXML
	private ImageView imgView;
	
	@FXML
	private Label charDescrip;
	
	@FXML
	private TextField field;
	

	/**
	 * ???
	 */
	private Image changeImage(){
		String resourcePath="/assets/";
		System.out.println(currentColor.ordinal());
		if(settings.getCurrentPlayer().equals(CharacterType.HUMANOID)) resourcePath+="h" +(currentColor.ordinal()+1)+".png";
		else if(settings.getCurrentPlayer().equals(CharacterType.BONZOID)) resourcePath+="b" +(currentColor.ordinal()+1)+".png";
		else if(settings.getCurrentPlayer().equals(CharacterType.FLAPPER)) resourcePath+="f" +(currentColor.ordinal()+1)+".png";
		System.out.println(resourcePath);
		return new Image(resourcePath);
	}
	
	/**
	 * ???
	 */
	@FXML
	private void OnEnterPressed(KeyEvent event){
		if(event.getCode().equals(KeyCode.ENTER)) {
			settings.getCurrentPlayer().title=field.getText();
			System.out.println(settings.getCurrentPlayer().title);
		}
		
		
	}
	
	/**
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnLoad(MouseEvent event){
		imgView.setImage(changeImage());
		charDescrip.setText(settings.getCurrentPlayer().descrip);
		if(settings.getCurrentPlayer().equals(CharacterType.HUMANOID)) field.setText("Jimbo");
		else if(settings.getCurrentPlayer().equals(CharacterType.BONZOID)) field.setText("Colonel Mustard");
		else if(settings.getCurrentPlayer().equals(CharacterType.FLAPPER)) field.setText("Samantha");
		
	}
	
	/**
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnConfirm(ActionEvent event){
		if(combo.getValue()!=null){
			currentColor=Color.valueOf(combo.getValue().toString().toUpperCase());
			imgView.setImage(changeImage());
		}
		System.out.println(currentColor);
	}
	
	/**
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnBack(ActionEvent event){
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
		settings.addPlayer(settings.getCurrentPlayer());
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
		
	}
	
	

}
