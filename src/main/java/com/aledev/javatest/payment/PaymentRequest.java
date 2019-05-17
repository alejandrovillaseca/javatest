package com.aledev.javatest.payment;

/**
 * PaymentRequest
 */
public class PaymentRequest {
    private double amount;
    
    public PaymentRequest(double amount){
        this.amount = amount;
    }
    
    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }
}