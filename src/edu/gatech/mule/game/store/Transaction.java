package edu.gatech.mule.game.store;

import java.util.Arrays;

/**
 * Representation of a transaction, containing resources and associated cost.
 * @version 1.0
 */
public class Transaction {

	private int[] resources;
	private int[] prices;
	Transactor buyer, seller;

	/**
	 * Constructor of transaction.
	 * @param resources associated with transaction
	 * @param prices associated with transaction
	 */
	public Transaction(int[] resources, int[] prices, Transactor buyer, Transactor seller) {
		this.resources = resources;
		this.prices = prices;
		this.buyer = buyer;
		this.seller = seller;
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
		return this.prices;
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
	
	/**
	 * Performs the transaction.
	 * @return true if transaction was successful
	 */
	public boolean execute() {
		if(!buyer.canAfford(this) || !seller.hasResources(this.resources)) {
			return false;
		}

		int total = getTotal();
		System.out.println(Arrays.toString(resources));
		System.out.println(Arrays.toString(this.prices));
		System.out.println(total);
		buyer.subtractMoney(total);
		seller.subtractResources(this.resources);
		buyer.addResources(this.resources);
		seller.addMoney(total);
		return true;
	}
}
