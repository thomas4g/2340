package edu.gatech.mule.fx.screens.views;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gatech.mule.screen.screens.views.SettingsView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FXPersistenceView extends FXSettingsView {
	
	@FXML
	private Label newGame;
	
	@FXML
	private Label loadGame;
	
	@FXML
	private Label help;

	public FXPersistenceView() {
		super("persistence");
		toggleMod = 3;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleSelected();
	}

	@Override
	protected void toggleSelected() {
		newGame.setTextFill(Color.web(SettingsView.NORMAL));
		loadGame.setTextFill(Color.web(SettingsView.GREYED));
		help.setTextFill(Color.web(SettingsView.GREYED));
		switch(toggle) {
		case 0:
			newGame.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 1:
			loadGame.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		case 2:
			help.setTextFill(Color.web(SettingsView.SELECTED));
			break;
		}
	}

	@Override
	protected void done() {
		System.out.println("Done with persistence");
		controller.done();
	}

}
