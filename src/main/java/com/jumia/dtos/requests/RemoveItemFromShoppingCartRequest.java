package com.jumia.dtos.requests;

import com.jumia.data.models.Items;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RemoveItemFromShoppingCartRequest {
    private String itemId;
    private List<Items> items;
}
