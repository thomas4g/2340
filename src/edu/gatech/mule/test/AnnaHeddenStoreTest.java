//package edu.gatech.mule.test;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import edu.gatech.mule.game.player.CharacterType;
//import edu.gatech.mule.game.player.Player;
//import edu.gatech.mule.game.resources.ResourceType;
//import edu.gatech.mule.game.store.Store;
//import edu.gatech.mule.game.store.Transaction;
//
////Testing the sell method in edu.gatech.mule.game.store :U
//public class AnnaHeddenStoreTest {
//
//	@Test
//	//make sure that the player cannot buy things when the store does not have them.
//	public void testBadStore() {
//		Store badStore = new Store(new int[5],new int[5]);
//		Player p = new Player(CharacterType.BONZOID);
//		p.addMoney(2000);
//
//		Transaction noEnergy = new Transaction(new int[]{1,0,0,0,0},new int[]{100,0,0,0,0});
//		Transaction noFood = new Transaction(new int[]{0,3,0,0,0},new int[]{0,200,0,0,0});
//		Transaction noCrystite = new Transaction(new int[]{0,0,5,0,0},new int[]{0,0,50,0,0});
//		Transaction noSmithore = new Transaction(new int[]{0,0,0,6,0},new int[]{0,0,0,500,0});
//		Transaction noMule = new Transaction(new int[]{0,0,0,0,10},new int[]{0,0,0,0,2});
//
//		//make sure the transaction didn't happen
//		assertEquals(false,badStore.sell(noEnergy, p));
//		assertEquals(false,badStore.sell(noFood, p));
//		assertEquals(false,badStore.sell(noCrystite, p));
//		assertEquals(false,badStore.sell(noSmithore, p));
//		assertEquals(false,badStore.sell(noMule, p));
//	}
//
//	@Test
//	//make sure that the player cannot buy things when they don't have money
//	public void testBadBuyer() {
//		Store s = new Store(new int[]{5,10,20,2,300},new int[]{100,200,50,100,30});
//
//		Player badPlayer = new Player(CharacterType.BONZOID);
//		badPlayer.subtractMoney(1000);
//		badPlayer.setResources(new int[]{0,0,0,0,0});
//
//		Transaction hasEnergy = new Transaction(new int[]{1,0,0,0,0},new int[]{100,0,0,0,0});
//		Transaction hasFood = new Transaction(new int[]{0,3,0,0,0},new int[]{0,200,0,0,0});
//		Transaction hasCrystite = new Transaction(new int[]{0,0,5,0,0},new int[]{0,0,50,0,0});
//		Transaction hasSmithore = new Transaction(new int[]{0,0,0,6,0},new int[]{0,0,0,100,0});
//		Transaction hasMule = new Transaction(new int[]{0,0,0,0,10},new int[]{0,0,0,0,30});
//
//		//make sure the transaction didn't happen
//		assertEquals(false,s.sell(hasEnergy, badPlayer));
//		assertEquals(false,s.sell(hasFood, badPlayer));
//		assertEquals(false,s.sell(hasCrystite, badPlayer));
//		assertEquals(false,s.sell(hasSmithore, badPlayer));
//		assertEquals(false,s.sell(hasMule, badPlayer));
//	}
//
//	@Test
//	//makes sure the player can buy things when they have money and the store has resources
//	public void testNormalStore() {
//		Store s = new Store(new int[]{5,10,20,2,300},new int[]{100,200,50,100,30});
//
//		Player p = new Player(CharacterType.BONZOID);
//		p.setResources(new int[]{0,0,0,0,0});
//		p.addMoney(19000);
//
//		Transaction hasEnergy = new Transaction(new int[]{1,0,0,0,0},new int[]{100,0,0,0,0});
//		//19900, 4
//		Transaction hasFood = new Transaction(new int[]{0,3,0,0,0},new int[]{0,200,0,0,0});
//		//19300, 7
//		Transaction hasCrystite = new Transaction(new int[]{0,0,5,0,0},new int[]{0,0,50,0,0});
//		//19050, 15
//		Transaction hasSmithore = new Transaction(new int[]{0,0,0,2,0},new int[]{0,0,0,100,0});
//		//18850, 0
//		Transaction hasMule = new Transaction(new int[]{0,0,0,0,10},new int[]{0,0,0,0,30});
//		//18550, 290
//
//		//did the transaction happen?
//		assertEquals(true,s.sell(hasEnergy, p));
//		assertEquals(true,s.sell(hasFood, p));
//		assertEquals(true,s.sell(hasCrystite, p));
//		assertEquals(true,s.sell(hasSmithore, p));
//		assertEquals(true,s.sell(hasMule, p));
//
//		//does the player have the right amount of money?
//		assertEquals(18550,(int)p.getMoney());
//
//		//does the player have the right amount of resources?
//		assertEquals(1,p.getResourceAmount(ResourceType.ENERGY));
//		assertEquals(3,p.getResourceAmount(ResourceType.FOOD));
//		assertEquals(5,p.getResourceAmount(ResourceType.CRYSTITE));
//		assertEquals(2,p.getResourceAmount(ResourceType.SMITHORE));
//		assertEquals(10,p.getResourceAmount(ResourceType.MULE));
//
//		//does the store have the right amount of resources?
//		int[] n = new int[]{4,7,15,0,290};
//		for(int i=0;i<5;i++) {
//			assertEquals(n[i],s.getResources()[i]);;
//		}
//	}
//}
