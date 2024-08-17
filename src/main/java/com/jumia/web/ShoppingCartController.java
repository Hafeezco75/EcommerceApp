package com.jumia.web;

import com.jumia.data.models.ShoppingCart;
import com.jumia.dtos.requests.AddItemToShoppingCartRequest;
import com.jumia.dtos.requests.RemoveItemFromShoppingCartRequest;
import com.jumia.dtos.responses.AddItemToShoppingCartResponse;
import com.jumia.dtos.responses.ApiResponse;
import com.jumia.dtos.responses.RemoveItemFromShoppingCartResponse;
import com.jumia.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;


    @PostMapping("/addup")
    public ResponseEntity<?> addItemToShoppingCart(@RequestBody AddItemToShoppingCartRequest addItemToShoppingCartRequest) {
        try {
            AddItemToShoppingCartResponse addItemToShoppingCartResponse = shoppingCartService.addItemToShoppingCart(addItemToShoppingCartRequest);
            return new ResponseEntity<>(new ApiResponse(true, addItemToShoppingCartResponse), HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(new ApiResponse(true, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/removeItemFromCart")
    public ResponseEntity<?> removeItemFromShoppingCart(@RequestBody RemoveItemFromShoppingCartRequest removeItemFromShoppingCartRequest) {
        try {
            RemoveItemFromShoppingCartResponse removeItemFromShoppingCartResponse = shoppingCartService.removeItemFromShoppingCart(removeItemFromShoppingCartRequest);
            return new ResponseEntity<>(new ApiResponse(true, removeItemFromShoppingCartResponse), HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(new ApiResponse(true, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/Get")
    public ResponseEntity<?> getShoppingCart() {
        try {
            List<ShoppingCart> cart = shoppingCartService.getAllItemsInShoppingCart();
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(new ApiResponse(true, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
