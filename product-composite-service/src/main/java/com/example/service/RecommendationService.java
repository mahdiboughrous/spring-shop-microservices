package com.example.productcompositeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.productcompositeservice.clients.RecommendationClient;
import com.example.productcompositeservice.dto.CreateRecommendationRequest;
import com.example.productcompositeservice.models.Recommendation;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecommendationService {

    private final RecommendationClient recommendationClient;


    // get all recommendaitnos
    public List<Recommendation> getAllRecommendations() {
        return recommendationClient.getAllRecommendations();
    }

    // get recommendation by id
    public Recommendation getRecommendationById(int id) {
        return recommendationClient.getRecommendationById(id);
    }

    // create recommendation
    public void createRecommendation(CreateRecommendationRequest recommendation) {
        recommendationClient.createRecommendation(recommendation);
    }

    // get recommendations by product id
    public List<Recommendation> getRecommendationsByProductId(int productId) {
        return recommendationClient.getRecommendationsByProductId(productId);
    }
}