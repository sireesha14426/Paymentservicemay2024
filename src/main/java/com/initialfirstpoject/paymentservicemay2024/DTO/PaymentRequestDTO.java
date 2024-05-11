package com.initialfirstpoject.paymentservicemay2024.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequestDTO {
    private String email;
    private Integer amount;
    private String phoneNo;
    private String orderId;
}
