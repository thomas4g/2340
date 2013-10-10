package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.AbstractPlayerScreen;

public class FXPlayerScreen extends AbstractPlayerScreen implements Initializable {

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
	
	private Image changeImage(){
		String resourcePath="/assets/";
		System.out.println(currentColor.ordinal());
		if(settings.getCurrentPlayer().equals(CharacterType.HUMANOID)) resourcePath+="h" +(currentColor.ordinal()+1)+".png";
		else if(settings.getCurrentPlayer().equals(CharacterType.BONZOID)) resourcePath+="b" +(currentColor.ordinal()+1)+".png";
		else if(settings.getCurrentPlayer().equals(CharacterType.FLAPPER)) resourcePath+="f" +(currentColor.ordinal()+1)+".png";
		System.out.println(resourcePath);
		return new Image(resourcePath);
	}
	
	@FXML
	private void OnLoad(MouseEvent event){
		imgView.setImage(changeImage());
		charDescrip.setText(settings.getCurrentPlayer().descrip);
	}
	
	@FXML
	private void OnConfirm(ActionEvent event){
		if(combo.getValue()!=null){
			currentColor=Color.valueOf(combo.getValue().toString().toUpperCase());
			imgView.setImage(changeImage());
		}
		System.out.println(currentColor);
	}
	
	@FXML
	private void OnBack(ActionEvent event){
		nextPlayer();
	}
	//Goofy code I know
	@FXML
	private void OnAdd(ActionEvent event){
		if(settings.getPlayers().size()<settings.getPlayerCount()-1){
			settings.addPlayer(settings.getCurrentPlayer());
				nextPlayer();
			System.out.println(settings.getPlayers().size());
		}else{
			done();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//charDescrip.setText(settings.getCurrentPlayer().descrip);
	}
	
	

}
