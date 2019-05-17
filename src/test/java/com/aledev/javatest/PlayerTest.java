package com.aledev.javatest;

import static org.junit.Assert.assertEquals;

import com.aledev.javatest.player.Dice;
import com.aledev.javatest.player.Player;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * PlayerTest
 */
public class PlayerTest {

    @Test
    public void looses_when_dice_number_is_too_low(){
        //var dice = new Dice(6);
        var dice = Mockito.mock(Dice.class);
        
        Mockito.when(dice.roll()).thenReturn(2);
        var player = new Player(dice, 3);
        assertEquals(false, player.play());
    }

    @Test
    public void win_when_dice_number_is_too_large(){
        //var dice = new Dice(6);
        var dice = Mockito.mock(Dice.class);
        
        Mockito.when(dice.roll()).thenReturn(5);
        var player = new Player(dice, 3);
        assertEquals(true, player.play());
    }
}