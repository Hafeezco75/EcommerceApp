package com.jumia.dtos.requests;

import com.jumia.data.models.Items;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModifyItemInShoppingCartRequest {
    private String shoppingCartId;
    private List<Items> items = new ArrayList<>();

}
