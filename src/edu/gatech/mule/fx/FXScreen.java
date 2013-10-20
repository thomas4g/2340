package edu.gatech.mule.fx;

import edu.gatech.mule.screen.IScreen;
import javafx.scene.Node;

public interface FXScreen {
	public Node getNode();
	public void load();
}
