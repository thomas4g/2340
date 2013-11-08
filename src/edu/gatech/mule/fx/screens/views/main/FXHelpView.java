package edu.gatech.mule.fx.screens.views.main;

import edu.gatech.mule.fx.screens.views.FXSettingsView;

public class FXHelpView extends FXSettingsView {

	public FXHelpView() {
		super("help");
	}

	@Override
	protected void toggleSelected() {
		
	}

	@Override
	protected void done() {
		controller.done();
	}

}
