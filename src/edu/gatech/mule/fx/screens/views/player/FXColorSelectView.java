package edu.gatech.mule.fx.screens.views.player;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for player config
 * @version 0.1
 */
public class FXColorSelectView extends FXSettingsView {
	
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
	public FXColorSelectView() {
		super("color_select");
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
	protected void scrollLeft() {
		toggle = mod(--toggle,NUM_COLORS);
		update();
	}
	
	@FXML
	protected void scrollRight() {
		toggle = mod(++toggle,NUM_COLORS);
		update();
	}
	
	protected void update() {
		greyedOrNotAll();
		switch(toggle) {
		case 0:
			purple.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 1:
			blue.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 2:
			teal.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 3:
			seafoam.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 4:
			green.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 5:
			gold.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 6:
			orange.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 7:
			maroon.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		}
		imgView.setImage(changeImage());
	}
	
	protected void done() {
		if(!settings.colorUsed(toggle+1)) {
			switch(toggle) {
			case 0: settings.getCurrentPlayer().setColor(Settings.Color.PURPLE);
				break;
			case 1: settings.getCurrentPlayer().setColor(Settings.Color.BLUE);
				break;
			case 2: settings.getCurrentPlayer().setColor(Settings.Color.TEAL);
				break;
			case 3: settings.getCurrentPlayer().setColor(Settings.Color.SEAFOAM);
				break;
			case 4: settings.getCurrentPlayer().setColor(Settings.Color.GREEN);
				break;
			case 5: settings.getCurrentPlayer().setColor(Settings.Color.GOLD);
				break;
			case 6: settings.getCurrentPlayer().setColor(Settings.Color.ORANGE);
				break;
			case 7: settings.getCurrentPlayer().setColor(Settings.Color.MAROON);
				break;
			}
			controller.done();
		}
	}
	
	private String grayedOrNot(int color) {
		if(settings.colorUsed(color)) {
			return SettingsView.GREYED;
		}
		return SettingsView.NORMAL;
	}
	
	private void greyedOrNotAll() {
		purple.setTextFill(Color.web(grayedOrNot(Settings.Color.PURPLE.ordinal()+1)));
		blue.setTextFill(Color.web(grayedOrNot(Settings.Color.BLUE.ordinal()+1)));
		teal.setTextFill(Color.web(grayedOrNot(Settings.Color.TEAL.ordinal()+1)));
		seafoam.setTextFill(Color.web(grayedOrNot(Settings.Color.SEAFOAM.ordinal()+1)));
		green.setTextFill(Color.web(grayedOrNot(Settings.Color.GREEN.ordinal()+1)));
		gold.setTextFill(Color.web(grayedOrNot(Settings.Color.GOLD.ordinal()+1)));
		orange.setTextFill(Color.web(grayedOrNot(Settings.Color.ORANGE.ordinal()+1)));
		maroon.setTextFill(Color.web(grayedOrNot(Settings.Color.MAROON.ordinal()+1)));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", choose your color");
		imgView.setImage(changeImage());
		
		greyedOrNotAll();
		
		purple.setTextFill(Color.web(SettingsView.SELECTED));
	}

	private Image changeImage() {
		return new Image(settings.getCurrentPlayer().getType().getHeadshot(toggle+1));
	}

	@Override
	public void render() {}
}
