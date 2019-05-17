package com.aledev.javatest.discounts;

import java.util.ArrayList;
import java.util.List;

/**
 * PriceCalculator
 */
public class PriceCalculator {
    private List<Double> prices = new ArrayList<>();
    private Double discount;
    public double getTotal(){
        var total = prices.stream().mapToDouble(x -> x.doubleValue()).sum();
        if(discount != null)
            return total * ((100 - discount) / 100);
        else
            return total;
    }
    public void addPrice(double price){
        prices.add(price);
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }
} 