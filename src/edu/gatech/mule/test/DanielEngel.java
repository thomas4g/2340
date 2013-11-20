package edu.gatech.mule.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Color;

public class DanielEngel {

	@Test
	public void directionalSpriteTest() {
		
		Direction dirOne=Direction.RIGHT;
		boolean sizeOne=false;
		Color colorOne=Color.GREEN;
		CharacterType typeOne=CharacterType.BONZOID;
		assertEquals("/assets/overmap walksprites/bonzoid/b5f8.png",typeOne.getDirectionalSprites(dirOne, sizeOne, colorOne)[0]);

		Direction dirTwo=Direction.UP;
		boolean sizeTwo=false;
		Color colorTwo=Color.SEAFOAM;
		CharacterType typeTwo=CharacterType.HUMANOID;
		assertEquals("/assets/overmap walksprites/humanoid/h4f5.png",typeTwo.getDirectionalSprites(dirTwo, sizeTwo, colorTwo)[0]);

		Direction dirThree=Direction.DOWN;
		boolean sizeThree=false;
		Color colorThree=Color.ORANGE;
		CharacterType typeThree=CharacterType.FLAPPER;
		assertEquals("/assets/overmap walksprites/flapper/f7f2.png", typeThree.getDirectionalSprites(dirThree, sizeThree, colorThree)[0]);
		
	}

}
