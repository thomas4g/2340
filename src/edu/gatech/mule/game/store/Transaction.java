package edu.gatech.mule.game.store;

/**
 * Representation of a transaction, containing resources and associated cost.
 * @version 1.0
 */
public class Transaction {

	private int[] resources;
	private int[] prices;

	/**
	 * Constructor of transaction.
	 * @param resources associated with transaction
	 * @param prices associated with transaction
	 */
	public Transaction(int[] resources, int[] prices) {
		this.resources = resources;
		this.prices = prices;
	}

	/**
	 * Returns resources in transaction.
	 * @return resources in transaction
	 */
	public int[] getResources() {
		return this.resources;
	}

	/**
	 * Returns prices in transaction.
	 * @return prices in transaction.
	 */
	public int[] getPrices() {
		return this.getPrices();
	}

	/**
	 * Get total price in transaction.
	 * @return the total price in transaction
	 */
	public int getTotal() {
		int total = 0;
		for(int x = 0; x < resources.length; x++) {
			total += resources[x] * prices[x];
		}
		return total;
	}
}
