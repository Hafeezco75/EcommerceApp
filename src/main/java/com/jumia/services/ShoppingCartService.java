package com.jumia.services;

import com.jumia.dtos.requests.AddItemToShoppingCartRequest;
import com.jumia.dtos.requests.RemoveItemFromShoppingCartRequest;
import com.jumia.dtos.responses.AddItemToShoppingCartResponse;
import com.jumia.dtos.responses.RemoveItemFromShoppingCartResponse;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {

    AddItemToShoppingCartResponse addItemToShoppingCart(AddItemToShoppingCartRequest request);

    RemoveItemFromShoppingCartResponse removeItemFromShoppingCart(RemoveItemFromShoppingCartRequest removeItemFromShoppingCartRequest);

}
