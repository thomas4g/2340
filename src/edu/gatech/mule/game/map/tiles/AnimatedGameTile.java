package edu.gatech.mule.game.map.tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import tiled.core.AnimatedTile;
import tiled.core.Tile;
import edu.gatech.mule.game.player.Player;

/**
 * Set up for animated game tile
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AnimatedGameTile extends GameTile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2183966789445266648L;
	private int frameIndex;
	private transient BufferedImage[] frames;
	
	/**
	 * Constructor for animated game tile
	 * @param t, animated tile
	 * @param type, type of tile
	 * @param frameTiles, the array of frames for animation
	 */
	public AnimatedGameTile(AnimatedTile t, TileType type, Tile[] frameTiles) {
		super(t, type);
		this.frames = new BufferedImage[frameTiles.length];
		for(int i=0; i<frameTiles.length; i++) {
			this.frames[i] = (BufferedImage) frameTiles[i].getImage();
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
	public void exit(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void sWrite(ObjectOutputStream out) throws IOException {
    	out.defaultWriteObject();
		
		if(frames != null) {
			out.writeInt(frames.length);
			for(int i=0;i<frames.length;i++) {
				ImageIO.write(frames[i], "png", out);
			}
		}
		else {
			out.writeInt(0);
		}
	}
	
	@Override
	protected void sRead(ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	
    	final int f = in.readInt();
    	frames = new BufferedImage[f];
    	for(int i=0;i<f;i++) {
    		BufferedImage img = ImageIO.read(in);
    		frames[i] = img == null ? frames[0] : img;
    	}
    	image = frames[0];
    }
}
