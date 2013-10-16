package edu.gatech.mule.game;

/**
 * Representation of a player in the game
 * Specifications of the player in the game depends on character type
 * 
 * @author Ice Shirok
 */
public class Player {
	
	private String name;
	private CharacterType type;
	private int money;
	// private Color color
	
	/**
	 * Constructor for player based on player type
	 * 
	 * @param type, the character type of the player
	 */
	public Player(CharacterType type) {
		this.type = type;
	}
	
	/**
	 * Get the name of the player
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
		
	/**
	 * Get the amount of money the player has
	 * @return the amount of money the player has
	 */
	public int getMoney() {
		return money;
	}

	/*
	 * need other getters to get stuff from the character type
	 * since these define the player
	 */
	
	// should be implemented for M6
	// public boolean buyProperty();
	// public boolean sellProperty();
	// public String getName();
	// public Color getColor();
	// etc.
	
	// implement later
	// public boolean buyResource();
	// public boolean sellResource();
	
}
