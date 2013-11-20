package edu.gatech.mule.game.player;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.game.round.Turn;
import edu.gatech.mule.game.store.Transaction;
import edu.gatech.mule.game.store.Transactor;
import edu.gatech.mule.map.tiles.GameTile;

/**
 * Representation of a player in the game.
 * Specifications of the player in the game depends on character type
 * @version 1.0
 */
public class Player extends Entity implements Transactor, Comparable<Player> {

	private static final long serialVersionUID = 8084124341892295959L;
	private transient BufferedImage headshot;
	private transient BufferedImage totem;
	private Turn currentTurn;
	private CharacterType type;
	private String name;
	private double money;
	private List<GameTile> ownedLands;
	private int[] resources;
	private Mule mule;
	private List<Mule> placedMules;
	private boolean big;
	private double[] productionCoefs;
	private int score;

	/**
	 * Constructor for a player.
	 * @param type type of character
	 */
	public Player(CharacterType type) {
		//needs a default color, hence the purple
		super(type.getStillSprite(Direction.RIGHT, Color.PURPLE), new Point(0, 0));
		this.type = type;
		this.money = type.getMoney();
		this.productionCoefs = new double[ResourceType.values().length];
		this.placedMules = new ArrayList<>();
		this.ownedLands = new ArrayList<>();
		this.setDirection(Direction.DOWN);
	}

	@Override
	public void setDirection(Direction direction) {
		super.setDirection(direction);
		setDirectionalFrames();
	}

	/**
	 * Used by map controllers to control whether or not a player uses the big sprites.
	 * Also sets it on mules.
	 * @param big big or small
	 */
	public void useBigSprites(boolean big) {
		this.big = big;
		setDirectionalFrames();
		if(mule != null) {
			//TODO make useBigSprites() a method in Entity
			mule.useBigSprites(big);
		}
	}

	/**
	 * sets the player's score.
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * gets the score.
	 * @return the player's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Set the name of the player.
	 * @param name name of player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the color of the player.
	 * @param color color of player
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Get name of player.
	 * @return name of player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get color of player.
	 * @return color of player
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * updates the directional frames.
	 * This refreshes the frames being displayed.
	 */
	public void setDirectionalFrames() {
		setFrames(type.getDirectionalSprites(direction, big, color));
	}

	/**
	 * Get character type of player.
	 * @return character type of player
	 */
	public CharacterType getType() {
		return type;
	}

	/**
	 * sets the turn.
	 * @param turn the new turn
	 */
	public void setCurrentTurn(Turn turn) {
		this.currentTurn = turn;
	}

	/**
	 * gets the player's turn.
	 * @return the player's turn
	 */
	public Turn getCurrentTurn() {
		return this.currentTurn;
	}

	/**
	 * Set the still sprite.
	 */
	public void setStillSprite() {
		image = loadImage(type.getStillSprite(direction, color));
	}

	/**
	 * Set the directional frames ???
	 */

	/**
	 * Add a property to a player's possession.
	 * @param tile tile the player is possessing
	 * @param free true if land is free, false if need to purchase
	 * @return true if land is in player's possession, false otherwise
	 */
	public boolean addLand(GameTile tile, boolean free) {
		if(tile.getOwner() != null) {
			return false;
		}

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
	 * Get player's owned lands.
	 * @return player's owned lands
	 */
	public List<GameTile> getLands() {
		return ownedLands;
	}

	/**
	 * Set's the player's mule.
	 * @param mule the new mule for this player
	 */
	public void setMule(Mule mule) {
		this.mule = mule;
	}

	/**
	 * Get's the player's mule.
	 * @return THE PLAYERS MULE
	 */
	public Mule getMule() {
		return mule;
	}

	/**
	 * Checks if the player has a mule.
	 * @return true if player has a mule; false otherwise
	 */
	public boolean hasMule() {
		return mule != null;
	}

	//TODO get rid of these and only access mules through owned properties
	// Then we would call property.produce() which would call it on each of a
	// property's mules.

	/**
	 * adds a placed mule.
	 * @param mule a new placed mule
	 */
	public void addPlacedMule(Mule mule) {
		placedMules.add(mule);
	}

	/**
	 * removes a placed mule.
	 * @param mule the mule to remove.
	 */
	public void removePlacedMule(Mule mule) {
		placedMules.remove(mule);
	}

	/**
	 * Gets all the placed mules.
	 * @return a list of the placed mules.
	 */
	public List<Mule> getPlacedMules() {
		return this.placedMules;
	}

	/**
	 * Get image of totem.
	 * @return image of totem
	 */
	public BufferedImage getTotem() {
		if(this.totem == null) {
			this.totem = loadImage(type.getTotem(color.ordinal() + 1));
		}
		return this.totem;
	}

	/**
	 * Get image of headshot.
	 * @return image of headshot
	 */
	public BufferedImage getHeadshot() {
		if(this.headshot == null) {
			this.headshot = loadImage(type.getHeadshot(color.ordinal() + 1));
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
			+ " | Color: " + color + " | Race: " + type.name()
			+ resourcesString;
	}

	/**
	 * Creates a string out resources.
	 * @return a string representing all the resources this player owns
	 */
	public String getResourceString() {
		String resourcesString = "\n";
		for(int i = 0; i < resources.length; i++) {
			resourcesString += ResourceType.values()[i].toString() + ": " + resources[i] + "\n";
		}
		return name + "\n$" + (int) money + resourcesString;
	}


	@Override
	public boolean sell(Transaction transaction, Transactor buyer) {
		if(!buyer.canAfford(transaction) || !this.hasResources(transaction.getResources())) {
			return false;
		}

		int total = transaction.getTotal();
		buyer.subtractMoney(total);
		this.subtractResources(transaction.getResources());
		buyer.addResources(transaction.getResources());
		this.addMoney(total);
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
		return transaction.getTotal() <= this.money;
	}

	@Override
	public void addMoney(int money) {
		this.money += money;
	}

	/**
	 * moneys yo.
	 * @return the player's money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * checks if the player has any money.
	 * @return true if money > 0
	 */
	public boolean hasMoney() {
		return money > 0;
	}

	@Override
	public void subtractMoney(int money) {
		this.money -= money;
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
	 * Set's the player's resources.
	 * @param resources the new resource counts.
	 */
	public void setResources(int[] resources) {
		this.resources = resources;
	}

	/**
	 * Gets the resource count.
	 * @param resource the resource to get the count for
	 * @return the count of that resource
	 */
	public int getResourceAmt(ResourceType resource) {
		return resources[resource.ordinal()];
	}

	/**
	 * gets the coefficients which scale the production of each resource.
	 * @return an array of doubles containing the production boosts for each resource
	 */
	public double[] getProductionCoeficients() {
		return this.productionCoefs;
	}

	/**
	 * Sets the production coefficients.
	 * E.g, if you want to increase the percentage of production by 50%, pass
	 * [.5, .5, .5, .5]
	 * @param pc the production coefficients. see above.
	 */
	public void setProductionCoeficients(double[] pc) {
		this.productionCoefs = pc;
	}

	@Override
	public int compareTo(Player other) {
		return this.score - other.score;
	}

}
