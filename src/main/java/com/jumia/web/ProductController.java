package com.jumia.web;

import com.jumia.dtos.requests.AddProductRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.responses.AddProductResponse;
import com.jumia.dtos.responses.ApiResponse;
import com.jumia.dtos.responses.RemoveProductResponse;
import com.jumia.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest addProductRequest) {
        try {
            AddProductResponse addProductResponse = productService.addProduct(addProductRequest);
            return new ResponseEntity<>(new ApiResponse(true, addProductResponse), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeProduct")
    public ResponseEntity<?> removeProduct(@RequestBody RemoveProductRequest removeProductRequest) {
        try {
            RemoveProductResponse removeProductResponse = productService.removeProduct(removeProductRequest);
            return new ResponseEntity<>(new ApiResponse(true, removeProductResponse), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
