/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gatech.mule.fx.screens.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
    private void OnPress(ActionEvent event){
    	controller.done();
    }

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
