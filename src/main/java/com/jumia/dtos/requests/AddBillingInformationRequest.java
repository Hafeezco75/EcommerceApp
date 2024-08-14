package com.jumia.dtos.requests;

import com.jumia.data.models.Addresses;
import com.jumia.data.models.CreditCardInformation;
import com.jumia.data.models.Customers;
import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddBillingInformationRequest {
    private CreditCardInformation creditCardInformation;
    private Addresses addresses;
}
