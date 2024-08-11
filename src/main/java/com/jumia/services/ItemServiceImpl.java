package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.data.models.ProductCategory;
import com.jumia.data.repositories.ItemsRepository;
import com.jumia.dtos.requests.AddItemRequest;
import com.jumia.dtos.requests.RemoveItemRequest;
import com.jumia.dtos.requests.UpdateItemRequest;
import com.jumia.dtos.responses.AddItemResponse;
import com.jumia.dtos.responses.RemoveItemResponse;
import com.jumia.dtos.responses.UpdateItemResponse;
import com.jumia.exceptions.NoSuchItemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsRepository itemsRepository;
    @Id
    private String itemId;


    @Override
    public AddItemResponse addItem(AddItemRequest addItemRequest) {
        Items items = new Items();
        items.setProducts(new ArrayList<>(20));
        items.setQuantityOfProductSelected(13);
        items.setCategory(ProductCategory.ELECTRONICS);
        itemsRepository.save(items);

        AddItemResponse addItemResponse = new AddItemResponse();
        addItemResponse.setMessage("Products added successfully to Items List");
        return addItemResponse;
    }

    @Override
    public RemoveItemResponse deleteItem(RemoveItemRequest removeItemRequest) {
        Items items = new Items();
        items.setItemId("23");
        items.setProducts(new ArrayList<>(10));
        items.setQuantityOfProductSelected(13);
        items.setCategory(ProductCategory.ELECTRONICS);
        itemsRepository.delete(items);

        RemoveItemResponse removeItemResponse = new RemoveItemResponse();
        removeItemResponse.setMessage("Items has been successfully removed");
        return removeItemResponse;
    }

    @Override
    public UpdateItemResponse updateItem(UpdateItemRequest updateItemRequest) {
        for (Items item : itemsRepository.findAll()) {
            if (item.getItemId().equals(updateItemRequest.getItemId())) {
                item.setProducts(item.getProducts());
                item.setQuantityOfProductSelected(item.getQuantityOfProductSelected());
                item.setCategory(item.getCategory());
                itemsRepository.save(item);
            }else
                { throw new NoSuchItemException("Item does not exist");
            }
        }

        UpdateItemResponse updateItemResponse = new UpdateItemResponse();
        updateItemResponse.setMessage("Item has been updated successfully");
        return updateItemResponse;
    }

    private void validateItem(String itemId) {
        for (Items item : itemsRepository.findAll()) {
            if (item.getItemId().equals(itemId)) {
                itemsRepository.delete(item);
            }else {
                throw new NoSuchItemException("Items does not exist");
            }
        }
    }



}
