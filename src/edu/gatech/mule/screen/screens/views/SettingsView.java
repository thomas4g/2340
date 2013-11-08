package edu.gatech.mule.screen.screens.views;

import edu.gatech.mule.game.Settings;

/**
 * Settings view
 * @version 0.1
 */
public interface SettingsView extends ScreenView {
	
	public final static String NORMAL = "#2F2F2F";
	public final static String SELECTED = "#0000FF";
	public final static String GREYED = "#AAAAAA";
	
	public void setSettings(Settings settings);
}
