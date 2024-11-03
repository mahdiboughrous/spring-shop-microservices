package com.example.reviewservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reviewservice.model.Review;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {}