package edu.gatech.mule.fx.screens.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.controllers.RaceSelectController;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * 
 * FX race select screen
 * 
 * @version 1.0
 *
 */
public class FXRaceSelectView extends FXView implements SettingsView {

	protected Settings settings;
	
	public FXRaceSelectView() {
		super("race_select");
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
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
		settings.addPlayer(p);
		controller.dispose();
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
}
