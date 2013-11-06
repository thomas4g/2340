package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for settings config
 */
public class FXNumPlayersView extends FXSettingsView {
	
	private final static int[] playerNums = {2,3,4};
	
	@FXML
	private Label two;
	@FXML
	private Label three;
	@FXML
	private Label four;
			
	/**
	 * Constructor for settings config screen
	 */
	public FXNumPlayersView() {
		super("num_players");
		toggleMod = playerNums.length;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleSelected();
	}
	
	protected void toggleSelected() {
		two.setTextFill(Color.web(SettingsView.NORMAL));
		three.setTextFill(Color.web(SettingsView.NORMAL));
		four.setTextFill(Color.web(SettingsView.NORMAL));
		
		switch(toggle) {
		case 0: two.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 1: three.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 2: four.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		}
	}
	
	protected void done() {
		settings.setPlayerCount(playerNums[toggle]);
		controller.done();
	}

	@Override
	public void render() {}
}
