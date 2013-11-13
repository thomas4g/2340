package edu.gatech.mule.fx.screens.views.main;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.screen.screens.controllers.main.PersistenceController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
		newGame.setTextFill(FXSettingsView.NORMAL);
		loadGame.setTextFill(FXSettingsView.GREYED);
		help.setTextFill(FXSettingsView.NORMAL);
		switch(toggle) {
		case 0:
			newGame.setTextFill(FXSettingsView.SELECTED);
			break;
		case 1:
			loadGame.setTextFill(FXSettingsView.SELECTED);
			break;
		case 2:
			help.setTextFill(FXSettingsView.SELECTED);
			break;
		}
	}

	@Override
	protected void done() {
		if(toggle==0) {
			controller.done();
		} else if(toggle==2) {
			((PersistenceController)controller).help();
		}
	}

}
