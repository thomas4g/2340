package edu.gatech.mule.fx.screens.views.player;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.screens.views.FXSettingsView;

/**
 * View for player name choosing screen
 * @version 1.0
 */
public class FXNameChooseView extends FXSettingsView {
	
	private final static String NAME_REGEX = "^([A-Z][a-zA-Z]*)([.]{0,1} [A-Z][a-zA-Z]*)*$";
	
	@FXML
	private TextField nameField;
	
	@FXML
	private Label playerAnnouncer;
	@FXML
	private Label instructions;
	
	@FXML
	private ImageView headshot;
	
	/**
	 * Constructor for player name choosing view
	 */
	public FXNameChooseView() {
		super("name_choose");
	}
	
	@Override
	@FXML
	protected void transition(KeyEvent event){
		if(event.getCode() == KeyCode.UP) {
			nameField.setText(settings.getCurrentPlayerDefaultName());
		} else if((event.getCode() == KeyCode.ENTER /*|| event.getCode() == KeyCode.SPACE*/)
				&& nameField.getText().matches(NAME_REGEX)) {
			settings.setCurrentPlayerName(nameField.getText());
			settings.nextPlayer();
			controller.done();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", enter your name");
		headshot.setImage(new Image(settings.getCurrentPlayerHeadshot()));
		nameField.setText(settings.getCurrentPlayerDefaultName());
		instructions.setText("Proper names only.\n(i.e. Colonel Mustard Rawr)");
	}

	@Override
	public void render() {}

	@Override
	protected void scrollLeft() {}

	@Override
	protected void scrollRight() {}

	@Override
	protected void toggleSelected() {}

	@Override
	protected void done() {}

}
