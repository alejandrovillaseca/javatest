package com.aledev.javatest.payment;
/**
 * InnerPaymentGateway
 */
public interface PaymentGateway {

    PaymentResponse paymentRequest(PaymentRequest request);
}