package com.assessment.Faizan.Controllers;

import com.assessment.Faizan.Models.Movie;
import com.assessment.Faizan.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/search")
    public ResponseEntity<Movie> searchMovie(@RequestParam String title) {
        Movie movie = movieService.getMovie(title);
        if (movie == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movie);
    }
}
