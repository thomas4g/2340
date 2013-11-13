package edu.gatech.mule.fx.screens.views;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.SettingsView;

public abstract class FXSettingsView extends FXView implements SettingsView {
	
	public final static Color NORMAL = Color.web("#2F2F2F");
	public final static Color SELECTED = Color.web("#0000FF");
	public final static Color GREYED = Color.web("#AAAAAA");
			
	protected Settings settings;
	protected int toggle;
	protected int toggleMod;

	public FXSettingsView(String fxmlName) {
		super(fxmlName);
	}
	
	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
		toggle = 0;
	}
	
	@FXML
	protected void scrollLeft() {
		toggle = mod(--toggle,toggleMod);
		toggleSelected();
	}
	
	@FXML
	protected void scrollRight() {
		toggle = mod(++toggle,toggleMod);
		toggleSelected();
	}
	
	protected abstract void toggleSelected();
	protected abstract void done();
	
	@FXML
	protected void transition(KeyEvent event){
		if (event.getCode() == LEFT_KEY || event.getCode() == UP_KEY) {
			scrollLeft();
		} else if (event.getCode() == RIGHT_KEY || event.getCode() == DOWN_KEY) {
			scrollRight();
		} else if (event.getCode() == ACTION_KEY) {
			done();
		}
	}

	@Override
	public void render() {}

}
