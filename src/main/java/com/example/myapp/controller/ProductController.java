package com.example.myapp.controller;

import com.example.myapp.model.Product;
import com.example.myapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
//@CrossOrigin(origins = "*") // React frontend
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get all
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get by ID
    @GetMapping("/{id}")
public Product getProductById(@PathVariable Long id) {
    return productService.getProductById(id)
            .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
}


    // Add
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
    return productService.updateProduct(id, updatedProduct);
}

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
}


    // Search
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }

    // Filter by category
    @GetMapping("/category/{category}")
    public List<Product> filterByCategory(@PathVariable String category) {
        return productService.filterByCategory(category);
    }
}
