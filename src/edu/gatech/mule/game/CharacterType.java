package edu.gatech.mule.game;

public enum CharacterType {
	
	HUMANOID("Humanoid", "descript", 600, "human.gif", "human_head.png"),
	BONZOID("Bonzoid", "descript", "bonzoid.gif", "bonzoid_head.png"),
	MECHTRON("Mechtron", "mechy", "mechtron.gif", "mechtron_head.png"),
	FLAPPER("Flapper", "DESCRIPTION HERE", 1600, "flapper.gif", "flapper.png");
	
	private static final double MONEY = 1000;
	private static final String IMAGE_PATH = "resources/";
	
	public final String sprite;
	public final String headshot;
	public final double money;
	public final String name;
	public final String descrip;
	
	CharacterType(String name, String description, double money, String sprite, String headshot) {
		this.sprite = IMAGE_PATH + sprite;
		this.headshot = IMAGE_PATH + headshot;
		this.money = money;
		this.descrip = description;
		this.name = name;
	}
	
	CharacterType(String name, String description, String sprite, String headshot) {
		this(name, description, MONEY, sprite, headshot);
	}
	
}
