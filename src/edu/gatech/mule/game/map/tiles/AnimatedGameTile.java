package edu.gatech.mule.game.map.tiles;

import java.awt.Image;

import tiled.core.AnimatedTile;
import tiled.core.Tile;
import edu.gatech.mule.game.player.Player;

/**
 * Set up for animated game tile
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AnimatedGameTile extends GameTile {

	private int frameIndex;
	private transient Image[] frames;
	
	/**
	 * Constructor for animated game tile
	 * @param t, animated tile
	 * @param type, type of tile
	 * @param frameTiles, the array of frames for animation
	 */
	public AnimatedGameTile(AnimatedTile t, TileType type, Tile[] frameTiles) {
		super(t, type);
		this.frames = new Image[frameTiles.length];
		for(int i = 0; i < frameTiles.length; i++) {
			this.frames[i] = frameTiles[i].getImage();
		}
		frameIndex = 0;
	}
	
	/**
	 * Get the next image in the frame
	 * @return
	 */
	public Image getNextImage() {
		if(frameIndex >= frames.length * 2)
			frameIndex = 0;
		return this.frames[(frameIndex++) / 2];
	}
	
	/**
	 * Returns the image
	 * @return the image
	 */
	public Image getImage() {
		return getNextImage();
	}

	@Override
	public void action(Player player) {}

	@Override
	public void enter(Player player) {}

	@Override
	public void exit(Player player) {}
	
}
