package com.example.recommendationservice.controller;

import com.example.recommendationservice.dto.CreateRecommendationRequest;
import com.example.recommendationservice.model.Recommendation;
import com.example.recommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }


    @GetMapping
    public ResponseEntity<List<Recommendation>> getAllRecommendations() {
        List<Recommendation> recommendations = recommendationService.getAllRecommendations();
        return ResponseEntity.ok().body(recommendations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommendation> getRecommendationById(@PathVariable int id) {

        Recommendation recommendation = recommendationService.getRecommendationById(id);

        return ResponseEntity.ok().body(recommendation);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createRecommendation(@RequestBody CreateRecommendationRequest newRecommendation) {

        Recommendation recommendation = new Recommendation(newRecommendation.getProductId(), newRecommendation.getAuthor(), newRecommendation.getRate(), newRecommendation.getContent());

        recommendationService.createRecommendation(recommendation);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Recommendation created successfully");
        return ResponseEntity.ok().body(response);
    }


    // get recommendations by product id
    @GetMapping("/products/{productId}")
    public ResponseEntity<List<Recommendation>> getRecommendationsByProductId(@PathVariable int productId) {
        List<Recommendation> recommendations = recommendationService.getRecommendationsByProductId(productId);
        return ResponseEntity.ok().body(recommendations);
    }
}