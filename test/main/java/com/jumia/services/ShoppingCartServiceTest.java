package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import com.jumia.dtos.requests.AddItemToShoppingCartRequest;
import com.jumia.dtos.requests.RemoveItemFromShoppingCartRequest;
import com.jumia.dtos.responses.AddItemToShoppingCartResponse;
import com.jumia.dtos.responses.RemoveItemFromShoppingCartResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ShoppingCartServiceTest {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Test
    public void testThatItemsCanBeAddedToShoppingCart() {
        AddItemToShoppingCartRequest addItemToShoppingCartRequest = new AddItemToShoppingCartRequest();
        addItemToShoppingCartRequest.setItemId("124");
        addItemToShoppingCartRequest.setItems(List.of(new Items("540", List.of(new Product("13", "Banana","Good fruit for consumption", 540.50, ProductCategory.SUPERMARKET)), 30, ProductCategory.SUPERMARKET)));
        AddItemToShoppingCartResponse addItemToShoppingCartResponse = shoppingCartService.addItemToShoppingCart(addItemToShoppingCartRequest);
        assertThat(addItemToShoppingCartResponse).isNotNull();
        assertThat(addItemToShoppingCartResponse.getMessage()).isEqualTo("Successfully added item to Shopping cart");

    }

    @Test
    public void testThatItemsCanBeRemovedToShoppingCart() {
        RemoveItemFromShoppingCartRequest removeItemFromShoppingCartRequest = new RemoveItemFromShoppingCartRequest();
        removeItemFromShoppingCartRequest.setItemId("432");
        removeItemFromShoppingCartRequest.setItems(List.of(new Items("321", List.of(new Product("12", "FanMilk","General Foods for Everyone", 500.80, ProductCategory.SUPERMARKET)), 50, ProductCategory.SUPERMARKET)));
        RemoveItemFromShoppingCartResponse removeItemFromShoppingCartResponse = shoppingCartService.removeItemFromShoppingCart(removeItemFromShoppingCartRequest);
        assertThat(removeItemFromShoppingCartResponse).isNotNull();
        assertThat(removeItemFromShoppingCartResponse.getMessage()).isEqualTo("Successfully removed item from Shopping cart");
    }
}
