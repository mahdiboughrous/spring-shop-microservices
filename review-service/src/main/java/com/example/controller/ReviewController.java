package com.example.reviewservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reviewservice.dto.CreateReviewRequest;
import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;


@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        if(!reviews.isEmpty()) {
            System.out.println(reviews.get(0).toString());
        }
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        Review review = reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createReview(@RequestBody CreateReviewRequest newReview) {
        Review review = new Review();
        review.setProductId(newReview.getProductId());
        review.setAuthor(newReview.getAuthor());
        review.setSubject(newReview.getSubject());
        review.setContent(newReview.getContent());

        reviewService.createReview(review);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Review created successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable int id, @RequestBody Review reviewDetails) {
        Review updatedReview = new Review(id, reviewDetails.getProductId(), reviewDetails.getAuthor(), reviewDetails.getSubject(), reviewDetails.getContent());
        reviewService.updateReview(id, reviewDetails);
        return ResponseEntity.ok(updatedReview);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable int id) {

        reviewService.deleteReview(id);

        return ResponseEntity.noContent().build();
    }

    // get reviews by product id
    @GetMapping("/products/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable int productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }
}