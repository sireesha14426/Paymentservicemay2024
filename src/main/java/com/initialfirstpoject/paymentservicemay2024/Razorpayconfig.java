package com.initialfirstpoject.paymentservicemay2024;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Webhook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Razorpayconfig {
    @Value("${razorpay.key.id}")
    String razorpayId;
    @Value("${razorpay.key.secret}")
    String razorpaySecret;


@Bean
public RazorpayClient createrazorpayclient() throws RazorpayException {
    return new RazorpayClient(razorpayId,razorpaySecret);
}
}
