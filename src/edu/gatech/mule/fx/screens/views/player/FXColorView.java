package edu.gatech.mule.fx.screens.views.player;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for player config
 * @version 0.1
 */
public class FXColorView extends FXView implements SettingsView {
	
	@FXML
	private Label playerAnnouncer;
	@FXML
	private ImageView imgView;
	
	@FXML
	private Label purple;
	@FXML
	private Label blue;
	@FXML
	private Label teal;
	@FXML
	private Label seafoam;
	@FXML
	private Label green;
	@FXML
	private Label gold;
	@FXML
	private Label orange;
	@FXML
	private Label maroon;
	
	private Settings settings;
	private int toggle;
	private final static int NUM_COLORS = 8;

	/**
	 * Constructor for player screen
	 */
	public FXColorView() {
		super("color");
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
		toggle = 0;
	}
	
	@FXML
	private void OnBack(ActionEvent event) {
		settings.getPlayers().remove(settings.getCurrentPlayer());

		controller.done();
	}
	
	@FXML
	private void scrollLeft() {
		toggle = mod(--toggle,NUM_COLORS);
		update();
	}
	
	@FXML
	private void scrollRight() {
		toggle = mod(++toggle,NUM_COLORS);
		update();
	}
	
	private void update() {
		switch(toggle) {
		case 0:
			purple.setTextFill(Color.web("#0076a3"));
			maroon.setTextFill(Color.web("#2F2F2F"));
			blue.setTextFill(Color.web("#2F2F2F"));
			break;
		case 1:
			blue.setTextFill(Color.web("#0076a3"));
			teal.setTextFill(Color.web("#2F2F2F"));
			purple.setTextFill(Color.web("#2F2F2F"));
			break;
		case 2:
			teal.setTextFill(Color.web("#0076a3"));
			seafoam.setTextFill(Color.web("#2F2F2F"));
			blue.setTextFill(Color.web("#2F2F2F"));
			break;
		case 3:
			seafoam.setTextFill(Color.web("#0076a3"));
			green.setTextFill(Color.web("#2F2F2F"));
			teal.setTextFill(Color.web("#2F2F2F"));
			break;
		case 4:
			green.setTextFill(Color.web("#0076a3"));
			gold.setTextFill(Color.web("#2F2F2F"));
			seafoam.setTextFill(Color.web("#2F2F2F"));
			break;
		case 5:
			gold.setTextFill(Color.web("#0076a3"));
			orange.setTextFill(Color.web("#2F2F2F"));
			green.setTextFill(Color.web("#2F2F2F"));
			break;
		case 6:
			orange.setTextFill(Color.web("#0076a3"));
			maroon.setTextFill(Color.web("#2F2F2F"));
			gold.setTextFill(Color.web("#2F2F2F"));
			break;
		case 7:
			maroon.setTextFill(Color.web("#0076a3"));
			purple.setTextFill(Color.web("#2F2F2F"));
			orange.setTextFill(Color.web("#2F2F2F"));
			break;
		}
		imgView.setImage(changeImage());
	}
	
	@FXML
	private void transition(KeyEvent event){
		if(event.getCode() == KeyCode.UP) {
			scrollLeft();
		} else if(event.getCode() == KeyCode.DOWN) {
			scrollRight();
		} else if(event.getCode() == KeyCode.SPACE) {
			switch(toggle) {
			case 0:
				settings.getCurrentPlayer().setColor(Settings.Color.PURPLE);
				break;
			case 1:
				settings.getCurrentPlayer().setColor(Settings.Color.BLUE);
				break;
			case 2:
				settings.getCurrentPlayer().setColor(Settings.Color.TEAL);
				break;
			case 3:
				settings.getCurrentPlayer().setColor(Settings.Color.SEAFOAM);
				break;
			case 4:
				settings.getCurrentPlayer().setColor(Settings.Color.GREEN);
				break;
			case 5:
				settings.getCurrentPlayer().setColor(Settings.Color.GOLD);
				break;
			case 6:
				settings.getCurrentPlayer().setColor(Settings.Color.ORANGE);
				break;
			case 7:
				settings.getCurrentPlayer().setColor(Settings.Color.MAROON);
				break;
			}
			controller.done();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", choose your color");
		imgView.setImage(changeImage());
		purple.setTextFill(Color.web("#0076a3"));
		//charDescrip.setText(settings.getCurrentPlayer().getType().getDescripion());
	}

	private Image changeImage() {
		return new Image(settings.getCurrentPlayer().getType().getHeadshot(toggle+1));
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
