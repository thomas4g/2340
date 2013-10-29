package edu.gatech.mule.game.store;

public class Transaction {

	/**
	 * array of resources involved in the transaction, with their quanities
	 */
	private int[] resources;
	/**
	 * prices corresponding to each resource at the time of the transaction
	 */
	private int[] prices;
	
	public Transaction(int[] resources, int[] prices) {
		this.resources = resources;
		this.prices = prices;
	}
	
	public int[] getResources() {
		return this.resources;
	}
	
	public int[] getPrices() {
		return this.getPrices();
	}
	
	public int getTotal() {
		int total = 0;
		for(int x = 0; x<resources.length; x++) {
			total += resources[x] * prices[x];
		}
		return total;
	}
}
