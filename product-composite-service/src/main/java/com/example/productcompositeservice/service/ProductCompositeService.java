package com.boughrous.productcompositeservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.boughrous.productcompositeservice.models.Product;
import com.boughrous.productcompositeservice.models.ProductComposite;
import com.boughrous.productcompositeservice.models.Recommendation;
import com.boughrous.productcompositeservice.models.Review;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCompositeService {

    private final ProductService productService;
    private final ReviewService reviewService;
    private final RecommendationService recommendationService;

    // aggregate data from different services
    public ProductComposite getProductComposite(int productId) {
        Product product = productService.getProductById(productId);
        // get all product reviews
        List<Review> productReviews = reviewService.getReviewsByProductId(productId);

        // get all product recommendations
        List<Recommendation> productRecommendations = recommendationService.getRecommendationsByProductId(productId);

        return new ProductComposite(product, productReviews, productRecommendations);
    }
}
