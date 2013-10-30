package edu.gatech.mule.fx.screens.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for race select config
 * @version 0.1
 */
public class FXRaceSelectView extends FXView implements SettingsView {

	protected Settings settings;
	
	/**
	 * Constructor for race select screen
	 */
	public FXRaceSelectView() {
		super("race_select");
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
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
		p.setResources(settings.getDifficulty().getPlayerResources());
		settings.setCurrentPlayer(p);
		settings.addPlayer(p);
		controller.done();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}	
}
