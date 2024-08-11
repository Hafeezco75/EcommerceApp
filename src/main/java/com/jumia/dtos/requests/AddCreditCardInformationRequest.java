package com.jumia.dtos.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddCreditCardInformationRequest {
    private String cardNumber;
}
