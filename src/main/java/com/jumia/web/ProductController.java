package com.jumia.web;

import com.jumia.data.models.Product;
import com.jumia.dtos.requests.AddProductRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.responses.AddProductResponse;
import com.jumia.dtos.responses.ApiResponse;
import com.jumia.dtos.responses.RemoveProductResponse;
import com.jumia.dtos.responses.UpdateProductResponse;
import com.jumia.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/Edit")
    public ResponseEntity<?> updateProduct(@RequestBody AddProductRequest addProductRequest) {
        try {
            UpdateProductResponse updateProductResponse = productService.updateProduct(addProductRequest);
            return new ResponseEntity<>(new ApiResponse(true, updateProductResponse), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/GetProduct")
    public ResponseEntity<?> getAllProducts(String productId) {
        try {
            List<Product> products = productService.getAllProduct(productId);
            return new ResponseEntity<>(new ApiResponse(true, products), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
