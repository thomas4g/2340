package edu.gatech.mule.fx.music;

import java.net.URL;

import edu.gatech.mule.music.MusicPlayer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Music player for background music in the game.
 * @version 1.0
 */
public class FXMusicPlayer implements MusicPlayer {
	private MediaPlayer bgPlayer;

	@Override
	public void play() {
		if(bgPlayer != null) {
			bgPlayer.play();
		}
	}

	@Override
	public void setMedia(URL file) {
		if(bgPlayer != null) {
			bgPlayer.stop();
		}
		bgPlayer = new MediaPlayer(new Media(file.toString()));
	}
}
