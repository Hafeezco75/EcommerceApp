package com.jumia.data.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
public enum CardType {

    AMERICANEXPRESS,
    MASTERCARD,
    VISA,
    VERVE;


}
