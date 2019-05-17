package com.aledev.javatest.player;

import java.util.Random;

/**
 * Dice
 */
public class Dice {

    private int sides;

    public Dice(int sides){
        this.sides = sides;
    }

    public int roll(){
        return new Random().nextInt(sides) + 1;
    }
}