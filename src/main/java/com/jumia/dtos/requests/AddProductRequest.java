package com.jumia.dtos.requests;

import com.jumia.data.models.ProductCategory;
import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AddProductRequest {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private ProductCategory productCategory;
}
