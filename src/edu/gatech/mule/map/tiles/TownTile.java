package edu.gatech.mule.map.tiles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import edu.gatech.mule.game.player.Player;
import tiled.core.Tile;

/**
 * Representation of a tile in the town.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TownTile extends GameTile {

	private static final long serialVersionUID = 1034125066905221834L;

	 /**
	  * Constructor for a town tile.
	 * @param t tile
	 * @param type type of tile
	 */
	public TownTile(Tile t, TileType type) {
		super(t, type);
	}

	@Override
	public void action(Player player) {

	}

	@Override
	public void enter(Player player) {

	}

	@Override
	public void exit(Player player) {
		// TODO Auto-generated method stub
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		if(image != null) {
			out.writeInt(1);
			ImageIO.write(image, "png", out);
		} else {
			out.writeInt(0);
		}
	}

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	if(in.readInt() > 0) {
    		image = ImageIO.read(in);
    	}
    }


}
