package com.jumia.services;

import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import com.jumia.data.repositories.ProductRepository;
import com.jumia.dtos.requests.AddProductRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.responses.AddProductResponse;
import com.jumia.dtos.responses.RemoveProductResponse;
import com.jumia.dtos.responses.UpdateProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;


    @Test
    public void TestThatProductCanBeAddedBySeller() {
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("test");
        addProductRequest.setProductDescription("description");
        addProductRequest.setProductPrice(2042.00);
        addProductRequest.setProductCategory(ProductCategory.SUPERMARKET);
        AddProductResponse addProductResponse = productService.addProduct(addProductRequest);
        assertThat(addProductResponse.getMessage()).isEqualTo("Product has been added successfully");
    }

    @Test
    public void TestThatProductCanBeDeleted() {
        RemoveProductRequest removeProductRequest = new RemoveProductRequest();
        removeProductRequest.setProductName("test");
        removeProductRequest.setProductDescription("description");
        removeProductRequest.setProductPrice(2042.00);
        removeProductRequest.setProductCategory(ProductCategory.SUPERMARKET);
        RemoveProductResponse removeProductResponse = productService.removeProduct(removeProductRequest);
        assertThat(removeProductResponse.getMessage()).isEqualTo("Product has been removed successfully");
    }

    @Test
    public void TestThatProductCanBeUpdatedBySeller() {
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductId("342");
        addProductRequest.setProductName("biscuit");
        addProductRequest.setProductDescription("A snacks and more");
        addProductRequest.setProductPrice(202.00);
        addProductRequest.setProductCategory(ProductCategory.SUPERMARKET);
        UpdateProductResponse updateProductResponse = productService.updateProduct(addProductRequest);
        assertThat(updateProductResponse.getMessage()).isEqualTo("Product has been updated successfully");
    }

    @Test
    public void TestThatProductCanBeRetrievedBySeller() {
        List<Product> products = productRepository.findAll();
        products.set(1, products.get(1));
        assertThat(products.size()).isEqualTo(6);
    }
}
