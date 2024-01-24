package dev.osakareaper.movies.repositories;

import dev.osakareaper.movies.models.MovieModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<MovieModel, ObjectId> {
    Optional<MovieModel> findByImdbId(String imdbId);
}
