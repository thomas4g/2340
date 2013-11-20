package edu.gatech.mule.test;

import static org.junit.Assert.assertEquals;

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

	private Player player;

	private GameTile tile1;
	private GameTile tile2;
	private GameTile tile3;

	@Before
	public void setUpPlayer() {
		player = new Player(CharacterType.BONZOID);

		tile1 = new PropertyTile(new Tile(), TileType.RIVER);
		tile2 = new PropertyTile(new Tile(), TileType.RIVER);
		tile3 = new PropertyTile(new Tile(), TileType.RIVER);
	}

	@Test
	public void test() {
		System.out.println(player.getMoney());
		assertEquals(true, player.addLand(tile1, true));
		assertEquals(false, player.addLand(tile1, true));
	}

}
