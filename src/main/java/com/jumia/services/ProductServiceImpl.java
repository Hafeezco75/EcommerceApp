package com.jumia.services;

import com.jumia.data.models.RoleType;
import com.jumia.data.models.Product;
import com.jumia.data.models.ProductCategory;
import com.jumia.data.models.Users;
import com.jumia.data.repositories.ProductRepository;
import com.jumia.dtos.requests.AddProductRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.requests.RetrieveProductRequest;
import com.jumia.dtos.responses.AddProductResponse;
import com.jumia.dtos.responses.RemoveProductResponse;
import com.jumia.dtos.responses.RetrieveProductResponse;
import com.jumia.dtos.responses.UpdateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
    private String productId;


    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Users users = new Users();
        validateUser(users.getId());
        checkProductExist(productId);
        Product product = new Product();
        product.setProductId("25");
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
        Users users = new Users();
        validateUser(users.getId());
        Product product = new Product();
        product.setProductId("25");
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
    public UpdateProductResponse updateProduct(AddProductRequest addProductRequest) {
        Users users = new Users();
        validateUser(users.getId());
        checkUpProduct(productId);
        Product product = new Product();
        product.setProductName("Chocolate");
        product.setProductDescription("A widely consumed snacks for All");
        product.setPrice(8500.0);
        product.setProductCategory(ProductCategory.SUPERMARKET);
        productRepository.save(product);

        UpdateProductResponse updateProductResponse = new UpdateProductResponse();
        updateProductResponse.setMessage("Product has been updated successfully");
        return updateProductResponse;
    }

    @Override
    public RetrieveProductResponse retrieveProduct(RetrieveProductRequest retrieveProductRequest) {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getProductId().equals(retrieveProductRequest.getProductId())) {
                throw new IllegalArgumentException("No products found");
            } else {
                getAllProduct(product.getProductId());
            }
        }

        RetrieveProductResponse retrieveProductResponse = new RetrieveProductResponse();
        retrieveProductResponse.setMessage("Product has been retrieved successfully");
        return retrieveProductResponse;
    }


    public Product getProduct(String productId) {
        Product product = productRepository.findByProductId(productId);
        if (product.getProductId().equals(productId)) {
            return product;
        }
        else { throw new IllegalArgumentException("No products found");
        }
    }

    @Override
    public List<Product> getAllProduct(String productId) {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new IllegalArgumentException("No products found");
        }
        else { return products; }
    }

    private void checkProductExist(String productId) {
        for (Product product : productRepository.findAll()) {
            if (product.getProductId().equals(productId)) {
                throw new IllegalArgumentException("Product already exists");
            }else {
                productRepository.count();
            }
        }
    }

    private void checkUpProduct(String productId) {
        for (Product product : productRepository.findAll()) {
            if (product.getProductId().equals(productId)) {
                productRepository.save(product);
            } else {
                throw new RuntimeException("No products available");
            }
        }
        throw new IllegalArgumentException("No product found");
    }

    private void validateUser(String userId) {
        Optional<Users> user = userService.findUserById(userId);
        try {
            if (user.isPresent()) {
                if (user.get().getRole() == RoleType.SELLER) {
                    productRepository.save(new Product());
                }
            }
        }catch (Exception e){
            throw new RuntimeException("User does not exist");
        }
    }


}
