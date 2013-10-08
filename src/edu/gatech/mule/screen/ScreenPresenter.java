package edu.gatech.mule.screen;

public abstract class ScreenPresenter {
	
	protected IScreenView iview;
	
	public ScreenPresenter(IScreenView iview) {
		this.iview = iview;
	}
	
	public abstract void init();
	
	public void display() {
		iview.display();
	}
}
