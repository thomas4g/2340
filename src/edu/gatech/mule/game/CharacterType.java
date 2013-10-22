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
		600, "Jimbo"),
	
	/**z
	 * Bonzoid
	 * 
	 * The monkey race that apparently reminds someone of Colonel Mustard.
	 */
	BONZOID("Bonzoid", 
			"Despite their bulky size, Bonzoids are a peaceful race. \n"
			+ "Many work as tailors, blacksmiths, carpenters,  \nand shopowners.", 
			"Colonel Mustard"),
	/**
	 * Mechtron
	 * 
	 * Playable only for AI
	 */
	AUTOMATON("Automaton", 
			"Mechtrons are machines created to do the will of the empress. \n" 
			+ "They are stronger, faster, and more alter than any race in the empire. \n" 
			+ "Players cannot control Mechtrons; selecting one creates an npc.", ""),
	
	/**
	 * Flapper
	 * 
	 * Only race where starting money is higher than the default
	 */
	FLAPPER("Flapper", 
			"The aristocracy of the empire is primarily composed\nof Flappers. " 
			+ "Their race has accumulated vast riches by\nestablishing trade with far-off lands.", 
			1600, "Samantha");
	
	
	public static final String IMAGE_EXT = ".png";
	public enum Direction{UP,DOWN,RIGHT,LEFT};
	
	private static final double MONEY = 1000;
	private static final String IMAGE_PATH = "/assets";
	private static final String SPRITES = "/overmap walksprites/";
	private static final String INDICATORS = "/color indicators/";
	
	private final String sprites;
	private final String headshot;
	private final String totem;
	private final double money;
	private final String type;
	private final String name;
	private final String description;

	
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
	CharacterType(String type, String description, double money, String name) {
		this.type = type.toLowerCase();
		this.description = description;
		this.money = money;
		this.name = name;
		
		//need to add color here instead of + "1"
		this.sprites = IMAGE_PATH + SPRITES + this.type + "/" + this.type.charAt(0) + "1f";
		this.headshot = IMAGE_PATH + "/" + this.type.charAt(0);
		this.totem = IMAGE_PATH + INDICATORS;
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
	CharacterType(String name, String description, String defaultName) {
		this(name, description, MONEY, defaultName);
	}

	public String getStillSprite(Direction direction) {
		return sprites + (3*direction.ordinal() + 1) + IMAGE_EXT;
	}
	
	public String[] getDirectionalSprites(Direction direction) {
		int base = 3*direction.ordinal() + 1;
		return new String[]{sprites + (base+1) + IMAGE_EXT, sprites + (base+2) + IMAGE_EXT};
	}

	public String getHeadshot(int color) {
		return headshot + color + IMAGE_EXT;
	}
	public String getTotem(int color) {
		return totem + color + IMAGE_EXT;
	}

	public double getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public String getDescripion() {
		return description;
	}

}
