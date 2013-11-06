package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for settings config
 */
public class FXNumPlayersView extends FXView implements SettingsView {
	
	@FXML
	private ComboBox<String> combo;
	@FXML
	private ToggleGroup mapType, numPlayers;
	private int playerCount;
	private Settings settings;
		
	/**
	 * Constructor for settings config screen
	 */
	public FXNumPlayersView() {
		super("num_players");
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerCount = 2;
	}
	
	@FXML
	public void transition(KeyEvent event){
		if (numPlayers.getSelectedToggle() != null && event.getCode() == KeyCode.SPACE) {
			if(((RadioButton)numPlayers.getSelectedToggle()).getId().equals("2")) {
				playerCount = 2;
			} else if(((RadioButton)numPlayers.getSelectedToggle()).getId().equals("3")) {
				playerCount = 3;
			} else if(((RadioButton)numPlayers.getSelectedToggle()).getId().equals("4")) {
				playerCount = 4;
			}
			
			settings.setMapType(MapType.DEFAULT);
			settings.setPlayerCount(playerCount);
			
			controller.done();
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
