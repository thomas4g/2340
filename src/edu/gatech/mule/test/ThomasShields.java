package edu.gatech.mule.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Difficulty;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.music.MusicPlayer;

/**
 * Tests saving and loading.
 * @author tshields
 *
 */
public class ThomasShields {

	private GameEngine game = new GameEngine(new MusicPlayer() {

		@Override
		public void play() {
			// TODO Auto-generated method stub
		}

		@Override
		public void setMedia(URL file) {
			// TODO Auto-generated method stub
		}
	});

	/**
	 * Tests whether or not file is created.
	 */
	@Test
	public void fileCreated() {
		String fileName = "TestFileCreated.junit.dat";
		game.saveGameFile(fileName);
		File f = new File(fileName);
		assertTrue(f.exists());
	}

	/**
	 * Tests if same game can be saved multiple times.
	 */
	@Test
	public void multipleSaves() {
		String fileName = "TestFileCreated.junit.dat",
			otherFileName = "OtherTestFile.dat";
		game.saveGameFile(fileName);
		game.saveGameFile(otherFileName);
		File f = new File(fileName);
		File f2 = new File(otherFileName);
		assertTrue(f.exists() && f2.exists());
	}

	/**
	 * Tests if game is loaded successfully by checking if a new Settings object has been created.
	 */
	@Test
	public void loadTest() {
		Settings s = game.getSettings();
		game.loadGameFile(new File("TestFileCreated.junit.dat"));
		assertFalse(s == game.getSettings());
	}

	/**
	 * Tests if game attributes are preserved across loading.
	 */
	@Test
	public void persistenceTest() {
		Settings s = game.getSettings();
		s.setDifficulty(Difficulty.ADVANCED);
		s.addPlayer(new Player(CharacterType.HUMANOID));

		String fName = "persistenceTest.dat";
		game.saveGameFile(fName);
		game.loadGameFile(new File(fName));
		assertEquals(s, game.getSettings());
	}
}
