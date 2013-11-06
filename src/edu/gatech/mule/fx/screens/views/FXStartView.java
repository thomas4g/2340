/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gatech.mule.fx.screens.views;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * View for start screen
 * @version 0.1
 */
public class FXStartView extends FXView {
	
	/**
	 * Constructor for start screen
	 */
	public FXStartView() {
		super("start");
	}
	
	@FXML
    public void startGame(KeyEvent event) {
	    if (event.getCode() == KeyCode.SPACE) {
	        controller.done();
	    }
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
