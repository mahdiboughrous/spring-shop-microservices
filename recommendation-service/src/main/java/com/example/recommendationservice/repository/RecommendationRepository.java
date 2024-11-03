package com.example.recommendationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.recommendationservice.model.Recommendation;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {

    // Get all recommendations by product ID
    @Query("SELECT r FROM Recommendation r WHERE r.productId = :productId")
    List<Recommendation> findByProductId(int productId);
}