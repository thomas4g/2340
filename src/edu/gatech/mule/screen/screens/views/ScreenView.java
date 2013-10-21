package edu.gatech.mule.screen.screens.views;

import edu.gatech.mule.screen.screens.controllers.ScreenController;

public abstract class ScreenView {
	protected ScreenController controller;
	
	public void setController(ScreenController c) {
		this.controller = c;
	}
}
