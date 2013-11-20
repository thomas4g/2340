package edu.gatech.mule.screen.views;

import edu.gatech.mule.game.Settings;

/**
 * Set up for settings view.
 * @version 1.0
 */
public interface SettingsView extends ScreenView {

	/**
	 * Sets up settings.
	 * @param settings the settings
	 */
	void setSettings(Settings settings);

}
