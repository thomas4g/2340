package edu.gatech.mule.game.store;

import java.util.Random;

import edu.gatech.mule.game.Player;

/**
 * Representation of the pub
 * The pub ends a player's turn and gives then a random amount of money
 * @version 0.1
 */
public class Pub extends Store {
    
    private final static Random randy = new Random();
    
    public void exchange(Player player) {
        /*
         * process the gambling formula
         * give the player the money the gambling formula processed
         * end the player's turn
         */
    }
    
    private static int gamble(int round, int sec) {
        int moneyBonus, roundBonus, timeBonus = 0;
        
        if(round<0 || round>12) {
            throw new RuntimeException("Not a valid round!");
        }
        if(round<4) {
            roundBonus = 50;
        } else if(round<8) {
            roundBonus = 100;
        } else if(round<12) {
            roundBonus = 150;
        } else {
            roundBonus = 200;
        }
        
        if(sec>=37 && sec<=50) {
            timeBonus = 200;
        } else if(sec>=25 && sec<=37) {
            timeBonus = 150;
        } else if(sec>=12 && sec<=25) {
            timeBonus = 100;
        } else {
            timeBonus = 50;
        }
        
        moneyBonus = roundBonus + randy.nextInt(timeBonus+1);
        if(moneyBonus > 250) {
            moneyBonus = 250;
        }
        if(moneyBonus < 0) {
            moneyBonus = 0;
        }
        
        return moneyBonus;
    }

}
