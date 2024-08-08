package com.jumia.services;

import com.jumia.data.models.Product;
import com.jumia.data.repositories.ProductRepository;
import com.jumia.dtos.requests.LoginUserRequest;
import com.jumia.dtos.responses.RemoveProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Product product = new Product();
        product.setId("25");
        product.setProductName("Celerac");
        product.setProductDescription("A widely consumed food for Babies");
        product.setPrice(8500.0);
        product.setProductCategory(ProductCategory.SUPERMARKET);
        productRepository.save(product);

        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setMessage("Product has been added successfully");
        return addProductResponse;
    }

    @Override
    public RemoveProductResponse removeProduct(RemoveProductRequest removeProductRequest) {
        Product product = new Product();
        product.setId("25");
        product.setProductName("Celerac");
        product.setProductDescription("A widely consumed food for Babies");
        product.setPrice(8500.0);
        product.setProductCategory(ProductCategory.SUPERMARKET);
        productRepository.delete(product);

        RemoveProductResponse removeProductResponse = new RemoveProductResponse();
        removeProductResponse.setMessage("Product has been removed successfully");
        return removeProductResponse;
    }

    @Override
    public Product getProduct() {
        for (Product product : productRepository.findAll()) {
            if (product.getId().equals("25")) {
                if (product.getProductCategory() == ProductCategory.SUPERMARKET) {
                    return product;
                }
            }else { throw new IllegalArgumentException("No products found");
            }
        }
        throw new IllegalArgumentException("Product does not exist");
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }


    private void verifyUserIsLoggedIn(LoginUserRequest loginUserRequest) {
        if (setLoggedIn) {
            throw new IllegalArgumentException("User already logged in");
        }
    }


}
