package edu.gatech.mule.fx.screens.views;

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
