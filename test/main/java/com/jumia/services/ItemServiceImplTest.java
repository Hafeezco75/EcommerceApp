package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import com.jumia.data.repositories.ItemsRepository;
import com.jumia.dtos.requests.AddItemRequest;
import com.jumia.dtos.requests.RemoveItemRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.requests.UpdateItemRequest;
import com.jumia.dtos.responses.AddItemResponse;
import com.jumia.dtos.responses.RemoveItemResponse;
import com.jumia.dtos.responses.UpdateItemResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ItemServiceImplTest {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemsRepository itemsRepository;

    @Test
    public void testThatItemsCanBeAddedByTheSeller() {
        AddItemRequest addItemRequest = new AddItemRequest();
        addItemRequest.setItemId("43");
        addItemRequest.setProducts(List.of(new Product("341","Hollandia","Refreshing and Filling",250.00, ProductCategory.SUPERMARKET)));
        addItemRequest.setQuantityOfProductSelected(13);
        addItemRequest.setProductCategory(ProductCategory.GAMING);
        AddItemResponse addItemResponse = itemService.addItem(addItemRequest);
        assertThat(addItemResponse.getMessage()).isEqualTo("Products added successfully to Items List");
    }

    @Test
    public void testThatCustomerCanRemoveItems() {
        RemoveItemRequest removeItemRequest = new RemoveItemRequest();
        removeItemRequest.setItemId("321");
        removeItemRequest.setProducts(List.of(new Product("341","Hollandia","Refreshing and Filling",250.00, ProductCategory.SUPERMARKET)));
        removeItemRequest.setQuantityOfProductSelected(18);
        removeItemRequest.setProductCategory(ProductCategory.GAMING);
        RemoveItemResponse removeItemResponse = itemService.deleteItem(removeItemRequest);
        assertThat(removeItemResponse.getMessage()).isEqualTo("Items has been successfully removed");
    }

    @Test
    public void testThatItemsCanBeUpdated() {
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setItemId("41");
        updateItemRequest.setProducts(List.of(new Product("123","NutriC","Refreshing and Filling",250.00, ProductCategory.SUPERMARKET)));
        updateItemRequest.setQuantityOfProductSelected(13);
        updateItemRequest.setProductCategory(ProductCategory.GAMING);
        UpdateItemResponse updateItemResponse = itemService.updateItem(updateItemRequest);
        assertThat(updateItemResponse.getMessage()).isEqualTo("Item has been updated successfully");
    }

    @Test
    public void testThatItemsCanBeRetrieved() {
        List<Items> items = itemsRepository.findAll();
        items.forEach(System.out::println);
        assertThat(items.size()).isEqualTo(1);
    }
}
