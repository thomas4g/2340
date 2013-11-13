package edu.gatech.mule.game.map.tiles;

import java.awt.Image;

import tiled.core.AnimatedTile;
import tiled.core.Tile;
import edu.gatech.mule.game.player.Player;

public class AnimatedGameTile extends GameTile {

	private int frameIndex;
	private transient Image[] frames;
	
	public AnimatedGameTile(AnimatedTile t, TileType type, Tile[] frameTiles) {
		super(t, type);
		System.out.println("hi");
		this.frames = new Image[frameTiles.length];
		for(int i=0; i<frameTiles.length; i++) {
			this.frames[i] = frameTiles[i].getImage();
		}
		frameIndex = 0;
	}
	
	public Image getNextImage() {
		if(frameIndex >= frames.length * 2)
			frameIndex = 0;
		return this.frames[(frameIndex++) / 2];
	}
	
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
