package edu.gatech.mule.fx.screens.views.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import edu.gatech.mule.fx.screens.views.FXSettingsView;

public class FXHelpView extends FXSettingsView {
	
	@FXML
	private Button backTo;

	public FXHelpView() {
		super("help");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@Override
	protected void toggleSelected() {
		
	}

	@Override
	protected void done() {
		controller.done();
	}

}
