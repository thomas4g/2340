package edu.gatech.mule.fx.screens.views;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.ScreenView;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * General set up for any view ports
 * @version 0.1
 */
public abstract class FXView implements ScreenView, Initializable {
	
	public final static Color NORMAL = Color.web("#2F2F2F");
	public final static Color SELECTED = Color.web("#0000FF");
	public final static Color GREYED = Color.web("#AAAAAA");
	
	protected final static KeyCode UP_KEY = KeyCode.UP;
	protected final static KeyCode DOWN_KEY = KeyCode.DOWN;
	protected final static KeyCode LEFT_KEY = KeyCode.LEFT;
	protected final static KeyCode RIGHT_KEY = KeyCode.RIGHT;
	
	protected final static KeyCode ACTION_KEY = KeyCode.ENTER;
	protected final static KeyCode CANCEL_KEY = KeyCode.ESCAPE;
	protected final static KeyCode SKIP_KEY = KeyCode.S;
	
	private static final String FXML_DIR = "/format/";
	private static final String FXML_EXT = ".fxml";
	
	protected String fxmlName;
	protected Node node;
	protected ScreenController controller;
	
	/**
	 * Constructor for FX view ???
	 * @param fxmlName
	 */
	public FXView(String fxmlName) {
		this.fxmlName = fxmlName;
	}
	
	/**
	 * Loads the screen
	 */
	public void load() {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_DIR + fxmlName + FXML_EXT));
			loader.setController(this);
			node = (Pane)loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the node ???
	 * @return node
	 */
	public Node getNode() {
		return node;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}  
	
	public abstract void render();
	
	@Override
	public void setController(ScreenController controller) {
		this.controller = controller;
	}
	
	protected int mod(int cheese, int knife) {
		int mod = cheese % knife;
		if(mod < 0) {
			mod += knife;
		}
		return mod;
	}
	
}
