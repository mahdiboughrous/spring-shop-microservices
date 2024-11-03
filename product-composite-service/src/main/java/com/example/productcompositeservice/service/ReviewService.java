package com.example.productcompositeservice.service;

import com.example.productcompositeservice.clients.ReviewClient;
import com.example.productcompositeservice.models.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewClient reviewClient;

    // get reviews by product id
    public List<Review> getReviewsByProductId(int productId) {
        return reviewClient.getReviewsByProductId(productId);
    }
}
