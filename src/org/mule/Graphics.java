package org.mule;

import javafx.stage.Stage;

/**
 * Graphics module
 * @author Thomas Shields
 *
 */
public class Graphics {
	
	private Stage stage;
	
	public Graphics(){
		stage=new Stage();
	}
	
	public Stage getStage(){
		return stage;
	}
	
}