package edu.gatech.mule.game.player;

import java.util.Random;

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
		"Though the empress herself is said to be a " 
		+ "humanoid, the rest of her assumed race lives in poverty. " 
		+ "Most humanoids work as farmers, servants, or men-for-hire.", 
		600, new String[]{"Jimbo", "John", "Oswald", "Bob",
			"Matthew", "Andrew", "Aiden", "Nathaniel", 
			"Jacob", "Ryan", "Oliver", "Elliot", "Aaron", 
			"Alexander", "Ian", "Nolan", "Henry", "Zachary",
			"Xavier", "Elisha", "Christopher"}),
	
	/**
	 * Bonzoid:the monkey race that apparently reminds someone of Colonel Mustard.
	 */
	BONZOID("Bonzoid", 
			"Despite their bulky size, Bonzoids are a peaceful race. "
			+ "Many work as tailors, blacksmiths, carpenters, and shopowners.", 
			new String[]{"Colonel Mustard", "George", "Brer Gorilla"}),
	
	/**
	 * Mechtron:playable only for AI
	 */
	MECHTRON("Mechtron", 
			"Mechtrons are machines created to do the will of the empress. " 
			+ "They are stronger, faster, and more alter than any race in the empire. " 
			+ "Players cannot control Mechtrons; selecting one creates an npc.",
			new String[]{"Tin Major", "Cyborg"}),
	
	/**
	 * Flapper:only race where starting money is higher than the default
	 */
	FLAPPER("Flapper", 
			"The aristocracy of the empire is primarily composed of Flappers. " 
			+ "Their race has accumulated vast riches by establishing trade with far-off lands.", 

			1600, new String[]{"Samantha", "Sally", "Edna", "Susan B. Anthony",
			"Betty Crocker", "Mary Antoinette", "Amelia Earhart", "Queen Elizabeth",
			"Ida B. Wells", "Emma Goldman", "Margaret Fuller", "Betty Friedan"}),
			
	MULE("MULE","The labor force of the empire", 0, new String[]{"The Garbage Man"});
	
	private final static Random randy = new Random();
	
	public static final String IMAGE_EXT = ".png";
	public enum Direction {DOWN, UP, RIGHT, LEFT};
	
	private static final double MONEY = 1000;
	private static final String IMAGE_PATH = "/assets";
	private static final String SPRITES = "/overmap walksprites/";
	private static final String BIG_SPRITES = "/town walksprites/";
	private static final String INDICATORS = "/color indicators/";
	
	private final String sprites;
	private final String big_sprites;
	private final String headshot;
	private final String totem;
	private final double money;
	private final String type;
	private final String[] names;
	private final String description;
	
	/**
	 * Constructor of a character type
	 * @param type, a character's race
	 * @param description, short description of the race
	 * @param money, starting money in the game
	 * @param name, name of the player
	 */
	CharacterType(String type, String description, double money, String[] names) {
		this.type = type.toLowerCase();
		this.description = description;
		this.money = money;
		this.names = names;
		
		//need to add color here instead of + "1"
		this.sprites = IMAGE_PATH + SPRITES + this.type + "/" + this.type.charAt(0) + "1f";
		this.big_sprites = IMAGE_PATH + BIG_SPRITES + this.type + "/" + this.type.charAt(0) + "1s";
		this.headshot = IMAGE_PATH + "/" + this.type.charAt(0);
		this.totem = IMAGE_PATH + INDICATORS;
	}
	
	/**
	 * Constructor of a character type with default money
	 * @param type, name of the race
	 * @param description, short description of the race
	 * @param defaultName, a default name for the player
	 */
	CharacterType(String type, String description, String[] names) {
		this(type, description, MONEY, names);
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
	public String[] getDirectionalSprites(Direction direction, boolean big) {
		if(big) return getBigDirectionalSprites(direction);
		int base = 3*direction.ordinal() + 1;
		return new String[]{sprites + (base+1) + IMAGE_EXT, sprites + (base+2) + IMAGE_EXT};
	}
	
	private String[] getBigDirectionalSprites(Direction direction) {
		String dir = 
				direction == Direction.DOWN  ? "f" :
				direction == Direction.UP    ? "b" :
				direction == Direction.RIGHT ? "r" :
				direction == Direction.LEFT  ? "l" :
				"";
		String[] res = new String[5];
		for(int i=0;i<5;i++) {
			res[i] = big_sprites + dir + "f" + (i+1) + IMAGE_EXT;
		}
		return res;
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
		return names[randy.nextInt(names.length)];
	}

	/**
	 * Get the description
	 * @return description
	 */
	public String getDescripion() {
		return description;
	}
	
	public String getType() {
		return type.substring(0,1).toUpperCase()+type.substring(1);
	}

}
