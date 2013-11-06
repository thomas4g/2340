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
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for race select config
 * @version 0.1
 */
public class FXRaceSelectView extends FXSettingsView {
	
	protected final static CharacterType[] raceScroll = 
			new CharacterType[]{CharacterType.HUMANOID,CharacterType.FLAPPER, CharacterType.BONZOID};
	private static Random randy = new Random();
	
	@FXML
	private ImageView headshot;
	
	@FXML
	private Label humanoid;
	@FXML
	private Label flapper;
	@FXML
	private Label bonzoid;
	
	@FXML
	private Label playerAnnouncer;
	@FXML
	private Label description;
	@FXML
	private Label raceName;
	
	/**
	 * Constructor for race select screen
	 */
	public FXRaceSelectView() {
		super("race_select");
		toggleMod = raceScroll.length;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggle = randy.nextInt(raceScroll.length);
		
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", choose your race");
		toggleSelected();
	}
	
	protected void toggleSelected() {
		raceName.setText(raceScroll[toggle].getType());
		headshot.setImage(new Image(raceScroll[toggle].getHeadshot(1)));
		description.setText(raceScroll[toggle].getDescripion());
		
		humanoid.setTextFill(Color.web(SettingsView.NORMAL));
		flapper.setTextFill(Color.web(SettingsView.NORMAL));
		bonzoid.setTextFill(Color.web(SettingsView.NORMAL));
		
		switch(toggle) {
		case 0: humanoid.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 1: flapper.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 2: bonzoid.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		}
	}
	
	protected void done() {
		Player p = new Player(raceScroll[toggle]);
		toggle = randy.nextInt(raceScroll.length);
		p.setResources(settings.getDifficulty().getPlayerResources());
		settings.setCurrentPlayer(p);
		settings.addPlayer(p);
		controller.done();
	}

	@Override
	public void render() {}	
}
