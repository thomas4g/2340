package edu.gatech.mule.game.player;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.map.tiles.GameTile;
import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.game.round.Turn;
import edu.gatech.mule.game.store.Transaction;
import edu.gatech.mule.game.store.Transactor;

/**
 * Representation of a player in the game
 * Specifications of the player in the game depends on character type
 * @version 0.1
 */
public class Player extends Entity implements Transactor, Comparable {
	private BufferedImage headshot;
	private BufferedImage totem;
	
	private Turn currentTurn;
	private CharacterType type;
	private String name;
	private double money;
	private ArrayList<GameTile> ownedLands;
	private int[] resources;
	private Mule mule;
	private boolean big;

    private int score;
	
	/**
	 * Constructor for a player
	 * @param type, type of character
	 */
	public Player(CharacterType type) {
		super(type.getStillSprite(Direction.RIGHT,Color.PURPLE), new Point(0,0));
		this.type = type;
		this.money = type.getMoney();
		this.ownedLands = new ArrayList<>();
		this.setDirection(Direction.DOWN);
	}
	
	@Override
	public void setDirection(Direction direction) {
		super.setDirection(direction);
		setDirectionalFrames();
	}
	
	public void useBigSprites(boolean big) {
		this.big = big;
		setDirectionalFrames();
		if(mule!=null){
			mule.useBigSprites(big);
		}
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	/**
	 * Set the name of the player
	 * @param name, name of player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the color of the player
	 * @param color, color of player
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	/**
	 * Get name of player
	 * @return name of player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get color of player
	 * @return color of player
	 */
	public Color getColor() {
		return color;
	}
	
	
	public void setDirectionalFrames(){
		setFrames(type.getDirectionalSprites(direction, big,color));
	}
	
	/**
	 * Get character type of player
	 * @return character type of player
	 */
	public CharacterType getType() {
		return type;
	}
	
	public void setCurrentTurn(Turn turn) {
		this.currentTurn = turn;
	}
	
	public Turn getCurrentTurn() {
		return this.currentTurn;
	}
	
	/**
	 * Set the still sprite
	 */
	public void setStillSprite(){
		image = loadImage(type.getStillSprite(direction,color));
	}
	
	/**
	 * Set the directional frames ???
	 */
	
	
	/**
	 * Add a property to a player's possession
	 * @param tile, tile the player is possessing
	 * @param free, true if land is free, false if need to purchase
	 * @return true if land is in player's possession, false otherwise
	 */
	public boolean addLand(GameTile tile, boolean free){
		if(!free) {
			this.money -= tile.getCost();
			if(this.money < 0) {
				this.money += tile.getCost();
				return false;
			}
		}
		ownedLands.add(tile);
		tile.setOwner(this);
		return true;
	}
	
	/**
	 * Get player's owned lands
	 * @return player's owned lands
	 */
	public ArrayList<GameTile> getLands() {
		return ownedLands;
	}
	
	public void setMule(Mule mule) {
		this.mule = mule;
	}
	
	public Mule getMule() {
		return mule;
	}
	
	public boolean hasMule() {
		return mule != null;
	}
	
	/**
	 * Get image of totem
	 * @return image of totem
	 */
	public BufferedImage getTotem() {
		if(this.totem == null) {
			this.totem = loadImage(type.getTotem(color.ordinal()+1));
		}
		return this.totem;
	}

	/**
	 * Get image of headshot
	 * @return image of headshot
	 */
	public BufferedImage getHeadshot() {
		if(this.headshot == null) {
			this.headshot = loadImage(type.getHeadshot(color.ordinal()+1));
		}
		return this.headshot;
	}
	
	@Override
	public String toString() {
		String resourcesString = "\n";
		
		for(int i = 0; i < resources.length; i++) {
			resourcesString += ResourceType.values()[i].toString() + ": " + resources[i] + "\n";
		}
		
		return "Name: " + name + " | Money: " + money
			+ " | Color: "+color+" | Race: " + type.name()
			+ resourcesString;
	}
	
	public String display() {
		String resourcesString = "\n";
		for(int i = 0; i < resources.length; i++) {
			resourcesString += ResourceType.values()[i].toString() + ": " + resources[i] + "\n";
		}
		return name + "\n$" + (int)money + resourcesString;
	}
	
	///// working on transactions
	
	@Override
	public boolean sell(Transaction transaction, Transactor buyer) {
		if(!buyer.canAfford(transaction) || !this.hasResources(transaction.getResources()))
			return false;
		
		int total = transaction.getTotal();
		buyer.subtractMoney(total);
		this.subtractResources(transaction.getResources());
		buyer.addResources(transaction.getResources());
		this.addMoney(total);
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
		return transaction.getTotal() <= this.money;
	}
	
	@Override
	public void addMoney(int money) {
		this.money += money;
	}
	
	@Override
	public void subtractMoney(int money) {
		this.money -= money;
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
	
	public void setResources(int[] resources) {
		this.resources = resources;
	}
	
	
	public int getResourceAmt(ResourceType resource) {
	    return resources[resource.ordinal()];
	}

	@Override
	public int compareTo(Object other) {
		return (int) (this.score - ((Player)other).score);
	}
}
