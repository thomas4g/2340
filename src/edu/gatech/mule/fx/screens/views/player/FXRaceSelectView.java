package edu.gatech.mule.fx.screens.views.player;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * View for race select config
 * @version 0.1
 */
public class FXRaceSelectView extends FXView implements SettingsView {
	
	private static Random randy = new Random();
	
	@FXML
	private ImageView headshot;
	
	@FXML
	private Label playerAnnouncer;
	@FXML
	private Label description;
	@FXML
	private Label raceName;

	protected Settings settings;
	private CharacterType[] raceScroll;
	private int pointer;
	
	/**
	 * Constructor for race select screen
	 */
	public FXRaceSelectView() {
		super("race_select");
		raceScroll = new CharacterType[]{CharacterType.HUMANOID,CharacterType.FLAPPER, CharacterType.BONZOID};
		pointer = randy.nextInt(raceScroll.length);
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	@FXML
	private void scrollLeft() {
		pointer = mod(--pointer,raceScroll.length);
		update();
	}
	
	@FXML
	private void scrollRight() {
		pointer = mod(++pointer,raceScroll.length);
		update();
	}
	
	private void update() {
		raceName.setText(raceScroll[pointer].getType());
		headshot.setImage(new Image(raceScroll[pointer].getHeadshot(1)));
		description.setText(raceScroll[pointer].getDescripion());
	}
	
	@FXML
	private void transition(KeyEvent event) {
		if(event.getCode()==KeyCode.LEFT || event.getCode()==KeyCode.UP) {
			scrollLeft();
		} else if(event.getCode() == KeyCode.RIGHT || event.getCode()==KeyCode.DOWN) {
			scrollRight();
		} else if(event.getCode() == KeyCode.SPACE) {
			Player p = new Player(raceScroll[pointer]);
			pointer = randy.nextInt(raceScroll.length);
			p.setResources(settings.getDifficulty().getPlayerResources());
			settings.setCurrentPlayer(p);
			settings.addPlayer(p);
			controller.done();	
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", choose your race");
		raceName.setText(raceScroll[pointer].getType());
		headshot.setImage(new Image(raceScroll[pointer].getHeadshot(1)));
		description.setText(raceScroll[pointer].getDescripion());
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}	
}
