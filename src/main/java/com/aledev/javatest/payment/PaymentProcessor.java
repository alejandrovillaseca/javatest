package com.aledev.javatest.payment;

/**
 * PaymentProcessor
 */
public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    
    public boolean makePayment(double amount){
        var resp = paymentGateway.paymentRequest(new PaymentRequest(amount));
        if(resp.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        }else{
            return false;
        }
    }

    
    
}