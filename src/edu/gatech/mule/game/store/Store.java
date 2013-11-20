package edu.gatech.mule.game.store;


/**
 * Representation of a general store.
 * @version 1.0
 */
public class Store implements Transactor {

	private int[] resources;
	private int[] prices;

	/**
	 * Constructor of a store that contains resources and its associated prices.
	 * @param resources in store
	 * @param prices associated with resources
	 */
	public Store(int[] resources, int[] prices) {
		this.resources = resources;
		this.prices = prices;
	}

	@Override
	public boolean sell(Transaction transaction, Transactor buyer) {
		if(!buyer.canAfford(transaction) || !hasResources(transaction.getResources())) {
			return false;
		}

		int total = transaction.getTotal();
		buyer.subtractMoney(total);
		this.subtractResources(transaction.getResources());
		buyer.addResources(transaction.getResources());
		return true;
	}

	private boolean hasResources(int[] transactionResources) {
		for(int i = 0; i < resources.length; i++) {
			if(resources[i] - transactionResources[i] < 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean canAfford(Transaction transaction) {
		return true;
	}

	@Override
	public void addResources(int[] resources) {
		for(int i = 0; i < this.resources.length; i++) {
			this.resources[i] += resources[i];
		}
	}

	@Override
	public void subtractResources(int[] resources) {
		for(int i = 0; i < this.resources.length; i++) {
			this.resources[i] -= resources[i];
		}
	}

	/**
	 * Returns resources in store.
	 * @return resources in store
	 */
    public int[] getResources() {
    	return this.resources;
    }

    /**
     * Returns prices of associated resources.
     * @return prices of associated resources
     */
    public int[] getPrices() {
    	return this.prices;
    }

    /**
     * Sets the price of a resource.
     * @param index position of resource in array
     * @param price new price to be set
     */
    public void setPrice(int index, int price) {
    	prices[index] = price;
    }

	@Override
	public void addMoney(int money) { }

	@Override
	public void subtractMoney(int money) { }
}
