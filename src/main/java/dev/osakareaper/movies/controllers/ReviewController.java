package dev.osakareaper.movies.controllers;

import dev.osakareaper.movies.models.ReviewModel;
import dev.osakareaper.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewModel> postNewReview(@RequestBody Map<String, String> payload) {
        ReviewModel review = reviewService.newReview(payload.get("reviewBody"), payload.get("imdbId"));
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

}
