package edu.gatech.mule.fx.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import edu.gatech.mule.fx.views.FXSettingsView;

/**
 * View for screen to set number of players.
 * @version 1.0
 */
public class FXNumPlayersView extends FXSettingsView {

	private static final int[] PLAYER_NUMS = {2, 3, 4};

	@FXML
	private Label two;
	@FXML
	private Label three;
	@FXML
	private Label four;

	/**
	 * Constructor for settings config screen.
	 */
	public FXNumPlayersView() {
		super("num_players");
		toggleMod = PLAYER_NUMS.length;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleSelected();
	}

	@Override
	protected void toggleSelected() {
		two.setTextFill(FXSettingsView.NORMAL);
		three.setTextFill(FXSettingsView.NORMAL);
		four.setTextFill(FXSettingsView.NORMAL);

		switch (toggle) {
		case 0: two.setTextFill(FXSettingsView.SELECTED);
			break;
		case 1: three.setTextFill(FXSettingsView.SELECTED);
			break;
		case 2: four.setTextFill(FXSettingsView.SELECTED);
			break;
		default:
			break;
		}
	}

	@Override
	protected void done() {
		settings.setPlayerCount(PLAYER_NUMS[toggle]);
		controller.done();
	}

	@Override
	public void render() { }

}
