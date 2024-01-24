package dev.osakareaper.movies.services;

import dev.osakareaper.movies.models.MovieModel;
import dev.osakareaper.movies.models.ReviewModel;
import dev.osakareaper.movies.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ReviewModel newReview(String reviewBody, String imdbId) {
        ReviewModel review = reviewRepository.insert(new ReviewModel(reviewBody));

        mongoTemplate.update(MovieModel.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
