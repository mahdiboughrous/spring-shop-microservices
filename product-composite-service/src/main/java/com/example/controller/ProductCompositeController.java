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

}
