package edu.gatech.mule.game.round;

/**
 * Holds the data for each of the specific rounds.
 * @author dengel6
 *
 */

public enum RoundInfo {

	//ROUNDX (food requirement, gambling bonus)
	ROUND1 (3, 50),
	ROUND2 (3, 50),
	ROUND3 (3, 50),
	ROUND4 (3, 100),
	ROUND5 (4, 100),
	ROUND6 (4, 100),
	ROUND7 (4, 100),
	ROUND8 (4, 150),
	ROUND9 (5, 150),
	ROUND10 (5, 150),
	ROUND11 (5, 150),
	ROUND12 (5, 200);
	private int foodReq;
	private int gambleBonus;

	private RoundInfo(int foodReq, int gambleBonus) {
		this.foodReq = foodReq;
		this.gambleBonus = gambleBonus;
	}

	/**
	 * Return required food.
	 * @return required food
	 */

	public int getFoodReq() {
		return this.foodReq;
	}

	/**
	 * Returns bonus from gambling.
	 * @return gamble bonus
	 */
	public int getGambleBonus() {
		return this.gambleBonus;
	}
}
