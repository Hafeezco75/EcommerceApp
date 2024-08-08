package com.jumia.data.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public enum CardType {

    AMERICANEXPRESS("Dollar Express","Naira Express"),
    MASTERCARD("Credit MasterCard", "Debit MasterCard"),
    VISA("Visa", "DebitVisa"),
    VERVE("Credit Verve", "Debit Verve"),;


    private CardType(String... cards){
        this.cardTypes = cards;
    }

    private final String[] cardTypes;

}
