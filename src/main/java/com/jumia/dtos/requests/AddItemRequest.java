package com.jumia.dtos.requests;

import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddItemRequest {
    private String itemId;
    private List<Product> products = new ArrayList<>();
    private int quantityOfProductSelected;
    private ProductCategory productCategory;
}
