package com.jumia.dtos.requests;

import com.jumia.data.models.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Month;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModifyCreditCardInformationRequest {
    private String cardCVV;
    private String cardHolderName;
    private Long creditCardNumber;
    private Month cardExpirationMonth;
    private LocalDate cardExpirationYear;
    private CardType cardType;
}
