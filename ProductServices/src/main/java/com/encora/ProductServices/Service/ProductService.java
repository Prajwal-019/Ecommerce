package com.encora.ProductServices.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.ProductServices.GlobalException.InsufficientQuantityException;
import com.encora.ProductServices.GlobalException.ProductNotFoundException;
import com.encora.ProductServices.Model.Product;
import com.encora.ProductServices.Repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product prod) {
        return productRepository.save(prod);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        productRepository.deleteById(id);
    }

    public Product decreaseQuantity(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));

        if (product.getQuantity() < quantity) {
            throw new InsufficientQuantityException("Insufficient quantity for product ID: " + productId);
        }

        product.setQuantity(product.getQuantity() - quantity);
        return productRepository.save(product);
    }
}
