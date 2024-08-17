package com.jumia.services;

import com.jumia.data.models.Items;
import com.jumia.dtos.requests.AddItemRequest;
import com.jumia.dtos.requests.RemoveItemRequest;
import com.jumia.dtos.requests.UpdateItemRequest;
import com.jumia.dtos.responses.AddItemResponse;
import com.jumia.dtos.responses.RemoveItemResponse;
import com.jumia.dtos.responses.UpdateItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    AddItemResponse addItem(AddItemRequest addItemRequest);

    RemoveItemResponse deleteItem(RemoveItemRequest removeItemRequest);

    UpdateItemResponse updateItem(UpdateItemRequest updateItemRequest);

    List<Items> getAllItems();
}
