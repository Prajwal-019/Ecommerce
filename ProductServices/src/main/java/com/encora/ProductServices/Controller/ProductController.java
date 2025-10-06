package com.encora.ProductServices.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encora.ProductServices.Model.Product;
import com.encora.ProductServices.Service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
	
	
    // Get all products
	@GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
 
    // Get product by ID
    @GetMapping("/{prodId}")
    public Optional<Product> getProductById(@PathVariable("prodId") Long prodId) {
        return productService.getProductById(prodId);
    }
 
    // Add new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    
    
    
    //updating the product
    @PutMapping("/{id}/decrease")
    public ResponseEntity<?> decreaseQuantity(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
        try {
            Product product = productService.decreaseQuantity(id, quantity);
            return ResponseEntity.ok(product);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
 
    
    // Delete product by ID
    @DeleteMapping("/{prodId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("prodId") Long prodId) {
        productService.deleteProduct(prodId);
        return ResponseEntity.noContent().build();
    }
    
    
   
    


}
