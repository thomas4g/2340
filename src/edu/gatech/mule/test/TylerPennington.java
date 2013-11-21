package edu.gatech.mule.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tiled.core.Tile;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.map.tiles.PropertyTile;
import edu.gatech.mule.map.tiles.TileType;

//testing mule production
public class TylerPennington {

	@Test
	public void testOneMule() {
		Player player = new Player(CharacterType.BONZOID);
		player.setResources(new int[5]);
		Mule mule = new Mule(player, player.getType());
		mule.setType(ResourceType.FOOD);
		GameTile tile = new PropertyTile(new Tile(), TileType.PLAIN);
		mule.emplace(tile);
		player.addPlacedMule(mule);

		mule.produce();
		assertEquals(2, player.getResourceAmount(ResourceType.FOOD));
	}
	
	@Test
	public void testMultiMules() {
		GameTile plainTile = new PropertyTile(new Tile(), TileType.PLAIN);
		GameTile m1Tile = new PropertyTile(new Tile(), TileType.MOUNTAIN1);
		GameTile riverTile = new PropertyTile(new Tile(), TileType.RIVER);
		
		Player player = new Player(CharacterType.BONZOID);
		player.setResources(new int[5]);
		
		Mule energyMule = new Mule(player, player.getType());
		energyMule.setType(ResourceType.ENERGY);
		energyMule.emplace(plainTile);

		Mule oreMule = new Mule(player, player.getType());
		oreMule.setType(ResourceType.SMITHORE);
		oreMule.emplace(m1Tile);
		
		Mule foodMule = new Mule(player, player.getType());
		foodMule.setType(ResourceType.FOOD);
		foodMule.emplace(riverTile);
		
		player.addPlacedMule(energyMule);
		player.addPlacedMule(oreMule);
		player.addPlacedMule(foodMule);
		
		for(Mule mule : player.getPlacedMules())
			mule.produce();
		
		assertEquals(3, player.getResourceAmount(ResourceType.ENERGY));
		assertEquals(2, player.getResourceAmount(ResourceType.SMITHORE));
		assertEquals(4, player.getResourceAmount(ResourceType.FOOD));
	}
}
