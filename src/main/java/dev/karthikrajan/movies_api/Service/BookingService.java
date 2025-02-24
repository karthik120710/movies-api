package dev.karthikrajan.movies_api.Service;


import dev.karthikrajan.movies_api.DAO.Booking;
import dev.karthikrajan.movies_api.Repository.BookingRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import dev.karthikrajan.movies_api.DAO.Movie;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private static final String userId = "test-user-123";
    private final MongoTemplate mongoTemplate;

    public BookingService(BookingRepository bookingRepository, MongoTemplate mongoTemplate) {
        this.bookingRepository = bookingRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Booking createBooking(String movieId, String userId, int seats) {
        Booking booking = new Booking(movieId, userId, LocalDateTime.now(), seats);
        Booking savedBooking = bookingRepository.save(booking);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(movieId))
                .apply(new Update().push("bookingIds").value(savedBooking.getId()))
                .first();

        return savedBooking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(String id) {
        return bookingRepository.findById(id);
    }

    public void deleteBooking(String id) {
        bookingRepository.deleteById(id);
    }
}
