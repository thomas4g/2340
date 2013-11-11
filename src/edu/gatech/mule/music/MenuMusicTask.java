package edu.gatech.mule.music;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MenuMusicTask { //extends Thread {
	MediaPlayer bgPlayer;
	public MenuMusicTask() {
		URL file = getClass().getResource("/music/Artifact.mp3");
		bgPlayer = new MediaPlayer(new Media(file.toString()));
	}
	
//	@Override
	public void run() {
		bgPlayer.play();
//		bgPlayer.s
	}
}
