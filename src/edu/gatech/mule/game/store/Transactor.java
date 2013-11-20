package edu.gatech.mule.game.store;

/**
 * Set up for anything that deals with transactions.
 * @version 1.0
 */
public interface Transactor {

	/**
	 * Transaction of buying.
	 * @param transaction of resources and money
	 * @param buyer of the transaction
	 * @return true if transaction is successful, false otherwise
	 */
	boolean sell(Transaction transaction, Transactor buyer);

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
}
