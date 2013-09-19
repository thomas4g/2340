package org.mule;

import java.util.List;

public class Property extends Map{
	
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
