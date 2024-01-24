package dev.osakareaper.movies.controllers;

import dev.osakareaper.movies.models.MovieModel;
import dev.osakareaper.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Object> getAllMovies() {
        List<MovieModel> moviesList = movieService.allMovies();
        if (moviesList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No movies listed!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(moviesList);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Object> getMovieByImdbId(@PathVariable(value = "imdbId") String imdbId) {
        Optional<MovieModel> movieO = movieService.movieByImdbId(imdbId);
        if (movieO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(movieO);
    }
}
