package edu.gatech.mule.game;

import java.util.Random;

import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Color;
import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.map.tiles.GameTile;

/**
 * Representative of a mule.
 * @version 1.0
 */
public class Mule extends Entity {

	/**
	 * Yay serial version U ID.
	 */
	private static final long serialVersionUID = 462367184641862973L;
	private CharacterType type;
	private GameTile tile;
	private boolean placed;
	private Player owner;
	private ResourceType resourceType;
	private boolean big;
	private boolean enslaved;
	private Random rand;

	public static final int FREEDOM_SPEED = 5;

	/**
	 * Constructor for a mule.
	 * @param owner of the mule
	 * @param type of the mule by resource
	 */
	public Mule(Player owner, CharacterType type) {
		super(type.getStillSprite(owner.getDirection(), Color.PURPLE), owner.getPosition());
		this.type = type;
		this.owner = owner;
		this.enslaved = true;
		rand = new Random();
		color = Color.BLUE;
	}

	/**
	 * Moves mule.
	 */
	public void move() {
		switch(owner.getDirection()) {
			case DOWN:
				location.setLocation(
						owner.getPosition().getX(),
						owner.getPosition().getY() - 2 * owner.getImage().getHeight());
				break;
			case RIGHT:
				location.setLocation(
						owner.getPosition().getX() - 2 * owner.getImage().getWidth(),
						owner.getPosition().getY());
				break;
			case LEFT:
				location.setLocation(
						owner.getPosition().getX() + 2 * owner.getImage().getWidth(),
						owner.getPosition().getY());
				break;
			case UP:
				location.setLocation(
						owner.getPosition().getX(),
						owner.getPosition().getY() + 2 * owner.getImage().getHeight());
				break;
			default:
				break;
		}
		setDirection(owner.getDirection());
	}

	/**
	 * Sets direction of mule.
	 * @param direction of mule
	 */
	public void setDirection(Direction direction) {
		super.setDirection(direction);
		setDirectionalFrames();
	}

	/**
	 * Adjusts sprites for big or small sprites.
	 * @param big true if need big sprites, false otherwise
	 */
	public void useBigSprites(boolean big) {
		this.big = big;
		setDirectionalFrames();
	}

	/**
	 * Set the directional frames based on direction.
	 */
	public void setDirectionalFrames() {
		setFrames(type.getDirectionalSprites(direction, big, color));
	}

	/**
	 * Get type of mule.
	 * @return type of mule
	 */
	public ResourceType getType() {
		return resourceType;
	}

	/**
	 * Place the mule on a tile.
	 * @param tile the mule will be placed at
	 */
	public void emplace(GameTile tile) {
		placed = true;
		this.tile = tile;
	}

	/**
	 * Returns whether a mule is placed on a tile.
	 * @return true if placed on tile, false otherwise
	 */
	public boolean isPlaced() {
		return placed;
	}

	/**
	 * Moving while running.
	 * @param x horizontal speed at which mule runs away
	 * @param y vertical speed at which mule runs away
	 */
	public void run(int x, int y) {
		location.x += x;
		location.y += y;
	}

	/**
	 * Method for when mule is running away.
	 */
	public void sweetFreedom() {
		run(-1 * rand.nextInt(FREEDOM_SPEED), -1 * rand.nextInt(FREEDOM_SPEED));
	}

	/**
	 * Determines whether out of bounds or not.
	 * @return true if out of bounds, false otherwise
	 */
	public boolean outOfBounds() {
		if(location.x < 0 || location.y < 0) {
			return true;
		}
		return false;
	}

	/**
	 * Mule is no longer owned by an owner.
	 */
	public void emancipate() {
		enslaved = false;
	}

	/**
	 * Returns whether mule is owned by player or not.
	 * @return true if is owned by player, false otherwise
	 */
	public boolean isEnslaved() {
		return enslaved;
	}

	/**
	 * Produce resources if on a tile.
	 */
	public void produce() {
		if(tile == null || owner.getResourceAmount(ResourceType.ENERGY) == 0) {
			return;
		}

		owner.changeResourceAmount(ResourceType.ENERGY, -1);
		int[] resources = new int[ResourceType.values().length];
		int production = 0;
		switch(resourceType) {
		case FOOD:
			production = tile.getType().getFoodRate();
			break;
		case ENERGY:
			production = tile.getType().getEnergyRate();
			break;
		case SMITHORE:
			production = tile.getType().getOreRate();
			break;
		default:
			break;
		}

		production += production * owner.getProductionCoeficients()[resourceType.ordinal()];
		resources[resourceType.ordinal()] = production;
		owner.addResources(resources);
	}

	/**
	 * Sets the type of resource the mule is in.
	 * @param type by resource
	 */
	public void setType(ResourceType type) {
		resourceType = type;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || !(o instanceof Mule)) {
			return false;
		}
		Mule other = (Mule) o;
		return enslaved == other.enslaved && resourceType.equals(other.resourceType)
			&& placed == other.placed && (placed) ? (tile.equals(other.tile)) : true;
	}

	@Override
	public int hashCode() {
		return (enslaved ? 1 : 0) + resourceType.hashCode() + (placed ? 1 : 0) + tile.hashCode();
	}
}
