package com.aledev.javatest.player;

/**
 * Player
 */
public class Player {

    private Dice dice;
    private int minNumberToWin;

    public Player(Dice dice, int minNumberToWin){
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    public boolean play(){
        var diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }

    
}