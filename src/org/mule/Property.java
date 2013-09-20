package org.mule;

import java.util.List;

/**
 * A property
 * 
 * @author Thomas Shields
 * @version 1.0
 */
public class Property extends Tile{
	
//	private enum Type {RIVER, PLAIN, MOUNTAIN};
	private List<Mule> mules;
//	private Type type;
	
	public void produce() {
		for (Mule mule : mules) {
			mule.produce();
		}
	}
	
	@Override
	public void action(Player p) {
		if(p.hasMule()) {
			mules.add(p.deployMule());
		}
	}
}
