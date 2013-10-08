package edu.gatech.mule.screens.presenters;

import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.screen.ScreenPresenter;
import edu.gatech.mule.screens.views.IPlayerConfigView;


public class PlayerConfigPresenter extends ScreenPresenter {

	private IPlayerConfigView view;
	public PlayerConfigPresenter(IPlayerConfigView view) {
		super(view);
		this.view = view;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		for(CharacterType type : CharacterType.values()) {
			view.addCharacterOption(type);		
		}
		
		display();
	}

}
