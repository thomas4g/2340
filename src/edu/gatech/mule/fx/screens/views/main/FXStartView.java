package edu.gatech.mule.fx.screens.views.main;

import edu.gatech.mule.fx.screens.views.FXView;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * View for start screen
 * @version 1.0
 */
public class FXStartView extends FXView {
	
	/**
	 * Constructor for start screen
	 */
	public FXStartView() {
		super("start");
	}
	
	/**
	 * Starts the game
	 * @param event, key pressed
	 */
	@FXML
    public void startGame(KeyEvent event) {
	    if (event.getCode() == KeyCode.ENTER) {
	        controller.done();
	    }
	}

	@Override
	public void render() {}
	
}
