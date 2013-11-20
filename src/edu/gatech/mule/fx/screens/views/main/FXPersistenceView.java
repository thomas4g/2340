package edu.gatech.mule.fx.screens.views.main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import edu.gatech.mule.fx.screens.views.FXSettingsView;
import edu.gatech.mule.screen.screens.controllers.main.PersistenceController;
import edu.gatech.mule.screen.screens.views.PersistenceView;

/**
 * View for persistence screen
 * @version 1.0
 */
public class FXPersistenceView extends FXSettingsView implements PersistenceView {
	
	@FXML
	private Label newGame;
	
	@FXML
	private Label loadGame;
	
	@FXML
	private Label help;

	private PersistenceController controller;
	
	/**
	 * Constructor for persistence view
	 */
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
		loadGame.setTextFill(FXSettingsView.NORMAL);
		help.setTextFill(FXSettingsView.NORMAL);
		switch (toggle) {
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
		if (toggle==0) {
			controller.done();
		} 
		else if (toggle==1) {
			FileChooser fc = new FileChooser();
			fc.setInitialDirectory(new File(System.getProperty("user.dir")));
			controller.done(fc.showOpenDialog(null));
		}
		else if (toggle==2) {
			controller.help();
		}
		
	}

	@Override
	public void setController(PersistenceController c) {
		controller = c;
	}

}
