package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import com.jumia.data.models.ShoppingCart;
import com.jumia.dtos.requests.AddItemToShoppingCartRequest;
import com.jumia.dtos.requests.ModifyItemInShoppingCartRequest;
import com.jumia.dtos.requests.RemoveItemFromShoppingCartRequest;
import com.jumia.dtos.responses.AddItemToShoppingCartResponse;
import com.jumia.dtos.responses.ModifyItemInShoppingCartResponse;
import com.jumia.dtos.responses.RemoveItemFromShoppingCartResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class ShoppingCartServiceTest {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Test
    public void testThatItemsCanBeAddedToShoppingCart() {
        AddItemToShoppingCartRequest addItemToShoppingCartRequest = new AddItemToShoppingCartRequest();
        addItemToShoppingCartRequest.setItems(List.of(new Items("540", List.of(new Product("13", "Banana","Good fruit for consumption", 540.50, ProductCategory.SUPERMARKET)), 30, ProductCategory.SUPERMARKET)));
        AddItemToShoppingCartResponse addItemToShoppingCartResponse = shoppingCartService.addItemToShoppingCart(addItemToShoppingCartRequest);
        assertThat(addItemToShoppingCartResponse).isNotNull();
        assertThat(addItemToShoppingCartResponse.getMessage()).isEqualTo("Successfully added item to Shopping cart");

    }

    @Test
    public void testThatItemsCanBeRemovedToShoppingCart() {
        RemoveItemFromShoppingCartRequest removeItemFromShoppingCartRequest = new RemoveItemFromShoppingCartRequest();
        removeItemFromShoppingCartRequest.setItems(List.of(new Items("321", List.of(new Product("12", "FanMilk","General Foods for Everyone", 500.80, ProductCategory.SUPERMARKET)), 50, ProductCategory.SUPERMARKET)));
        RemoveItemFromShoppingCartResponse removeItemFromShoppingCartResponse = shoppingCartService.removeItemFromShoppingCart(removeItemFromShoppingCartRequest);
        assertThat(removeItemFromShoppingCartResponse).isNotNull();
        assertThat(removeItemFromShoppingCartResponse.getMessage()).isEqualTo("Successfully removed item from Shopping cart");
    }

    @Test
    public void testThatItemsCanBeUpdatedInShoppingCart() {
        ModifyItemInShoppingCartRequest modifyItemInShoppingCartRequest = new ModifyItemInShoppingCartRequest();
        modifyItemInShoppingCartRequest.setItems(List.of(new Items("321",List.of(new Product("13","IceCream","Tasty, Freshly and Creamy",300.54,ProductCategory.SUPERMARKET)),30, ProductCategory.SUPERMARKET)));
        ModifyItemInShoppingCartResponse modifyItemInShoppingCartResponse = shoppingCartService.modifyItemInShoppingCart(modifyItemInShoppingCartRequest);
        assertThat(modifyItemInShoppingCartResponse).isNotNull();
        assertThat(modifyItemInShoppingCartResponse.getMessage()).isEqualTo("Successfully modified item in Shopping cart");
    }

    @Test
    public void testThatAllItemsCanBeRetrievedFromShoppingCart() {
        List<ShoppingCart> cart= shoppingCartService.getAllItemsInShoppingCart();
        assertThat(cart).isNotNull();
        assertThat(cart).toString().equals(shoppingCartService.getAllItemsInShoppingCart().toString());
    }


}
