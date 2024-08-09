package com.jumia.services;

import com.jumia.data.models.Product;
import com.jumia.dtos.requests.AddProductRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.responses.AddProductResponse;
import com.jumia.dtos.responses.RemoveProductResponse;
import com.jumia.dtos.responses.UpdateProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    AddProductResponse addProduct(AddProductRequest addProductRequest);
    RemoveProductResponse removeProduct(RemoveProductRequest removeProductRequest);
    UpdateProductResponse updateProduct(AddProductRequest addProductRequest);

    Product getProduct(String productId);
    List<Product> getAllProduct(String productId);
}
