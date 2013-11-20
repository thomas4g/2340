package edu.gatech.mule.music;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Music player for background music in the game.
 * @version 1.0
 */
public class MusicPlayer {
	private MediaPlayer bgPlayer;

	/**
	 * Plays music player.
	 */
	public void play() {
		if(bgPlayer != null) {
		bgPlayer.play();
		}
	}

	/**
	 * Sets the music to be played.
	 * @param file the music file that will be played
	 */
	public void setMedia(URL file) {
		if(bgPlayer != null) {
			bgPlayer.stop();
		}
		bgPlayer = new MediaPlayer(new Media(file.toString()));
	}
}
