package edu.gatech.mule.music;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
	MediaPlayer bgPlayer;
	
	public void play() {
		if(bgPlayer != null) {
		bgPlayer.play();
		}
	}
	
	public void setMedia(URL file) {
		if(bgPlayer != null)
			bgPlayer.stop();
		bgPlayer = new MediaPlayer(new Media(file.toString()));
	}
}
