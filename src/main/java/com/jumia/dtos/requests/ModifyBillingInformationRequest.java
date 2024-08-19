package com.jumia.dtos.requests;

import com.jumia.data.models.Addresses;
import com.jumia.data.models.CreditCardInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModifyBillingInformationRequest {
    private CreditCardInformation creditCardInformation;
    private Addresses addresses;
}
