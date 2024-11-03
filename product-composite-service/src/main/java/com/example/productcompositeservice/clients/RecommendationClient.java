package com.example.productcompositeservice.clients;

import com.example.productcompositeservice.models.Recommendation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "recommendation-service")
public interface RecommendationClient {

    // get recommendations by product id
    @GetMapping("/recommendations/products/{productId}")
    List<Recommendation> getRecommendationsByProductId(@PathVariable int productId);

}
