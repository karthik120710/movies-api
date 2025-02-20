package dev.karthikrajan.movies_api.Service;
import dev.karthikrajan.movies_api.Movie;
import dev.karthikrajan.movies_api.Repository.MoviesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Optional<Movie> getById(ObjectId id) {
        return moviesRepository.findById(id);
    }
}
