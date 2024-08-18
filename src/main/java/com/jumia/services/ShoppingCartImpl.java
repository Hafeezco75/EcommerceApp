package com.jumia.services;

import com.jumia.data.models.ShoppingCart;
import com.jumia.data.repositories.ShoppingCartRepository;
import com.jumia.dtos.requests.AddItemToShoppingCartRequest;
import com.jumia.dtos.requests.ModifyItemInShoppingCartRequest;
import com.jumia.dtos.requests.RemoveItemFromShoppingCartRequest;
import com.jumia.dtos.responses.AddItemToShoppingCartResponse;
import com.jumia.dtos.responses.ModifyItemInShoppingCartResponse;
import com.jumia.dtos.responses.RemoveItemFromShoppingCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        RemoveItemFromShoppingCartResponse removeItemFromShoppingCartResponse = new RemoveItemFromShoppingCartResponse();
        List<ShoppingCart> shoppingCart = shoppingCartRepository.findAll();
        for (ShoppingCart cart : shoppingCart) {
            if (cart.getShoppingCartId().equals(removeItemFromShoppingCartRequest.getShoppingCartId())) {
                if (cart.getItems().equals(removeItemFromShoppingCartRequest.getItems())) {
                    shoppingCart.remove(cart);
                }else {
                    throw new IllegalArgumentException("Shopping cart does not match");
                }
            }
        }

        removeItemFromShoppingCartResponse.setMessage("Successfully removed item from Shopping cart");
        return removeItemFromShoppingCartResponse;
    }

    @Override
    public ModifyItemInShoppingCartResponse modifyItemInShoppingCart(ModifyItemInShoppingCartRequest modifyItemInShoppingCartRequest) {
        ModifyItemInShoppingCartResponse modifyItemInShoppingCartResponse = new ModifyItemInShoppingCartResponse();
        List<ShoppingCart> shoppingCart = shoppingCartRepository.findAll();
            for (ShoppingCart cart : shoppingCart) {
                if (cart.getShoppingCartId().equals(modifyItemInShoppingCartRequest.getShoppingCartId())) {
                    if (cart.getItems().equals(modifyItemInShoppingCartRequest.getItems())) {
                        cart.setItems(modifyItemInShoppingCartRequest.getItems());
                        shoppingCartRepository.save(cart);
                    }else{
                        throw new IllegalArgumentException("Shopping cart does not match,try again");
                    }
                }
            }
        modifyItemInShoppingCartResponse.setMessage("Successfully modified item in Shopping cart");
        return modifyItemInShoppingCartResponse;
    }

    @Override
    public List<ShoppingCart> getAllItemsInShoppingCart(){
        return shoppingCartRepository.findAll();
    }

}
