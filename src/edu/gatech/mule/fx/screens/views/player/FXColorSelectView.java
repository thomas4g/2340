package edu.gatech.mule.fx.screens.views.player;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import edu.gatech.mule.game.player.Color;
import edu.gatech.mule.fx.screens.views.FXSettingsView;

/**
 * View for player color config
 * @version 1.0
 */
public class FXColorSelectView extends FXSettingsView {
	
	private final static Random randy = new Random();
	private final static Color[] colors = Color.values();
	
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
	 * Constructor for player color select screen
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
	
	@Override
	protected void toggleSelected() {
		greyedOrNotAll();
		colorLabels[toggle].setTextFill(FXSettingsView.SELECTED);
		imgView.setImage(new Image(settings.getCurrentPlayerHeadshot(toggle+1)));
	}
	
	@Override
	protected void done() {
		if (!settings.colorUsed(toggle+1)) {
			settings.setCurrentPlayerColor(colors[toggle]);
			settings.addColor(colors[toggle]);
			controller.done();
		}
	}
	
	/**
	 * Returns color that corresponds to whether color is already used or not
	 * @param color, color of player config
	 * @return JavaFX text color based on whether color is already used or not
	 */
	private javafx.scene.paint.Color grayedOrNot(int color) {
		if(settings.colorUsed(color)) {
			return FXSettingsView.GREYED;
		}
		return FXSettingsView.NORMAL;
	}
	
	/**
	 * Sets text colors of all toggles based on whether corresponding
	 * colors were already selected or not
	 */
	private void greyedOrNotAll() {
		int i = 0;
		for(Label label : colorLabels) {
			label.setTextFill(grayedOrNot(colors[i++].ordinal()+1));
		}
	}

	@Override
	public void render() {}
}
