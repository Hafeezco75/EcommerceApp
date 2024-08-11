package com.jumia.dtos.requests;

import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateItemRequest {
    private String itemId;
    private List<Product> products;
    private long quantityOfProductSelected;
    private ProductCategory productCategory;
}
