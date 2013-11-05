package edu.gatech.mule.game.map.tiles;

import java.awt.Image;

import tiled.core.Tile;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.TileType;

public class AnimatedGameTile extends GameTile {

	private Tile[] frames;
	private int frameIndex;
	
	public AnimatedGameTile(Tile t, TileType type, Tile[] frames) {
		super(t, type);
		frameIndex = 0;
		this.frames = frames;
	}
	
	@Override
	public Image getImage() {
		if(frameIndex >= frames.length * 2) {
			frameIndex = 0;
		}
		return frames[frameIndex++ / 2].getImage();
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
