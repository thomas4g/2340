package edu.gatech.mule.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tiled.core.Tile;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.map.tiles.PropertyTile;
import edu.gatech.mule.map.tiles.TileType;

/**
 * Testing the method: edu.gatech.mule.game.player.Player.addLand.
 * @author Susanna Dong
 */
public class SusannaDong {

	private Player bonzoid;
	private Player flapper;

	private GameTile tile1;
	private ArrayList<GameTile> gameTiles;

	@Before
	public void setUpPlayer() {
		bonzoid = new Player(CharacterType.BONZOID);
		flapper = new Player(CharacterType.FLAPPER);

		tile1 = new PropertyTile(new Tile(), TileType.RIVER);

		gameTiles = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			gameTiles.add(new PropertyTile(new Tile(), TileType.RIVER));
			gameTiles.add(new PropertyTile(new Tile(), TileType.PLAIN));
			gameTiles.add(new PropertyTile(new Tile(), TileType.MOUNTAIN2));
		}
	}

	@Test
	public void basic() {
		// first test
		assertEquals(true, bonzoid.addLand(tile1, true));
		assertEquals(true, 1000.0 == bonzoid.getMoney());
		assertEquals(false, bonzoid.addLand(tile1, true));
		assertEquals(false, bonzoid.addLand(tile1, false));
		assertEquals(true, 1000.0 == bonzoid.getMoney());

		assertEquals(false, bonzoid.addLand(new PropertyTile(new Tile(),
											TileType.TOWN), true));
		assertEquals(false, bonzoid.addLand(new PropertyTile(new Tile(),
											TileType.RESOURCE_STORE), true));
	}

	@Test
	public void test() {
		// bonzoid getting free land
		for(int i = 0; i < 2; i++) {
			assertEquals(true, bonzoid.addLand(gameTiles.get(i), true));
		}
		for(int i = 0; i < 2; i++) {
			assertEquals(false, bonzoid.addLand(gameTiles.get(i), true));
		}
		assertEquals(true, 2 == bonzoid.getLands().size());
		assertEquals(true, 1000.0 == bonzoid.getMoney());

		// bonzoid purchasing land
		for(int i = 2; i < 5; i++) {
			assertEquals(true, bonzoid.addLand(gameTiles.get(i), false));
		}
		for(int i = 5; i < 10; i++) {
			assertEquals(false, bonzoid.addLand(gameTiles.get(i), false));
		}
		assertEquals(true, 5 == bonzoid.getLands().size());
		assertEquals(true, 100.0 == bonzoid.getMoney());

		// flapper purchasing land
		assertEquals(true, 1600.0 == flapper.getMoney());
		for(int i = 5; i < 10; i++) {
			assertEquals(true, flapper.addLand(gameTiles.get(i), false));
		}
		for(int i = 0; i < 10; i++) {
			assertEquals(false, flapper.addLand(gameTiles.get(i), true));
		}
		for(int i = 0; i < 10; i++) {
			assertEquals(false, flapper.addLand(gameTiles.get(i), false));
		}
		assertEquals(true, 5 == flapper.getLands().size());
		assertEquals(true, 100.0 == flapper.getMoney());

		// checking ownership of land via testing array of tiles
		for(int i = 0; i < 5; i++) {
			assertEquals(bonzoid, gameTiles.get(i).getOwner());
		}
		for(int i = 5; i < 10; i++) {
			assertEquals(flapper, gameTiles.get(i).getOwner());
		}

		// checking owner of land via player array of tile
		for(int i = 0; i < 5; i++) {
			System.out.println(flapper.getLands().get(i));
			System.out.println(gameTiles.get(i));
			assertEquals(true, bonzoid.getLands().get(i) == gameTiles.get(i));
		}
		for(int i = 0; i < 5; i++) {
			assertEquals(false, flapper.getLands().get(i) == gameTiles.get(i));
		}
		for(int i = 0; i < 5; i++) {
			assertEquals(true, flapper.getLands().get(i) == gameTiles.get(i+5));
		}
	}

}
