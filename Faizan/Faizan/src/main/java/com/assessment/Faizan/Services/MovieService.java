package com.assessment.Faizan.Services;

import com.assessment.Faizan.Models.Movie;
import com.assessment.Faizan.Models.MovieList;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "afb9585b";

    @Cacheable("movies")
    public Movie getMovie(String title) {
        try {
            String url = "http://www.omdbapi.com/?t=" + title + "&apikey=" + apiKey;
            return restTemplate.getForObject(url, Movie.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Movie> getAllMovies() {
        try {
            String url = "http://www.omdbapi.com/?s=movie&apikey=" + apiKey;
            MovieList movieList = restTemplate.getForObject(url, MovieList.class);
            return movieList != null ? movieList.getSearch() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
