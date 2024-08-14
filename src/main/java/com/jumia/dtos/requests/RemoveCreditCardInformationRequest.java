package com.jumia.dtos.requests;

import com.jumia.data.models.CardType;
import lombok.*;

import java.time.LocalDate;
import java.time.Month;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RemoveCreditCardInformationRequest {
    private String cardCVV;
    private CardType cardType;
    private String cardHolderName;
    private Long creditCardNumber;
    private Month cardExpirationMonth;
    private LocalDate cardExpirationYear;
}

