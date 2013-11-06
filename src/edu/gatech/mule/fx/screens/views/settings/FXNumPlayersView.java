package edu.gatech.mule.fx.screens.views.settings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
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
		two.setTextFill(Color.web("#0076a3"));
	}
	
	@FXML
	private void scrollLeft() {
		playerCount = mod(--playerCount,3);
		update();
	}
	
	@FXML
	private void scrollRight() {
		playerCount = mod(++playerCount,3);
		update();
	}
	
	private void update() {
		switch(playerCount) {
		case 0:
			two.setTextFill(Color.web("#0076a3"));
			three.setTextFill(Color.web("#2F2F2F"));
			four.setTextFill(Color.web("#2F2F2F"));
			break;
		case 1:
			three.setTextFill(Color.web("#0076a3"));
			two.setTextFill(Color.web("#2F2F2F"));
			four.setTextFill(Color.web("#2F2F2F"));
			break;
		case 2:
			four.setTextFill(Color.web("#0076a3"));
			two.setTextFill(Color.web("#2F2F2F"));
			three.setTextFill(Color.web("#2F2F2F"));
			break;
		}
	}
	
	@FXML
	public void transition(KeyEvent event){
		if (event.getCode() == KeyCode.LEFT) {
			scrollLeft();
		} else if (event.getCode() == KeyCode.RIGHT) {
			scrollRight();
		} else if (event.getCode() == KeyCode.SPACE) {
			settings.setPlayerCount(playerCount+2);
			controller.done();
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
