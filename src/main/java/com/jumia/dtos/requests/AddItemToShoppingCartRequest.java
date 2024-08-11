package com.jumia.dtos.requests;

import com.jumia.data.models.Items;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddItemToShoppingCartRequest {
    private String itemId;
    private List<Items> items = new ArrayList<>();
}
