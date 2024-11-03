package com.example.productcompositeservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.productcompositeservice.dto.CreateReviewRequest;
import com.example.productcompositeservice.models.Review;

@FeignClient(name = "review-service")
public interface  ReviewClient {

    // get reviews by product id
    @GetMapping("/reviews/products/{productId}")
    List<Review> getReviewsByProductId(@PathVariable int productId);

}
