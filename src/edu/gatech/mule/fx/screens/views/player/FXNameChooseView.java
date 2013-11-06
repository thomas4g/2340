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

public class FXNameChooseView extends FXSettingsView {
	
	private final static String NAME_REGEX = "^([A-Z][a-zA-Z]+)( [A-Z][a-zA-Z]+)*$";
	
	@FXML
	private TextField nameField;
	
	@FXML
	private Label playerAnnouncer;
	@FXML
	private Label instructions;
	
	@FXML
	private ImageView headshot;
	
	public FXNameChooseView() {
		super("name_choose");
	}
	
	@FXML
	protected void transition(KeyEvent event){
		if((event.getCode() == KeyCode.ENTER /*|| event.getCode() == KeyCode.SPACE*/)
				&& nameField.getText().matches(NAME_REGEX)) {
			settings.getCurrentPlayer().setName(nameField.getText());
			settings.nextPlayer();
			controller.done();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerAnnouncer.setText("Player "+settings.getPlayerIndex()+", enter your name");
		headshot.setImage(new Image(settings.getCurrentPlayer().getType().getHeadshot(settings.getCurrentPlayer().getColor().ordinal()+1)));
		nameField.setText(settings.getCurrentPlayer().getType().getName());
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
