package com.example.productcompositeservice.clients;

import com.example.productcompositeservice.models.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review-service")
public interface ReviewClient {

    // get reviews by product id
    @GetMapping("/reviews/products/{productId}")
    List<Review> getReviewsByProductId(@PathVariable int productId);

}
