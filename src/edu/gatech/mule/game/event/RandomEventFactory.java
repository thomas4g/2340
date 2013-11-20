package edu.gatech.mule.game.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.gatech.mule.game.event.roundevents.DroughtEvent;
import edu.gatech.mule.game.event.roundevents.RoundEvent;
import edu.gatech.mule.game.event.turnevents.AnnaEvent;
import edu.gatech.mule.game.event.turnevents.FindMineEvent;
import edu.gatech.mule.game.event.turnevents.MinstrelEvent;
import edu.gatech.mule.game.event.turnevents.MissionaryEvent;
import edu.gatech.mule.game.event.turnevents.StubToeEvent;
import edu.gatech.mule.game.event.turnevents.SwordWomanEvent;
import edu.gatech.mule.game.event.turnevents.ThomasBearEvent;
import edu.gatech.mule.game.event.turnevents.TurnEvent;

/**
 * Factory of random events.
 * @version 1.0
 */
public final class RandomEventFactory {

	private static List<RoundEvent> roundEvents;
	private static List<TurnEvent> turnEvents;

	private RandomEventFactory() {

	}
	static {
		roundEvents = new ArrayList<>();
		turnEvents = new ArrayList<>();

		turnEvents.add(new AnnaEvent());
		turnEvents.add(new FindMineEvent());
		turnEvents.add(new MinstrelEvent());
		turnEvents.add(new MissionaryEvent());
		turnEvents.add(new StubToeEvent());
		turnEvents.add(new SwordWomanEvent());
		turnEvents.add(new ThomasBearEvent());

		roundEvents.add(new DroughtEvent());
	}

	/**
	 * Creates a turn event.
	 * @return a turn event
	 */
	public static TurnEvent createTurnEvent() {
		return turnEvents.get(new Random().nextInt(turnEvents.size()));
	}

	/**
	 * Creates a round event.
	 * @return a round event
	 */
	public static RoundEvent createRoundEvent() {
		int index = new Random().nextInt(roundEvents.size());
		return roundEvents.get(index);
	}
}
