package edu.gatech.mule.fx.screens.views.player;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

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
	
	private final static Random randy = new Random();
	private final static Settings.Color[] colors = Settings.Color.values();
	
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
	
	@FXML
	private Label[] colorLabels;
		
	/**
	 * Constructor for player screen
	 */
	public FXColorSelectView() {
		super("color_select");
		toggleMod = colors.length;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggle = randy.nextInt(colors.length);
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", choose your color");
		imgView.setImage(new Image(settings.getCurrentPlayerHeadshot(toggle+1)));
		colorLabels = new Label[]{purple,blue,teal,seafoam,green,gold,orange,maroon};
		
		toggleSelected();
	}
	
	protected void toggleSelected() {
		greyedOrNotAll();
		colorLabels[toggle].setTextFill(Color.web(SettingsView.SELECTED));
		imgView.setImage(new Image(settings.getCurrentPlayerHeadshot(toggle+1)));
	}
	
	protected void done() {
		if(!settings.colorUsed(toggle+1)) {
			settings.setCurrentPlayerColor(colors[toggle]);
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
		int i = 0;
		for(Label label : colorLabels) {
			label.setTextFill(Color.web(grayedOrNot(colors[i++].ordinal()+1)));
		}
	}

	@Override
	public void render() {}
}
