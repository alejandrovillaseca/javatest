package com.aledev.javatest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import com.aledev.javatest.discounts.PriceCalculator;

import org.junit.Test;

/**
 * PriceCalculatorTest
 */
public class PriceCalculatorTest {

    @Test
    public void total_zero_when_there_are_prices(){
        var priceCalc = new PriceCalculator();
        assertThat(priceCalc.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices(){
        var priceCalc = new PriceCalculator();
        priceCalc.addPrice(10.0);
        priceCalc.addPrice(15.2);
        assertThat(priceCalc.getTotal(), is(25.2));
    }

    @Test
    public void apply_discount_to_prices(){
        var priceCalc = new PriceCalculator();
        priceCalc.addPrice(20.0);
        priceCalc.addPrice(8.9);
        priceCalc.setDiscount(25);
        assertThat(priceCalc.getTotal(), is(21.674999999999997));
    }
}