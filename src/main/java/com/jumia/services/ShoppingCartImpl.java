package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import com.jumia.data.models.ShoppingCart;
import com.jumia.data.repositories.ShoppingCartRepository;
import com.jumia.dtos.requests.AddItemToShoppingCartRequest;
import com.jumia.dtos.requests.RemoveItemFromShoppingCartRequest;
import com.jumia.dtos.responses.AddItemToShoppingCartResponse;
import com.jumia.dtos.responses.RemoveItemFromShoppingCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public AddItemToShoppingCartResponse addItemToShoppingCart(AddItemToShoppingCartRequest addItemToShoppingCartRequest) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItems(addItemToShoppingCartRequest.getItems());
        shoppingCart.setShoppingCartId(addItemToShoppingCartRequest.getShoppingCartId());
        shoppingCartRepository.save(shoppingCart);

        AddItemToShoppingCartResponse addItemToShoppingCartResponse = new AddItemToShoppingCartResponse();
        addItemToShoppingCartResponse.setMessage("Successfully added item to Shopping cart");
        return addItemToShoppingCartResponse;

    }

    @Override
    public RemoveItemFromShoppingCartResponse removeItemFromShoppingCart(RemoveItemFromShoppingCartRequest removeItemFromShoppingCartRequest){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingCartId(removeItemFromShoppingCartRequest.getShoppingCartId());
        shoppingCart.setItems(removeItemFromShoppingCartRequest.getItems());
        shoppingCartRepository.delete(shoppingCart);

        RemoveItemFromShoppingCartResponse removeItemFromShoppingCartResponse = new RemoveItemFromShoppingCartResponse();
        removeItemFromShoppingCartResponse.setMessage("Successfully removed item from Shopping cart");
        return removeItemFromShoppingCartResponse;
    }
}
