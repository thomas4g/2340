package edu.gatech.mule.game;


/**
 * 
 * Library of character types
 * 
 * Contains listings of races with corresponding name, description, and images
 * 
 * @version 1.0
 *
 */
public enum CharacterType {
	
	/**
	 * Humanoid
	 * 
	 * Only race where starting money is lower than the default
	 */
	HUMANOID("Humanoid", 
		"Though the empress herself is said to be a \n" 
		+ "humanoid, the rest of her assumed race lives in \npoverty. " 
		+ "Most humanoids work as farmers, servants,\nor men-for-hire.\n", 
		600, "human.gif", "human_head.png", "Jimbo", "/assets/h"),
	
	/**
	 * Bonzoid
	 * 
	 * The monkey race that apparently reminds someone of Colonel Mustard.
	 */
	BONZOID("Bonzoid", 
			"Despite their bulky size, Bonzoids are a peaceful race. \n"
			+ "Many work as tailors, blacksmiths, carpenters,  \nand shopowners.", 
			"bonzoid.gif", "bonzoid_head.png", "Colonel Mustard", "/assets/b"),
	/**
	 * Mechtron
	 * 
	 * Playable only for AI
	 */
	MECHTRON("Mechtron", 
			"Mechtrons are machines created to do the will of the empress. \n" 
			+ "They are stronger, faster, and more alter than any race in the empire. \n" 
			+ "Players cannot control Mechtrons; selecting one creates an npc.", 
			"mechtron.gif", "mechtron_head.png", "", ""),
	
	/**
	 * Flapper
	 * 
	 * Only race where starting money is higher than the default
	 */
	FLAPPER("Flapper", 
			"The aristocracy of the empire is primarily composed\nof Flappers. " 
			+ "Their race has accumulated vast riches by\nestablishing trade with far-off lands.", 
			1600, "flapper.gif", "flapper.png", "Samantha", "/assets/f");
	
	private static final double MONEY = 1000;
	private static final String IMAGE_PATH = "resources/";
	
	private final String sprite;
	private final String headshot;
	private final double money;
	private final String name;
	private final String defaultName;
	private final String descripion;
	private final String resPrefix;

	
	/**
	 * 
	 * Constructor of a character type
	 * 
	 * @param name, name of the race
	 * @param description, short description of the race
	 * @param money, starting money in the game
	 * @param sprite, world sprite filename
	 * @param headshot, headshot filename
	 * 
	 */
	CharacterType(String name, String description, double money, String sprite, String headshot, String defaultName, String resPrefix) {
		this.sprite = IMAGE_PATH + sprite;
		this.headshot = IMAGE_PATH + headshot;
		this.money = money;
		this.descripion = description;
		this.name = name;
		this.defaultName = defaultName;
		this.resPrefix = resPrefix;
	}
	
	/**
	 * Constructor of a character type with default money
	 *  
	 * @param name, name of the race
	 * @param description, short description of the race
	 * @param money, starting money in the game
	 * @param sprite, world sprite filename
	 * @param headshot, headshot filename
	 * 
	 */
	CharacterType(String name, String description, String sprite, String headshot, String defaultName, String resPrefix) {
		this(name, description, MONEY, sprite, headshot, defaultName, resPrefix);
	}

	public String getSprite() {
		return sprite;
	}

	public String getHeadshot() {
		return headshot;
	}

	public double getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public String getDescripion() {
		return descripion;
	}
	
	public String getDefaultName() {
		return this.defaultName;
	}
	
	public String getResPrefix() {
		return this.resPrefix;
	}
	
}
