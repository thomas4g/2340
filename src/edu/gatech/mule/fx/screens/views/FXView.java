package edu.gatech.mule.fx.screens.views;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gatech.mule.screen.screens.views.ScreenView;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class FXView extends ScreenView implements Initializable {
	private static final String FXML_DIR = "/format/";
	private static final String FXML_EXT = ".fxml";
	
	protected String fxmlName;
	protected Node node;
	
	public FXView(String fxmlName) {
		this.fxmlName = fxmlName;
	}
	
	public void load() {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_DIR + fxmlName + FXML_EXT));
			loader.setController(this);
			node = (Pane)loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Node getNode() {
		return node;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}  
}
