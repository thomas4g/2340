package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.AbstractPlayerScreen;

public class FXPlayerScreen extends AbstractPlayerScreen implements Initializable {

	public FXPlayerScreen(GameEngine engine, Settings settings) {
		super(engine, settings);
		// TODO Auto-generated constructor stub
	}

	public Image getHeadShot(){
		String resourcePath="/assets/";
		String path=resourcePath;
		if(settings.getCurrentPlayer().equals(CharacterType.HUMANOID)) path+="h"+currentColor.ordinal()+1+".png";
		if(settings.getCurrentPlayer().equals(CharacterType.BONZOID)) path+="b"+currentColor.ordinal()+1+".png";
		if(settings.getCurrentPlayer().equals(CharacterType.FLAPPER)) path+="f"+currentColor.ordinal()+1+".png";
		return new Image(path);
	}
	
	@FXML
	private void OnBack(ActionEvent event){
		nextPlayer();
	}
	//Goofy code I know
	@FXML
	private void OnAdd(ActionEvent event){
		if(settings.getPlayers().size()!=settings.getPlayerCount()){
			settings.addPlayer(settings.getCurrentPlayer());
				nextPlayer();
			System.out.println(settings.getPlayers().size());
		}else{
			done();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

}
