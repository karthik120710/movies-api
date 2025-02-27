package dev.karthikrajan.movies_api.Controller;


import dev.karthikrajan.movies_api.DAO.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.karthikrajan.movies_api.Service.MoviesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:5173")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(
                moviesService.getAllMovies(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){

        return new ResponseEntity<Optional<Movie>>(
                moviesService.getById(imdbId),
                HttpStatus.OK
        );
    }


}

