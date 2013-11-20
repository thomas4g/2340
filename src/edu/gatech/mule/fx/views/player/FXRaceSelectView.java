package edu.gatech.mule.fx.views.player;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import edu.gatech.mule.fx.views.FXSettingsView;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Player;

/**
 * View for race select config.
 * @version 1.0
 */
public class FXRaceSelectView extends FXSettingsView {

	protected static final  CharacterType[] RACE_SCROLL =
			new CharacterType[]{CharacterType.HUMANOID,
								CharacterType.FLAPPER,
								CharacterType.BONZOID};
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
	 * Constructor for race select screen.
	 */
	public FXRaceSelectView() {
		super("race_select");
		toggleMod = RACE_SCROLL.length;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggle = randy.nextInt(RACE_SCROLL.length);
		playerAnnouncer.setText("Player "
				+ settings.getPlayerIndex()
				+ ", choose your race");
		toggleSelected();
	}

	@Override
	protected void toggleSelected() {
		raceName.setText(RACE_SCROLL[toggle].name());
		headshot.setImage(new Image(RACE_SCROLL[toggle].getHeadshot(1)));
		description.setText(RACE_SCROLL[toggle].getDescripion());
		humanoid.setTextFill(FXSettingsView.NORMAL);
		flapper.setTextFill(FXSettingsView.NORMAL);
		bonzoid.setTextFill(FXSettingsView.NORMAL);

		switch (toggle) {
		case 0: humanoid.setTextFill(FXSettingsView.SELECTED);
			break;
		case 1: flapper.setTextFill(FXSettingsView.SELECTED);
			break;
		case 2: bonzoid.setTextFill(FXSettingsView.SELECTED);
			break;
		default:
			break;
		}
	}

	@Override
	protected void done() {
		Player p = new Player(RACE_SCROLL[toggle]);
		toggle = randy.nextInt(RACE_SCROLL.length);
		p.setResources(settings.getDifficulty().getPlayerResources());
		settings.setCurrentPlayer(p);
		settings.addPlayer(p);
		controller.done();
	}

	@Override
	public void render() { }

}
