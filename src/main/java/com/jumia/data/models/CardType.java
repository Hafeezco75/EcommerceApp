package com.jumia.data.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.constant.ClassDesc;

import static com.jumia.data.models.ProductCategory.GAMING;

@Getter
public enum CardType {

    AMERICANEXPRESS,
    MASTERCARD,
    VISA,
    VERVE;


    final EnumDesc<CardType> card = getCard();

}
