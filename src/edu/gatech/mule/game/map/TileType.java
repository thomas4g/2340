package edu.gatech.mule.game.map;

/**
 * Library of tile types
 * @version 0.1
 */
public enum TileType {

	RIVER(true, 4, 2, 0),
	PLAIN(true, 2, 3, 1),
	MOUNTAIN1(true, 1, 1, 2),
	MOUNTAIN2(true, 1, 1, 3),
	MOUNTAIN3(true, 1, 1, 4),
	
	TOWNTILE(false, 0, 0, 0),
	EXITTOWN(false, 0, 0, 0),
	ENTERTOWN(false, 0, 0, 0);
	
	private boolean purchasable;
	private int foodRate, energyRate, oreRate;
	
	/**
	 * Constructor for the tile type
	 * 
	 * @param purchasable, designates whether a tile is buyable or not
	 * @param foodRate, the rate of food to be produced
	 * @param energyRate, the rate of energy to be produced
	 * @param oreRate, the rate of ore to be produced
	 * @param fileName, the filename of the tile picture
	 */
	private TileType(boolean purchasable, int foodRate, int energyRate, int oreRate) {
		this.purchasable = purchasable;
		this.foodRate = foodRate;
		this.energyRate = energyRate;
		this.oreRate = oreRate;
	}
	
	/**
	 * Get whether tile is purchasable
	 * @return true if purchasable, false otherwise
	 */
	public boolean isPurchasable() {
		return this.purchasable;
	}
	
	/**
	 * Get the food rate of the tile
	 * @return food rate
	 */
	public int getFoodRate() {
		return this.foodRate;
	}
	
	/**
	 * Get the energy rate of the tile
	 * @return energy rate
	 */
	public int getEnergyRate() {
		return this.energyRate;
	}
	
	/**
	 * Get the ore rate of the tile
	 * @return ore rate
	 */
	public int getOreRate() {
		return this.oreRate;
	}
}
