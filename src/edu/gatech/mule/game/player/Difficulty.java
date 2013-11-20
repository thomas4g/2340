package edu.gatech.mule.game.player;

/**
 * Represents the game's difficulty.
 * @author tshields
 *
 */
public enum Difficulty {

	BEGINNER (new int[] {8, 4, 0, 0}, new int[] {16, 16, 0, 0, 25}),
	STANDARD (new int[] {4, 2, 0, 0}, new int[] {8, 8, 8, 0, 14}),
	ADVANCED (new int[] {4, 2, 0, 0}, new int[] {8, 8, 8, 0, 14});

	private int[] playerResources, storeResources;

	private Difficulty(int[] playerResources, int[] storeResources) {
		this.playerResources = playerResources;
		this.storeResources = storeResources;
	}

	/**
	 * Get's the resources for a player for that difficulty.
	 * @return the resource counts for a player at this difficulty
	 */
	public int[] getPlayerResources() {
		return this.playerResources;
	}

	/**
	 * Get's the stores resource counts.
	 * @return the store's resource counts for this difficulty
	 */
	public int[] getStoreResources() {
		return this.storeResources;
	}
}
