package edu.gatech.mule.game;

import edu.gatech.mule.screen.screens.AbstractPlayerScreen.Color;

/**
 * Library of character types
 * 
 * Contains listings of races with corresponding name, description, and images
 * 
 * @version 1.0
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
		600, "human.gif", "human_head.png"),
	
	/**
	 * Bonzoid
	 * 
	 * The monkey race that apparently reminds someone of Colonel Mustard.
	 */
	BONZOID("Bonzoid", 
			"Despite their bulky size, Bonzoids are a peaceful race. \n"
			+ "Many work as tailors, blacksmiths, carpenters,  \nand shopowners.", 
			"bonzoid.gif", "bonzoid_head.png"),
	/**
	 * Mechtron
	 * 
	 * Only available for AI, go marching band!
	 */
	MECHTRON("Mechtron", 
			"Mechtrons are machines created to do the will of the empress. \n" 
			+ "They are stronger, faster, and more alter than any race in the empire. \n" 
			+ "Players cannot control Mechtrons; selecting one creates an npc.", 
			"mechtron.gif", "mechtron_head.png"),
	
	/**
	 * Flapper
	 * 
	 * Only race where starting money is higher than the default
	 */
	FLAPPER("Flapper", 
			"The aristocracy of the empire is primarily composed\nof Flappers. " 
			+ "Their race has accumulated vast riches by\nestablishing trade with far-off lands.", 
			1600, "flapper.gif", "flapper.png");
	
	private static final double MONEY = 1000;
	private static final String IMAGE_PATH = "resources/";
	
	public final String sprite;
	public final String headshot;
	public final double money;
	public final String name;
	public final String descrip;
	public static Color color;
	public static String title;
	
	/**
	 * Constructor of a character type
	 * 
	 * @param name, name of the race
	 * @param description, short description of the race
	 * @param money, starting money in the game
	 * @param sprite, world sprite filename
	 * @param headshot, headshot filename
	 */
	CharacterType(String name, String description, double money, String sprite, String headshot) {
		this.sprite = IMAGE_PATH + sprite;
		this.headshot = IMAGE_PATH + headshot;
		this.money = money;
		this.descrip = description;
		this.name = name;
	}
	
	/**
	 * Constructor of a character type with default money
	 *  
	 * @param name, name of the race
	 * @param description, short description of the race
	 * @param money, starting money in the game
	 * @param sprite, world sprite filename
	 * @param headshot, headshot filename
	 */
	CharacterType(String name, String description, String sprite, String headshot) {
		this(name, description, MONEY, sprite, headshot);
	}
	
}
