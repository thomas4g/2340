/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
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
public class FXStartScreen extends AbstractStartScreen implements Initializable {
   
    /**
     * ???
     * 
     * @param g
     */
    public FXStartScreen(GameEngine g) {
    	super(g);
    }
    
    /**
     * 
     * ???
     * 
     * @param event
     */
    @FXML
    private void OnPress(ActionEvent event){
    	System.out.println("fdafdaf");
    	done();
    }
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
