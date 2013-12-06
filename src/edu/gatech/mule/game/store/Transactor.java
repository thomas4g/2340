package edu.gatech.mule.game.store;

/**
 * Set up for anything that deals with transactions.
 * @version 1.0
 */
public interface Transactor {

	/**
	 * Determines whether able to afford to purchase transaction.
	 * @param transaction of resources and money
	 * @return true if can afford, false otherwise
	 */
	boolean canAfford(Transaction transaction);

	/**
	 * Add money.
	 * @param money to be added
	 */
	void addMoney(int money);

	/**
	 * Subtract money.
	 * @param money to be subtracted
	 */
	void subtractMoney(int money);

	/**
	 * Add resources.
	 * @param resources to be added
	 */
	void addResources(int[] resources);

	/**
	 * Subtract resources.
	 * @param resources to be subtracted
	 */
	void subtractResources(int[] resources);

	/**
	 * Determines whether the transactor has at least as many resources as specified.
	 * @param resources rawr
	 * @return true if has enough resources
	 */
	boolean hasResources(int[] resources);
}
