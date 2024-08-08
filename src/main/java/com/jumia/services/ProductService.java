package com.jumia.services;

import com.jumia.data.models.Product;
import com.jumia.dtos.requests.AddProductRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.responses.AddProductResponse;
import com.jumia.dtos.responses.RemoveProductResponse;

import java.util.List;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest addProductRequest);
    RemoveProductResponse removeProduct(RemoveProductRequest removeProductRequest);
    Product getProduct();
    List<Product> getProducts();
}
