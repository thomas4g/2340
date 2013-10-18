package edu.gatech.mule.game.map;

/**
 * 
 * Library of tile types
 * 
 * @version 1.0
 *
 */
public enum TileType {

	RIVER(true, 4, 2, 0, ""),
	PLAIN(true, 2, 3, 1, ""),
	MOUNTAIN1(true, 1, 1, 2, ""),
	MOUNTAIN2(true, 1, 1, 3, ""),
	MOUNTAIN3(true, 1, 1, 4, ""),
	
	TOWNTILE(false, 0, 0, 0, ""),
	EXITTOWN(false, 0, 0, 0, ""),
	ENTERTOWN(false, 0, 0, 0, "");
	
	private boolean purchasable;
	private int foodRate, energyRate, oreRate;
	private String fileName;
	
	/**
	 * Constructor for the tile type
	 * 
	 * @param purchasable, designates whether a tile is buyable or not
	 * @param foodRate, the rate of food to be produced
	 * @param energyRate, the rate of energy to be produced
	 * @param oreRate, the rate of ore to be produced
	 * @param fileName, the filename of the tile picture
	 */
	private TileType(boolean purchasable, int foodRate, int energyRate, int oreRate, String fileName) {
		this.purchasable = purchasable;
		this.foodRate = foodRate;
		this.energyRate = energyRate;
		this.oreRate = oreRate;
		this.fileName = fileName;
	}
	
	/**
	 * ???
	 */
	public boolean isPurchasable() {
		return this.purchasable;
	}
	
	/**
	 * ???
	 */
	public int getFoodRate() {
		return this.foodRate;
	}
	
	/**
	 * ???
	 */
	public int getEnergyRate() {
		return this.energyRate;
	}
	
	/**
	 * ???
	 */
	public int getOreRate() {
		return this.oreRate;
	}
	
	/**
	 * ???
	 */
	public String getFileName() {
		return this.fileName;
	}
}
