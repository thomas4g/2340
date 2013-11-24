package edu.gatech.mule.fx.views.player;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.views.FXSettingsView;

/**
 * View for player name choosing screen.
 * @version 1.0
 */
public class FXNameChooseView extends FXSettingsView {

	/*
	 * No one loves regex :(
	 * "^([A-Z][a-zA-Z]*)([.]{0,1} [A-Z][a-zA-Z]*)*$"
	 */
	private static final String NAME_REGEX = "^([a-zA-Z]+)( [a-zA-Z]+)*$";

	@FXML
	private TextField nameField;
	@FXML
	private Label playerAnnouncer;
	@FXML
	private Label instructions;
	@FXML
	private ImageView headshot;

	/**
	 * Constructor for player name choosing view.
	 */
	public FXNameChooseView() {
		super("name_choose");
	}

	@Override
	@FXML
	protected void transition(KeyEvent event) {
		if(event.getCode() == KeyCode.UP) {
			nameField.setText(settings.getCurrentPlayerDefaultName());
		} else if(event.getCode() == KeyCode.ENTER) {
			if(nameField.getText().matches(NAME_REGEX)) {
				settings.setCurrentPlayerName(nameField.getText());
				settings.nextPlayer();
				instructions.setText("Game starting...");
				controller.done();
			} else {
				instructions.setText("Invalid input."
						+ "\nNames must only contain"
						+ "\nletters or spaces");
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerAnnouncer.setText("Player "
				+ settings.getPlayerIndex()
				+ ", enter your name");
		headshot.setImage(new Image(settings.getCurrentPlayerHeadshot()));
		nameField.setText(settings.getCurrentPlayerDefaultName());
		instructions.setText("Names must only contain"
				+ "\nletters or spaces"
				+ "\nNo numbers.");
	}

	@Override
	protected void done() { }

	@Override
	protected void toggleSelected() { }

}
