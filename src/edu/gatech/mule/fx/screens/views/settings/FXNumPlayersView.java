package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for settings config
 */
public class FXNumPlayersView extends FXSettingsView {
	
	@FXML
	private Label two;
	@FXML
	private Label three;
	@FXML
	private Label four;
	
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
		two.setTextFill(Color.web(SettingsView.SELECTED));
	}
	
	@FXML
	protected void scrollLeft() {
		playerCount = mod(--playerCount,3);
		update();
	}
	
	@FXML
	protected void scrollRight() {
		playerCount = mod(++playerCount,3);
		update();
	}
	
	protected void update() {
		two.setTextFill(Color.web("#2F2F2F"));
		three.setTextFill(Color.web("#2F2F2F"));
		four.setTextFill(Color.web("#2F2F2F"));
		
		switch(playerCount) {
		case 0: two.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 1: three.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 2: four.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		}
	}
	
	protected void done() {
		settings.setPlayerCount(playerCount+2);
		controller.done();
	}

	@Override
	public void render() {}
}
