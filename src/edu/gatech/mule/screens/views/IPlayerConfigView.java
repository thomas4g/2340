package edu.gatech.mule.screens.views;

import edu.gatech.mule.screen.*;
import edu.gatech.mule.game.CharacterType;


public interface IPlayerConfigView extends IScreenView {
	public void addCharacterOption(CharacterType type);
}
