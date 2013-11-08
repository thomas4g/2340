package edu.gatech.mule.fx.screens.views.player;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Player;

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
		
		humanoid.setTextFill(FXSettingsView.NORMAL);
		flapper.setTextFill(FXSettingsView.NORMAL);
		bonzoid.setTextFill(FXSettingsView.NORMAL);
		
		switch(toggle) {
		case 0: humanoid.setTextFill(FXSettingsView.SELECTED);
			break;
		case 1: flapper.setTextFill(FXSettingsView.SELECTED);
			break;
		case 2: bonzoid.setTextFill(FXSettingsView.SELECTED);
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
