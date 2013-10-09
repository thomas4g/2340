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
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.*;

/**
 *
 * @author dengel6
 */
public class FXMenuScreen extends AbstractMenuScreen implements Initializable {
    
    @FXML
    private Label label;
        
    public FXMenuScreen(GameEngine g, Settings s) {
    	super(g, s);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    	done();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
