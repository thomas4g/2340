package edu.gatech.mule.game;

/**
 * 
 * Representation of a player in the game
 * Specifications of the player in the game depends on character type
 * 
 * @author Ice Shirok
 *
 */
public class Player {
	
	private CharacterType type;
	
	/**
	 * Constructor for player based on player type
	 * 
	 * @param type, the character type of the player
	 */
	public Player(CharacterType type) {
		this.type = type;
	}
}
