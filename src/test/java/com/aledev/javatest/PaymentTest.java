package com.aledev.javatest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.aledev.javatest.payment.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * PaymentTest
 */
public class PaymentTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup(){
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_ok(){
        Mockito.when(paymentGateway.paymentRequest(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
                
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_nok(){
        Mockito.when(paymentGateway.paymentRequest(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }
}