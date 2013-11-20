package edu.gatech.mule.game;

import java.util.Random;

/**
 * Formula for calculating pub gambling.
 * @version 1.0
 */
public final class GamblingFormula {

	private static final Random RAND_GEN = new Random();
	
	private GamblingFormula() { }

	/**
	 * gambles.
	 * @param round the round number.
	 * @param sec how much time the player had left.
	 * @return the money they make!
	 */
	public static int gamble(int round, int sec) {
		if(sec == 0) {
			return 0;
		}
		int moneyBonus, roundBonus, timeBonus = 0;

		if(round < 0 || round > 12) {
			throw new RuntimeException("Not a valid round!");
		}
		if(round < 4) {
			roundBonus = 50;
		} else if(round < 8) {
			roundBonus = 100;
		} else if(round < 12) {
			roundBonus = 150;
		} else {
			roundBonus = 200;
		}

		if(sec >= 37 && sec <= 50) {
			timeBonus = 200;
		} else if(sec >= 25 && sec <= 37) {
			timeBonus = 150;
		} else if(sec >= 12 && sec <= 25) {
			timeBonus = 100;
		} else {
			timeBonus = 50;
		}

		moneyBonus = roundBonus + RAND_GEN.nextInt(timeBonus + 1);
		if(moneyBonus > 250) {
			moneyBonus = 250;
		}
		if(moneyBonus < 0) {
			moneyBonus = 0;
		}

		return moneyBonus;
	}
}
