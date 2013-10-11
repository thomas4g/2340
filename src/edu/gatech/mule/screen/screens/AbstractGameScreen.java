package edu.gatech.mule.screen.screens;

import javafx.scene.input.MouseEvent;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractGameScreen implements IScreen {

	protected GameEngine game;
	protected Settings settings;
	
	public AbstractGameScreen(GameEngine game,Settings settings){
		this.game=game;
		this.settings=settings;
	}
	
	//TODO add all the map stuff here later
	
}
