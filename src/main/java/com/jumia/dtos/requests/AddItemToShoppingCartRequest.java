package com.jumia.dtos.requests;

import com.jumia.data.models.Items;
import com.jumia.data.models.ProductCategory;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddItemToShoppingCartRequest {
    private String shoppingCartId;
    private List<Items> items = new ArrayList<>();
    private int quantityOfProductSelected;
}
