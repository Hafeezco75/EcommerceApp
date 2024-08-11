package com.jumia.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Items extends ShoppingCart {
    @Id
    private String itemId;
    private List<Product> products = new ArrayList<>();
    private int quantityOfProductSelected;
    private ProductCategory category;
}