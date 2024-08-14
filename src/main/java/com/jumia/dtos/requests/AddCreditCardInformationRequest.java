package com.jumia.dtos.requests;

import com.jumia.data.models.CardType;
import com.jumia.data.models.RoleType;
import lombok.*;

import java.time.LocalDate;
import java.time.Month;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddCreditCardInformationRequest {
    private String cardCVV;
    private String cardHolderName;
    private Long creditCardNumber;
    private CardType cardType;
    private Month cardExpirationMonth;
    private LocalDate cardExpirationYear;
    private RoleType roleType;

}
