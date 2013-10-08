package edu.gatech.mule.screens.views;

import edu.gatech.mule.screen.*;
import edu.gatech.mule.screens.presenters.MenuPresenter;
import edu.gatech.mule.screens.presenters.PlayerConfigPresenter;
import edu.gatech.mule.game.CharacterType;


public interface IPlayerConfigView extends IScreenView {
	public void addCharacterOption(CharacterType type);
	public void setPresenter(PlayerConfigPresenter presenter);

}
