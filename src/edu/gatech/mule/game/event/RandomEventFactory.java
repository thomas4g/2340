package edu.gatech.mule.game.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEventFactory {
	
	private static List<RoundEvent> roundEvents;
	private static List<TurnEvent> turnEvents;
	
	static {
		roundEvents = new ArrayList<>();
		turnEvents = new ArrayList<>();
		turnEvents.add(new FindMineEvent());
		turnEvents.add(new SwordWomanEvent());
	}

	public static TurnEvent createTurnEvent() {
		return turnEvents.get(new Random().nextInt(turnEvents.size()));
	}
	
	public static RoundEvent createRoundEvent() {
		return roundEvents.get(new Random().nextInt(roundEvents.size()));
	}
}
