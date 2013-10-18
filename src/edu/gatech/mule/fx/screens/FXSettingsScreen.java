package edu.gatech.mule.fx.screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.controllers.FXSettingsScreenController;

public class FXSettingsScreen extends Parent {
	
	private static final String FXML_DIR = "/format/settings.fxml";
	
	public FXSettingsScreen(GameEngine engine) {
		Pane screen = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_DIR));
			loader.setController(new FXSettingsScreenController(engine));
			screen = (Pane)loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.getChildren().add(screen);
	}

}
