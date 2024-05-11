package com.initialfirstpoject.paymentservicemay2024.Service;

import org.springframework.stereotype.Service;

@Service("stripePaymentService")
public class StripePaymentService implements Ipaymentservice {
    @Override
    public String dopayment(String email, Integer amount, String phoneNO, String orderId) {
        return null;
    }
}
