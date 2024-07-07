package com.assessment.Faizan.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Released")
    private String relesed;

    @JsonProperty("Genre")
    private String Genre;

    @JsonProperty("Director")
    private String Director;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Writer")
    private String Writer;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("Language")
    private String Language;

    @JsonProperty("Awards")
    private String Awards;




}
