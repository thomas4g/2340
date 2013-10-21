/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gatech.mule.fx.screens.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.*;

/**
 *
 * FX start screen sets up the graphics for the start screen
 *
 * @version 1.0
 * 
 */
public class FXStartView extends FXView {
	
	public FXStartView() {
		super("start");
	}
	
    @FXML
    private void OnPress(ActionEvent event){
    	controller.dispose();
    }
}
