package com.initialfirstpoject.paymentservicemay2024.Service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpayPaymentService")
public class RazorpayPaymentService implements Ipaymentservice{
    private RazorpayClient razorpayClient;
    public RazorpayPaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String dopayment(String email, Integer amount, String phoneNO, String orderId) throws RazorpayException {
        JSONObject requestBody =  getRequestBodyForRazorpay(amount, orderId);

        PaymentLink razorpaymentlink= razorpayClient.paymentLink.create(requestBody);
        return razorpaymentlink.toString();
    }

    private JSONObject getRequestBodyForRazorpay(Integer amount, String orderId) {
        JSONObject customerInfo = new JSONObject();
        customerInfo.put("phone", "9999999999");
        customerInfo.put("email", "sireesha14426@gamil.com");

        JSONObject notify = new JSONObject();
        notify.put("sms", "true");
        notify.put("email", "true");

        JSONObject orderrequest = new JSONObject();
        orderrequest.put("amount", amount);
        orderrequest.put("orderId", orderId);
        orderrequest.put("currency", "INR");
        orderrequest.put("customer", customerInfo);
        orderrequest.put("notify", notify);
        orderrequest.put("callback", "url");
        return orderrequest;

    }
}
