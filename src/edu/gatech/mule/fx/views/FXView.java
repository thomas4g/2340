package edu.gatech.mule.fx.views;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.ScreenView;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * General set up for all view ports.
 * @version 1.0
 */
public abstract class FXView implements ScreenView, Initializable {

	public static final int FONT_SIZE = 16;

	public static final Color NORMAL = Color.web("#2F2F2F");
	public static final Color SELECTED = Color.web("#0000FF");
	public static final Color GREYED = Color.web("#AAAAAA");

	protected static final KeyCode UP_KEY = KeyCode.UP;
	protected static final KeyCode DOWN_KEY = KeyCode.DOWN;
	protected static final KeyCode LEFT_KEY = KeyCode.LEFT;
	protected static final KeyCode RIGHT_KEY = KeyCode.RIGHT;

	protected static final KeyCode ACTION_KEY = KeyCode.ENTER;
	protected static final  KeyCode CANCEL_KEY = KeyCode.ESCAPE;

	private static final String FXML_DIR = "/format/";
	private static final String FXML_EXT = ".fxml";

	protected String fxmlName;
	protected Node node;
	protected ScreenController controller;

	/**
	 * Constructor for view.
	 * @param fxmlName the fxml file containing view layout
	 */
	public FXView(String fxmlName) {
		this.fxmlName = fxmlName;
	}

	/**
	 * Loads the screen.
	 */
	public void load() {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass()
					.getResource(FXML_DIR + fxmlName + FXML_EXT));
			loader.setController(this);
			node = (Pane) loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Returns node.
	 * @return node the main fx node.
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * Renders image.
	 */
	public abstract void render();

	@Override
	public void setController(ScreenController controller) {
		this.controller = controller;
	}

	/**
	 * Returns the mod in mod division based on division theory.
	 * AKA the mod will always be a nonnegative number
	 * @param divid the dividend
	 * @param divis the divisor
	 * @return the mod between the dividend and divisor
	 */
	protected int mod(int divid, int divis) {
		int mod = divid % divis;
		if(mod < 0) {
			mod += divis;
		}
		return mod;
	}

}
