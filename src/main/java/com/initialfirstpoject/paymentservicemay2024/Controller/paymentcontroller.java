package com.initialfirstpoject.paymentservicemay2024.Controller;

import com.initialfirstpoject.paymentservicemay2024.DTO.PaymentRequestDTO;
import com.initialfirstpoject.paymentservicemay2024.Service.Ipaymentservice;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentcontroller {
    private Ipaymentservice razorPayService;
    private Ipaymentservice stripePayService;

    public paymentcontroller(@Qualifier("razorpayPaymentService") Ipaymentservice razorPayService,
                             @Qualifier("stripePaymentService") Ipaymentservice stripePayService){
        this.razorPayService = razorPayService;
        this.stripePayService = stripePayService;
    }

    @PostMapping("/payment")
    public String initialpayment(@RequestBody PaymentRequestDTO dto) throws RazorpayException {
        String response;
        int gatewayType= getPaymentGatewayType();
        switch (gatewayType) {
            case 1:
                response= razorPayService.dopayment(dto.getEmail(), dto.getAmount(), dto.getPhoneNo(), dto.getOrderId());
            case 2:
                response= stripePayService.dopayment(dto.getEmail(), dto.getAmount(), dto.getPhoneNo(), dto.getOrderId());
        }
        return null;
    }

    private int getPaymentGatewayType() {

        return 1;
    }
}
