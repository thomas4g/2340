package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.game.map.tiles.PropertyTile;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * Controller for main map screen
 * @version 0.1
 */
public class GameplayController extends MapController {

	public final static int MOVEMENT = 5;
	
	/**
	 * Constructor for game controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public GameplayController(GameEngine game, MapView view) {
		super(game, view, MOVEMENT);
	}
	
	@Override
	public void move(int x, int y) {
		super.move(x, y);
		

		if(currentPlayer.getTileType() == TileType.ENTERTOWN) {
			game.setScreen(ScreenType.TOWN_SCREEN);
		}
	}
	
	public void action(){
		
		GameTile tile=currentPlayer.getTile();
		
		if (currentPlayer.getMule()!=null) {
			if (tile.hasOwner() && tile.getOwner() == currentPlayer && tile instanceof PropertyTile) {
				((PropertyTile)tile).addMule(currentPlayer.getMule());
			} 
			
			entities.remove(currentPlayer.getMule());
			currentPlayer.setMule(null);
		} 
		else{
			System.out.println("tasteless fools!");
		}
		
	}
	
	@Override
	public void load() {
		this.map = game.getGameMap();
		super.load();
		currentPlayer.useBigSprites(false);
		
		Point p = new Point(0, 0);
		Point m=new Point(0,0);
		switch(currentPlayer.getDirection()) {
		case DOWN:
			p.x = (int) map.getMap().getWidth()*map.getTileWidth()/2;
			p.y = (int) map.getMap().getHeight()*map.getTileHeight()/2 + map.getTileHeight()/2;
			m.x=p.x;
			m.y=p.y-currentPlayer.getImage().getHeight();
			break;
		case LEFT:
			p.y = (int) map.getMap().getHeight()*map.getTileHeight()/2;
			p.x = (int) map.getMap().getWidth()*map.getTileWidth()/2 - map.getTileWidth()/2;
			m.x=p.x+currentPlayer.getImage().getWidth();
			m.y=p.y;
			break;
		case RIGHT:
			p.y = (int) map.getMap().getHeight()*map.getTileHeight()/2;
			p.x = (int) map.getMap().getWidth()*map.getTileWidth()/2 + map.getTileWidth()/2;
			m.x=p.x-currentPlayer.getImage().getWidth();
			m.y=p.y;
			break;
		case UP:
			p.y = (int) map.getMap().getHeight()*map.getTileHeight()/2 - map.getTileHeight()/2;
			p.x = (int) map.getMap().getWidth()*map.getTileWidth()/2;
			m.x=p.x;
			m.y=p.y+currentPlayer.getImage().getHeight();
			break;
		default:
			break;
		}
		
		currentPlayer.setPosition(p);
		if(currentPlayer.getMule() != null)
			currentPlayer.getMule().setPosition(new Point(m.x,m.y));
	}
}
