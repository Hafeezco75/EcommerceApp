package com.jumia.dtos.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RemoveCreditCardInformationRequest {
    private String cardNumber;
}
