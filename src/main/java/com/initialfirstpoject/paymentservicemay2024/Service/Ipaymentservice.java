package com.initialfirstpoject.paymentservicemay2024.Service;

import com.razorpay.RazorpayException;

public interface Ipaymentservice {
    String dopayment(String email, Integer amount, String phoneNO, String orderId) throws RazorpayException;
}
