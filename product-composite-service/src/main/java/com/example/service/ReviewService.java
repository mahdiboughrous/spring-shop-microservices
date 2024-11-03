package com.example.productcompositeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.productcompositeservice.clients.ReviewClient;
import com.example.productcompositeservice.dto.CreateReviewRequest;
import com.example.productcompositeservice.models.Review;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewClient reviewClient;

    // get reviews by product id
    public List<Review> getReviewsByProductId(int productId) {
        return reviewClient.getReviewsByProductId(productId);
    }
}
