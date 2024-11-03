package com.example.productcompositeservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.productcompositeservice.dto.CreateRecommendationRequest;
import com.example.productcompositeservice.models.Recommendation;


@FeignClient(name = "recommendation-service")
public interface RecommendationClient {

    // get recommendations by product id
    @GetMapping("/recommendations/products/{productId}")
    List<Recommendation> getRecommendationsByProductId(@PathVariable int productId);

}
