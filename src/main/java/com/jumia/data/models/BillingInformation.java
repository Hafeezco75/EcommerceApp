package com.jumia.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingInformation {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private CreditCardInformation creditCardInformation;
}
