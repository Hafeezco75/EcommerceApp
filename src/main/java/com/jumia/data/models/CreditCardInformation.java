package com.jumia.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class CreditCardInformation extends BillingInformation {
    private String cardCVV;
    private String cardHolderName;
    private Long creditCardNumber;
    private LocalDate cardExpirationMonth;
    private LocalDate cardExpirationYear;
    private CardType cardType;
}
