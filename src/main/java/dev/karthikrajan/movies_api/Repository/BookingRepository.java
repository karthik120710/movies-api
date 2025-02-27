package dev.karthikrajan.movies_api.Repository;

import dev.karthikrajan.movies_api.DAO.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends MongoRepository<Booking, String> {
    Optional<Booking>  findMovieByMovieId(String movieId);
}
