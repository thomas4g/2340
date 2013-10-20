package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.FXScreen;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.AbstractRaceSelectScreen;

/**
 * 
 * FX race select screen
 * 
 * @version 1.0
 *
 */
public class FXRaceSelectScreen extends AbstractRaceSelectScreen implements Initializable, FXScreen {
	private static final String FXML_DIR = "/format/race_select.fxml";
	private Node node;
	/**
	 * 
	 * ???
	 * 
	 * @param engine
	 * @param settings
	 * 
	 */
	public FXRaceSelectScreen(GameEngine game) {
		super(game);
	}
	
	public void load() {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_DIR));
			loader.setController(this);
			node = (Pane)loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * ???
	 * 
	 * @param event
	 * 
	 */
	@FXML
	private void OnChoice(ActionEvent event){
		CharacterType c = null;
		if(((Button)event.getSource()).getId().equals("flapper"))
			c = CharacterType.FLAPPER;
		if(((Button)event.getSource()).getId().equals("bonzoid"))
			c = CharacterType.BONZOID;
		if(((Button)event.getSource()).getId().equals("humanoid"))
			c = CharacterType.HUMANOID;
		
		Player p = new Player(c);
		settings.setCurrentPlayer(p);
		settings.addPlayer(p);
		done();
	}
	
	/**
	 * 
	 * ???
	 * 
	 * @param location
	 * @param resources
	 * 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return node;
	}

	
	
}
