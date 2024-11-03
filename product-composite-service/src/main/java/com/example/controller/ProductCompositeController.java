package com.example.productcompositeservice.controller;

import java.util.Collections;
import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productcompositeservice.dto.CreateProductRequest;
import com.example.productcompositeservice.dto.CreateRecommendationRequest;
import com.example.productcompositeservice.dto.CreateReviewRequest;
import com.example.productcompositeservice.models.Product;
import com.example.productcompositeservice.models.ProductComposite;
import com.example.productcompositeservice.models.Recommendation;
import com.example.productcompositeservice.models.Review;
import com.example.productcompositeservice.service.ProductCompositeService;
import com.example.productcompositeservice.service.ProductService;
import com.example.productcompositeservice.service.RecommendationService;
import com.example.productcompositeservice.service.ReviewService;


@Controller
@RequestMapping("/product-composites")
public class ProductCompositeController {

    private final ProductCompositeService productCompositeService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final RecommendationService recommendationService;
    private final Logger logger = LoggerFactory.getLogger(ProductCompositeController.class); 

    public ProductCompositeController(ProductCompositeService productCompositeService,
                                      ProductService productService,
                                      ReviewService reviewService,
                                      RecommendationService recommendationService) {
        this.productCompositeService = productCompositeService;
        this.productService = productService;
        this.reviewService = reviewService;
        this.recommendationService = recommendationService;
    }

    // Get all product composites
    @GetMapping("/{productId}")
    public ResponseEntity<ProductComposite> getProductComposite(@PathVariable int productId) {
        logger.info("Getting all product composites");
        ProductComposite productComposite = productCompositeService.getProductComposite(productId);
        return ResponseEntity.ok().body(productComposite);
    }

    // Endpoint to retrieve all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("Getting all products");
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }



    // Endpoint to retrieve a product by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        logger.info("Getting product with ID: {}", id);
        Product product = productService.getProductById(id);
        return ResponseEntity.ok().body(product);
    }



    // Endpoint to create a product
    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductRequest product) {
        logger.info("Creating product");
        productService.createProduct(product);
        return ResponseEntity.ok().build();
    }



    // get all reviews
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok().body(reviews);
    }

    // get review by id
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@RequestParam int id) {
        Review review = reviewService.getReviewById(id);
        return ResponseEntity.ok().body(review);
    }

    // create review
    @PostMapping("/reviews")
    public ResponseEntity<Void> createReview(@RequestBody CreateReviewRequest review) {
        reviewService.createReview(review);
        return ResponseEntity.ok().build();
    }

    // get all recommendations
    @GetMapping("/recommendations")
    public ResponseEntity<List<Recommendation>> getAllRecommendations() {
        List<Recommendation> recommendations = recommendationService.getAllRecommendations();
        return ResponseEntity.ok().body(recommendations);
    }

    // get recommendation by id
    @GetMapping("/recommendations/{id}")
    public ResponseEntity<Recommendation> getRecommendationById(@RequestParam int id) {
        Recommendation recommendation = recommendationService.getRecommendationById(id);
        return ResponseEntity.ok().body(recommendation);
    }

    // create recommendation
    @PostMapping("/recommendations")
    public ResponseEntity<Void> createRecommendation(@RequestBody CreateRecommendationRequest recommendation) {
        recommendationService.createRecommendation(recommendation);
        return ResponseEntity.ok().build();
    }
}
