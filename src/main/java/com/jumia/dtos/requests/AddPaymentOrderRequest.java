package com.jumia.dtos.requests;

import com.jumia.data.models.BillingInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddPaymentOrderRequest {
    private String orderId;
    private BillingInformation billingInformation;
}
