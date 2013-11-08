package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import edu.gatech.mule.fx.screens.views.FXSettingsView;

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
		two.setTextFill(FXSettingsView.NORMAL);
		three.setTextFill(FXSettingsView.NORMAL);
		four.setTextFill(FXSettingsView.NORMAL);
		
		switch(toggle) {
		case 0: two.setTextFill(FXSettingsView.SELECTED);
			break;
		case 1: three.setTextFill(FXSettingsView.SELECTED);
			break;
		case 2: four.setTextFill(FXSettingsView.SELECTED);
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
