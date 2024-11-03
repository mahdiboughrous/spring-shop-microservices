package com.example.recommendationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recommendationservice.model.Recommendation;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation, Integer> {}