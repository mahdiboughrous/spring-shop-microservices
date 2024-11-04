package com.example.recommendationservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recommendationservice.dto.CreateRecommendationRequest;
import com.example.recommendationservice.model.Recommendation;
import com.example.recommendationservice.service.RecommendationService;



@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

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