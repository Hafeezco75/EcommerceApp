package com.jumia.dtos.requests;

import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RemoveItemRequest {
    @Id
    private String itemId;
    private List<Product> products;
    private int quantityOfProductSelected;
    private ProductCategory productCategory;
}
