package edu.gatech.mule.fx.screens.views.player;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	private void scrollLeft(ActionEvent event) {
		pointer = mod(--pointer,raceScroll.length);
		update(event);
	}
	
	@FXML
	private void scrollRight(ActionEvent event) {
		pointer = mod(++pointer,raceScroll.length);
		update(event);
	}
	
	private void update(ActionEvent event) {
		if(((Label)event.getSource()).getId().equals("PlayerAnnouncer"))
			System.out.println("blah");
	}
	
	@FXML
	private void OnChoice(ActionEvent event){
		Player p = new Player(raceScroll[pointer]);
		p.setResources(settings.getDifficulty().getPlayerResources());
		settings.setCurrentPlayer(p);
		settings.addPlayer(p);
		controller.done();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}	
}
