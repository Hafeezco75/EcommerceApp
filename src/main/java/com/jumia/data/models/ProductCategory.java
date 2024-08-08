package com.jumia.data.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public enum ProductCategory {

    ELECTRONICS("Televisions","Home Audio","Cameras","Sound Bars"),
    FASHION("Watches","Men's Fashion","Women's Fashion"),
    GAMING("Playstation","Nintendo","PC Gaming"),
    SUPERMARKET("Beverages","Drinks","Dishwashing","Laundry","Cleaning Tools"),
    COMPUTING("Computers","Software","Computer Accessories"),;

    ProductCategory(String... produce){
        this.produces = produce;
    }

    private final String[] produces;
}
