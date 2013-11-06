package edu.gatech.mule.game.store;


/**
 * Representation of a general store
 * @version 0.1
 */
public class Store implements Transactor {
	
	private int[] resources;
	private int[] prices;
	
	public Store(int[] resources, int[] prices) {
		this.resources = resources;
		this.prices = prices;
	}
	
	@Override
	public boolean sell(Transaction transaction, Transactor buyer) {
		if(!buyer.canAfford(transaction) || !hasResources(transaction.getResources()))
			return false;
		
		int total = transaction.getTotal();
		buyer.subtractMoney(total);
		this.subtractResources(transaction.getResources());
		buyer.addResources(transaction.getResources());
		return true;
	}
	
	private boolean hasResources(int[] transactionResources) {
		for(int i=0; i<resources.length; i++) {
			if(resources[i] - transactionResources[i] < 0)
				return false;
		}
		return true;
	}
	
	
	@Override
	public boolean canAfford(Transaction transaction) {
		return true;
	}
	
	@Override
	public void addResources(int[] resources) {
		for(int i=0; i < this.resources.length; i++) {
			this.resources[i] += resources[i];
		}
	}
	
	@Override
	public void subtractResources(int[] resources) {
		for(int i=0; i < this.resources.length; i++) {
			this.resources[i] -= resources[i];
		}
	}
    
    public int[] getResources() {
    	return this.resources;
    }    
    
    public int[] getPrices() {
    	return this.prices;
    }
    
    public void setPrice(int index, int price) {
    	prices[index] = price;
    }
	
	@Override
	public void addMoney(int money) {}
	
	@Override
	public void subtractMoney(int money) {}
}
