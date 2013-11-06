package edu.gatech.mule.fx.screens.views.player;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	
	@FXML
	private ImageView headshot;
	
	@FXML
	private Label description;

	protected Settings settings;
	private CharacterType[] raceScroll;
	private int pointer;
	
	/**
	 * Constructor for race select screen
	 */
	public FXRaceSelectView() {
		super("race_select");
		raceScroll = new CharacterType[]{CharacterType.HUMANOID,CharacterType.FLAPPER, CharacterType.BONZOID};
		pointer = 0;
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	private int mod(int cheese, int knife) {
		int mod = cheese % knife;
		if(mod < 0) {
			mod += knife;
		}
		return mod;
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
		headshot.setImage(new Image(raceScroll[pointer].getHeadshot(1)));
		description.setText(raceScroll[pointer].getDescripion());
		System.out.println(raceScroll[pointer].getName());
	}
	
	@FXML
	private void transition(KeyEvent event) {
		if(event.getCode() == KeyCode.LEFT) {
			scrollLeft();
		} else if(event.getCode() == KeyCode.RIGHT) {
			scrollRight();
		} else if(event.getCode() == KeyCode.SPACE) {
			Player p = new Player(raceScroll[pointer]);
			p.setResources(settings.getDifficulty().getPlayerResources());
			settings.setCurrentPlayer(p);
			settings.addPlayer(p);
			controller.done();	
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		headshot.setImage(new Image(raceScroll[pointer].getHeadshot(1)));
		description.setText(raceScroll[pointer].getDescripion());
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}	
}
