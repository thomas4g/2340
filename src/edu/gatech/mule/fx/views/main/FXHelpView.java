package edu.gatech.mule.fx.views.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import edu.gatech.mule.fx.views.FXSettingsView;

/**
 * View for help screen
 * @version 1.0
 */
public class FXHelpView extends FXSettingsView {
	
	@FXML
	private Button backTo;

	/**
	 * Constructor for help view
	 */
	public FXHelpView() {
		super("help");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

	@Override
	protected void toggleSelected() {}

	@Override
	protected void done() {
		controller.done();
	}

}
