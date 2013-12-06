package edu.gatech.mule.game;

import java.util.Random;

import edu.gatech.mule.game.round.Round;
import edu.gatech.mule.game.round.Turn;

/**
 * Formula for calculating pub gambling.
 * @version 1.0
 */
public final class GamblingFormula {

	private static final Random RAND_GEN = new Random();

	private GamblingFormula() { }

	private static final int MAX_MONEY = 250;

	private static final int THREE = 3;  // wow.
	private static final int FOUR = 4;

	private static int fullTime = Turn.NORMAL_TURN;
	private static int threeQuarterTime = Turn.NORMAL_TURN * THREE / FOUR;
	private static int halfTime = Turn.NORMAL_TURN / 2;
	private static int quarterTime = Turn.NORMAL_TURN / FOUR;

	private static final int FULL_MONEY = 200;
	private static final int THREE_QUARTER_MONEY = FULL_MONEY * THREE / FOUR;
	private static final int HALF_MONEY = FULL_MONEY / 2;
	private static final int QUARTER_MONEY = FULL_MONEY * FOUR;

	/**
	 * gambles.
	 * @param round the round number.
	 * @param sec how much time the player had left.
	 * @return the money they make!
	 */
	public static int gamble(Round round, int sec) {
		if(sec == 0) {
			return 0;
		}
		int moneyBonus, roundBonus, timeBonus = 0;
		roundBonus = round.getGambleBonus();

		if(sec >= threeQuarterTime && sec <= fullTime) {
			timeBonus = FULL_MONEY;
		} else if(sec >= halfTime && sec <= threeQuarterTime) {
			timeBonus = THREE_QUARTER_MONEY;
		} else if(sec >= quarterTime && sec <= halfTime) {
			timeBonus = HALF_MONEY;
		} else {
			timeBonus = QUARTER_MONEY;
		}

		moneyBonus = roundBonus + RAND_GEN.nextInt(timeBonus + 1);
		if(moneyBonus > MAX_MONEY) {
			moneyBonus = MAX_MONEY;
		}
		if(moneyBonus < 0) {
			moneyBonus = 0;
		}

		return moneyBonus;
	}
}
