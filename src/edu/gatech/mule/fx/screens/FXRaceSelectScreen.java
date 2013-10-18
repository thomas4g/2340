package edu.gatech.mule.fx.screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.controllers.FXRaceSelectScreenController;

public class FXRaceSelectScreen extends Parent {
	
	private static final String FXML_DIR = "/format/race_select.fxml";
	
	public FXRaceSelectScreen(GameEngine engine) {
		Pane screen = null;
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_DIR));
			loader.setController(new FXRaceSelectScreenController(engine));
			screen = (Pane)loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.getChildren().add(screen);
	}

}
