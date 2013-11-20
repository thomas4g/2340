package edu.gatech.mule.fx.views.main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import edu.gatech.mule.fx.views.FXSettingsView;
import edu.gatech.mule.screen.controllers.main.PersistenceController;
import edu.gatech.mule.screen.views.PersistenceView;

/**
 * View for persistence screen.
 * @version 1.0
 */
public class FXPersistenceView extends FXSettingsView implements PersistenceView {

	@FXML
	private Label newGame;

	@FXML
	private Label loadGame;

	@FXML
	private Label help;

	private Label[] labels;

	private PersistenceController controller;

	/**
	 * Constructor for persistence view.
	 */
	public FXPersistenceView() {
		super("persistence");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labels = new Label[]{newGame, loadGame, help};
		toggleMod = labels.length;
		toggleSelected();
	}

	@Override
	protected void toggleSelected() {
		newGame.setTextFill(FXSettingsView.NORMAL);
		loadGame.setTextFill(FXSettingsView.NORMAL);
		help.setTextFill(FXSettingsView.NORMAL);
		labels[toggle].setTextFill(FXSettingsView.SELECTED);
	}

	@Override
	protected void done() {
		if (toggle == 0) {
			controller.done();
		} else if (toggle == 1) {
			FileChooser fc = new FileChooser();
			fc.setInitialDirectory(new File(System.getProperty("user.dir")));
			controller.done(fc.showOpenDialog(null));
		} else if (toggle == 2) {
			controller.help();
		}
	}

	@Override
	public void setController(PersistenceController c) {
		controller = c;
	}

}
