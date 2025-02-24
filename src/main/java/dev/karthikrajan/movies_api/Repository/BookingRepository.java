package dev.karthikrajan.movies_api.Repository;

import dev.karthikrajan.movies_api.DAO.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
