package edu.gatech.mule.game;

/**
 * Library of character types
 * Contains listings of races with corresponding name, description, and images
 * @version 0.1
 */
public enum CharacterType {

	/**
	 * Humanoid:only race where starting money is lower than the default
	 */
	HUMANOID("Humanoid", 
		"Though the empress herself is said to be a \n" 
		+ "humanoid, the rest of her assumed race lives in \npoverty. " 
		+ "Most humanoids work as farmers, servants,\nor men-for-hire.\n", 
		600, "Jimbo"),
	
	/**
	 * Bonzoid:the monkey race that apparently reminds someone of Colonel Mustard.
	 */
	BONZOID("Bonzoid", 
			"Despite their bulky size, Bonzoids are a peaceful race. \n"
			+ "Many work as tailors, blacksmiths, carpenters,  \nand shopowners.", 
			"Colonel Mustard"),
	/**
	 * Mechtron:playable only for AI
	 */
	AUTOMATON("Automaton", 
			"Mechtrons are machines created to do the will of the empress. \n" 
			+ "They are stronger, faster, and more alter than any race in the empire. \n" 
			+ "Players cannot control Mechtrons; selecting one creates an npc.", ""),
	
	/**
	 * Flapper:only race where starting money is higher than the default
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
	 * Constructor of a character type
	 * @param type, a character's race
	 * @param description, short description of the race
	 * @param money, starting money in the game
	 * @param name, name of the player
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
	 * @param type, name of the race
	 * @param description, short description of the race
	 * @param defaultName, a default name for the player
	 */
	CharacterType(String type, String description, String defaultName) {
		this(type, description, MONEY, defaultName);
	}

	/**
	 * Get the still/idle sprite based on facing direction
	 * @param direction, direction the sprite is facing
	 * @return the filename of the corresponding still sprite
	 */
	public String getStillSprite(Direction direction) {
		return sprites + (3*direction.ordinal() + 1) + IMAGE_EXT;
	}
	
	/**
	 * Get the directional/walking sprite based on facing direction
	 * @param direction, direction the sprite is facing
	 * @return the filename of the corresponding directional sprite
	 */
	public String[] getDirectionalSprites(Direction direction) {
		int base = 3*direction.ordinal() + 1;
		return new String[]{sprites + (base+1) + IMAGE_EXT, sprites + (base+2) + IMAGE_EXT};
	}

	/**
	 * Get the headshot of a character based on color
	 * @param color, the color of the headshot
	 * @return the filename of the corresponding headshot
	 */
	public String getHeadshot(int color) {
		return headshot + color + IMAGE_EXT;
	}
	
	/**
	 * Get the totem of a character based on color
	 * @param color, the color of the totem
	 * @return the filename of the corresponding totem
	 */
	public String getTotem(int color) {
		return totem + color + IMAGE_EXT;
	}

	/**
	 * Get the money blingbling
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * Get the name of the player
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the description
	 * @return description
	 */
	public String getDescripion() {
		return description;
	}

}
