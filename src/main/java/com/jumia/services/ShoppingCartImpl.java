package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
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
        Items items = new Items();
        items.setItemId("432");
        items.setQuantityOfProductSelected(15);
        items.setProducts(List.of(new Product("321","DanoMilk","A diary and supplementary foods for all",3400.00, ProductCategory.SUPERMARKET)));
        items.setCategory(ProductCategory.SUPERMARKET);
        shoppingCartRepository.save(items);

        AddItemToShoppingCartResponse addItemToShoppingCartResponse = new AddItemToShoppingCartResponse();
        addItemToShoppingCartResponse.setMessage("Successfully added item to Shopping cart");
        return addItemToShoppingCartResponse;

    }

    @Override
    public RemoveItemFromShoppingCartResponse removeItemFromShoppingCart(RemoveItemFromShoppingCartRequest removeItemFromShoppingCartRequest){
        Items items = new Items();
        items.setItemId("124");
        items.setQuantityOfProductSelected(15);
        items.setProducts(List.of(new Product("213","Semolina","Great Edibles which is sucullent",3500.00, ProductCategory.SUPERMARKET)));
        items.setCategory(ProductCategory.SUPERMARKET);
        shoppingCartRepository.delete(items);

        RemoveItemFromShoppingCartResponse removeItemFromShoppingCartResponse = new RemoveItemFromShoppingCartResponse();
        removeItemFromShoppingCartResponse.setMessage("Successfully removed item from Shopping cart");
        return removeItemFromShoppingCartResponse;
    }
}
