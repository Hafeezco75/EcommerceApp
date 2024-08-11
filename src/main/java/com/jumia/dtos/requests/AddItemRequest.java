package com.jumia.dtos.requests;

import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddItemRequest {
    @Id
    private String itemId;
    private List<Product> products;
    private long quantityOfProductSelected;
    private ProductCategory productCategory;
}
