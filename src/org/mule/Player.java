package org.mule;

import java.util.List;

public class Player {
	private double money;
	private List<Property> properties;
	
	public void reap() {
		for(Property prop : properties) {
			prop.produce();
		}
	}
}
