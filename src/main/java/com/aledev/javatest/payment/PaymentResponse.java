package com.aledev.javatest.payment;

/**
 * PaymentResponse
 */
public class PaymentResponse {

    public enum PaymentStatus{
        OK,
        ERROR
    }
    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status){
        this.status = status;
    }
    /**
     * @return the status
     */
    public PaymentStatus getStatus() {
        return status;
    }
}