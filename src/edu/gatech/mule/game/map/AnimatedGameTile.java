package edu.gatech.mule.game.map;

import java.awt.Image;

import edu.gatech.mule.game.Player;
import tiled.core.AnimatedTile;
import tiled.core.Tile;

public class AnimatedGameTile extends GameTile {

	private int frameIndex;
	private Tile[] frames;
	
	public AnimatedGameTile(AnimatedTile t, TileType type, Tile[] frames) {
		super(t, type);
		this.frames = frames;
		frameIndex = 0;
	}
	
	public Tile getTile() {
		if(frameIndex >= frames.length * 2)
			frameIndex = 0;
		return this.frames[(frameIndex++) / 2];
	}
	
	public Image getImage() {
		return getTile().getImage();
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
