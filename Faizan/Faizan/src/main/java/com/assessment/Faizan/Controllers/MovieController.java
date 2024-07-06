package com.assessment.Faizan.Controllers;

import com.assessment.Faizan.Models.Movie;
import com.assessment.Faizan.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/search")
    public ResponseEntity<Movie> searchMovie(@RequestParam String title) {
        Movie movie = movieService.getMovie(title);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Movie>> getPopularMovies() {
        List<Movie> movies = movieService.getPopularMovies();
        return ResponseEntity.ok(movies);
    }
}