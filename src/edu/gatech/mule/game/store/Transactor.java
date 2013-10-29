package edu.gatech.mule.game.store;

public interface Transactor {

	public boolean sell(Transaction transaction, Transactor buyer);
	
	public boolean canAfford(Transaction transaction);
	public void addMoney(int money);
	public void subtractMoney(int money);
	public void addResources(int[] resources);
	public void subtractResources(int[] resources);
}
