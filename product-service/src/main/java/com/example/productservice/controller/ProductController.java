package com.example.productservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dto.CreateProductRequest;
import com.example.productservice.dto.UpdateProductRequest;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            logger.info(products.get(0).toString());
        }

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product = productService.getProductById(id);

        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createProduct(@RequestBody CreateProductRequest newProduct) {

        Product product = new Product(newProduct.getName(), newProduct.getWeight());

        productService.createProduct(product);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Product created successfully");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody UpdateProductRequest productDetails) {
        Optional<Product> productOptional = Optional.ofNullable(productService.getProductById(id));

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product updatedProduct = productOptional.get();
        if (productDetails.getName() != null) {
            updatedProduct.setName(productDetails.getName());
        }

        if (productDetails.getWeight() != null) {
            updatedProduct.setWeight(productDetails.getWeight());
        }

        return ResponseEntity.ok().body(productService.updateProduct(id, updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {

        if (productService.deleteProduct(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}