package com.jumia.services;

import com.jumia.data.models.ShoppingCart;
import com.jumia.dtos.requests.AddItemToShoppingCartRequest;
import com.jumia.dtos.requests.ModifyItemInShoppingCartRequest;
import com.jumia.dtos.requests.RemoveItemFromShoppingCartRequest;
import com.jumia.dtos.responses.AddItemToShoppingCartResponse;
import com.jumia.dtos.responses.ModifyItemInShoppingCartResponse;
import com.jumia.dtos.responses.RemoveItemFromShoppingCartResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingCartService {

    AddItemToShoppingCartResponse addItemToShoppingCart(AddItemToShoppingCartRequest request);

    RemoveItemFromShoppingCartResponse removeItemFromShoppingCart(RemoveItemFromShoppingCartRequest removeItemFromShoppingCartRequest);

    ModifyItemInShoppingCartResponse modifyItemInShoppingCart(ModifyItemInShoppingCartRequest modifyItemInShoppingCartRequest);

    List<ShoppingCart> getAllItemsInShoppingCart();
}
