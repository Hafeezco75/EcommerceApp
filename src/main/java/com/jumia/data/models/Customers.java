package com.jumia.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Customers extends Users {
    private CreditCardInformation creditCardInformation;

}
