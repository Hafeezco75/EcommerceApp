package com.jumia.web;

import com.jumia.dtos.requests.AddItemRequest;
import com.jumia.dtos.requests.RemoveItemRequest;
import com.jumia.dtos.responses.AddItemResponse;
import com.jumia.dtos.responses.ApiResponse;
import com.jumia.dtos.responses.RemoveItemResponse;
import com.jumia.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/type")
public class ItemController {
    @Autowired
    private ItemService itemService;


    @PostMapping("/addItem")
    public ResponseEntity<?> addItem(@RequestBody AddItemRequest addItemRequest) {
        try {
            AddItemResponse addItemResponse = itemService.addItem(addItemRequest);
            return new ResponseEntity<>(new ApiResponse(true, addItemResponse), HttpStatus.CREATED);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeItem")
    public ResponseEntity<?> removeItem(@RequestBody RemoveItemRequest removeItemRequest) {
        try {
            RemoveItemResponse removeItemResponse = itemService.deleteItem(removeItemRequest);
            return new ResponseEntity<>(new ApiResponse(true, removeItemResponse), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
