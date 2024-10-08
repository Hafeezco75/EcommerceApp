package com.jumia.dtos.requests;

import com.jumia.data.models.Items;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RemoveItemFromShoppingCartRequest {
    @Id
    private String shoppingCartId;
    private List<Items> items = new ArrayList<>();
}
