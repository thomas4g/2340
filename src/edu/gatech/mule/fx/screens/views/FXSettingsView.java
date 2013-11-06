package edu.gatech.mule.fx.screens.views;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.screen.screens.views.SettingsView;

public abstract class FXSettingsView extends FXView implements SettingsView {

	public FXSettingsView(String fxmlName) {
		super(fxmlName);
	}
	
	@FXML
	protected abstract void scrollLeft();
	@FXML
	protected abstract void scrollRight();
	
	protected abstract void update();
	protected abstract void done();
	
	@FXML
	protected void transition(KeyEvent event){
		if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.UP) {
			scrollLeft();
		} else if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.DOWN) {
			scrollRight();
		} else if (event.getCode() == KeyCode.SPACE) {
			done();
		}
	}

	@Override
	public void render() {}

}
