package dev.osakareaper.movies.services;

import dev.osakareaper.movies.models.MovieModel;
import dev.osakareaper.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieModel> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<MovieModel> movieByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }

}
