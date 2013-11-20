package edu.gatech.mule.game.map.tiles;

import java.awt.Image;

import tiled.core.AnimatedTile;
import tiled.core.Tile;
import edu.gatech.mule.game.player.Player;

/**
 * Represents an animated tile.
 * @author tyler
 *
 */
public class AnimatedGameTile extends GameTile {

	private int frameIndex;
	private transient Image[] frames;

	/**
	 * AnimatedGameTile.
	 * @param t tile
	 * @param type tiletype
	 * @param frameTiles frame tiles
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
	 * Gets the next image in the animation.
	 * @return
	 */
	private Image getNextImage() {
		if(frameIndex >= frames.length * 2) {
			frameIndex = 0;
		}
		return this.frames[(frameIndex++) / 2];
	}

	@Override
	public Image getImage() {
		return getNextImage();
	}

	@Override
	public void action(Player player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void enter(Player player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void exit(Player player) {
		// TODO Auto-generated method stub
	}
}
