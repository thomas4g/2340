package edu.gatech.mule.game;

public enum CharacterType {
	
	HUMANOID("Humanoid", 
		"Though the empress herself is said to be a " 
		+ "humanoid, the rest of her assumed race lives in poverty. " 
		+ "Most humanoids work as farmers, servants, or men-for-hire.", 
		600, "human.gif", "human_head.png"),
	BONZOID("Bonzoid", 
			"Despite their bulky size, Bonzoids are a peaceful race. "
			+ "Many work as tailors, blacksmiths, carpenters, and shopowners.", 
			"bonzoid.gif", "bonzoid_head.png"),
	MECHTRON("Mechtron", 
			"Mechtrons are machines created to do the will of the empress. " 
			+ "They are stronger, faster, and more alter than any race in the empire. " 
			+ "Players cannot control Mechtrons; selecting one creates an npc.", 
			"mechtron.gif", "mechtron_head.png"),
	FLAPPER("Flapper", 
			"The aristocracy of the empire is primarily composed of Flappers. " 
			+ "Their race has accumulated vast riches by establishing trade with far-off lands.", 
			1600, "flapper.gif", "flapper.png");
	
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
