package edu.gatech.mule.game.map.tiles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import tiled.core.Tile;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.player.Player;

/**
 * Representation of a property tile
 * @version 0.1
 */
public class PropertyTile extends GameTile {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3896514596626042174L;
	private List<Mule> mules;
	
	/**
	 * Constructor for a property tile
	 * @param t, tile config ???
	 * @param type, type of tile
	 */
	public PropertyTile(Tile t, TileType type) {
		super(t, type);
		mules = new ArrayList<Mule>();
	}
	
	public void addMule(Mule mule) {
		mules.add(mule);
	}
	public List<Mule> getMules() {
		return mules;
	}

	@Override
	public void action(Player player) {
		// TODO Auto-generated method stub
		
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
		}
		else out.writeInt(0);
	}
	
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	if(in.readInt() > 0)
    		image = ImageIO.read(in);
    }

}
