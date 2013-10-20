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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.FXScreen;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.*;

/**
 *
 * FX start screen sets up the graphics for the start screen
 *
 * @version 1.0
 * 
 */
public class FXStartScreen extends AbstractStartScreen implements Initializable, FXScreen {
   
	private static final String FXML_DIR = "/format/start.fxml";
	private Node node;
	
    /**
     * ???
     * 
     * @param g
     */
    public FXStartScreen(GameEngine g) {
    	super(g);
    }
    
    public void load() {
    	try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_DIR));
			loader.setController(this);
			node = (Pane)loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 
     * ???
     * 
     * @param event
     */
    @FXML
    private void OnPress(ActionEvent event){
    	dispose();
    }
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node getNode() {
		return node;
	}    
}
