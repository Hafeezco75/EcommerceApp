package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.data.repositories.ItemsRepository;
import com.jumia.dtos.requests.AddItemRequest;
import com.jumia.dtos.requests.RemoveItemRequest;
import com.jumia.dtos.requests.UpdateItemRequest;
import com.jumia.dtos.responses.AddItemResponse;
import com.jumia.dtos.responses.RemoveItemResponse;
import com.jumia.dtos.responses.UpdateItemResponse;
import com.jumia.exceptions.NoSuchItemException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemsRepository itemsRepository;


    @Override
    public AddItemResponse addItem(AddItemRequest addItemRequest) {
        Items items = new Items();
        items.setProducts(addItemRequest.getProducts());
        items.setQuantityOfProductSelected(addItemRequest.getQuantityOfProductSelected());
        items.setCategory(addItemRequest.getProductCategory());
        itemsRepository.save(items);

        AddItemResponse addItemResponse = new AddItemResponse();
        addItemResponse.setMessage("Products added successfully to Items List");
        return addItemResponse;
    }

    @Override
    public RemoveItemResponse deleteItem(RemoveItemRequest removeItemRequest) {
        RemoveItemResponse removeItemResponse = new RemoveItemResponse();
        for (Items item : itemsRepository.findAll()) {
            if (item.getProducts().equals(removeItemRequest.getProducts())) {
                if (item.getQuantityOfProductSelected() == removeItemRequest.getQuantityOfProductSelected()) {
                    itemsRepository.delete(item);
                }else {
                    throw new IllegalArgumentException("The product selected does not match the selected product");
                }
            }
        }

        removeItemResponse.setMessage("Items has been successfully removed");
        return removeItemResponse;
    }

    @Override
    public UpdateItemResponse updateItem(UpdateItemRequest updateItemRequest) {
        UpdateItemResponse updateItemResponse = new UpdateItemResponse();
        List<Items> items = itemsRepository.findAll();
        for (Items item : items) {
            if (item != null) {
                item.setProducts(item.getProducts());
                item.setQuantityOfProductSelected(item.getQuantityOfProductSelected());
                item.setCategory(item.getCategory());
                itemsRepository.save(item);
                }else {
                    throw new NoSuchItemException("Item does not exist");
                }
        }
        updateItemResponse.setMessage("Item has been updated successfully");
        return updateItemResponse;
    }

    @Override
    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }


}
