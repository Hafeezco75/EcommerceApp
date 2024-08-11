package com.jumia.dtos.requests;

import com.jumia.data.models.Product;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RetrieveProductRequest {
    Product product;
    private String productId;
    private List<Product> products;
}
