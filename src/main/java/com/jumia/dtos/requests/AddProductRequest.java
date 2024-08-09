package com.jumia.dtos.requests;

import com.jumia.data.models.ProductCategory;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddProductRequest {
    private String productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private ProductCategory productCategory;
}
