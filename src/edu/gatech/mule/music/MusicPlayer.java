package edu.gatech.mule.music;

import java.net.URL;

/**
 * Music player for background music in the game.
 * @version 1.0
 */
public interface MusicPlayer {

	/**
	 * Plays music player.
	 */
	void play();

	/**
	 * Sets the music to be played.
	 * @param file the music file that will be played
	 */
	void setMedia(URL file);
}
