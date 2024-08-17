package com.jumia.services;

import com.jumia.data.models.RoleType;
import com.jumia.data.models.Product;
import com.jumia.data.models.Users;
import com.jumia.data.repositories.ProductRepository;
import com.jumia.dtos.requests.AddProductRequest;
import com.jumia.dtos.requests.RemoveProductRequest;
import com.jumia.dtos.responses.AddProductResponse;
import com.jumia.dtos.responses.RemoveProductResponse;
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


    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Users users = new Users();
        validateUser(users.getId());
        Product product = new Product();
        product.setProductId(addProductRequest.getProductId());
        product.setProductName(addProductRequest.getProductName());
        product.setProductDescription(addProductRequest.getProductDescription());
        product.setPrice(addProductRequest.getProductPrice());
        product.setProductCategory(addProductRequest.getProductCategory());
        productRepository.save(product);

        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setMessage("Product has been added successfully");
        return addProductResponse;
    }

    @Override
    public RemoveProductResponse removeProduct(RemoveProductRequest removeProductRequest) {
        RemoveProductResponse removeProductResponse = new RemoveProductResponse();
        Users users = new Users();
        validateUser(users.getId());
        for (Product product : productRepository.findAll()) {
            if (product.getProductName().equals(removeProductRequest.getProductName())) {
                if (product.getProductDescription().equals(removeProductRequest.getProductDescription())) {
                    productRepository.delete(product);
                }
            }
        }
        removeProductResponse.setMessage("Product has been removed successfully");
        return removeProductResponse;
    }

    @Override
    public UpdateProductResponse updateProduct(AddProductRequest addProductRequest) {
        UpdateProductResponse updateProductResponse = new UpdateProductResponse();
        Users users = new Users();
        validateUser(users.getId());
        for (Product products : productRepository.findAll()) {
            if (products.getProductName().equals(addProductRequest.getProductName())) {
                if (products.getProductDescription().equals(addProductRequest.getProductDescription())) {
                    products.setProductId(addProductRequest.getProductId());
                    products.setProductName(addProductRequest.getProductName());
                    products.setProductDescription(addProductRequest.getProductDescription());
                    products.setPrice(addProductRequest.getProductPrice());
                    products.setProductCategory(addProductRequest.getProductCategory());
                    productRepository.save(products);
                }else{
                    throw new IllegalArgumentException("Product name does not match");
                }
            }
        }
        updateProductResponse.setMessage("Product has been updated successfully");
        return updateProductResponse;
    }


    @Override
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
