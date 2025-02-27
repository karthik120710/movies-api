package dev.karthikrajan.movies_api.Service;

import dev.karthikrajan.movies_api.DAO.Booking;
import dev.karthikrajan.movies_api.DAO.Movie;
import dev.karthikrajan.movies_api.Repository.BookingRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final MongoTemplate mongoTemplate;

    public BookingService(BookingRepository bookingRepository, MongoTemplate mongoTemplate) {
        this.bookingRepository = bookingRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public String createBooking(String movieId, String userId, int numberOfSeats, String bookingDate, String showTime) {
        // Create a new Booking object
        Booking booking = new Booking(movieId, userId, LocalDateTime.now(), numberOfSeats, bookingDate, showTime);

        // Save the booking and get the saved object
        Booking savedBooking = bookingRepository.save(booking);

        System.out.println(movieId+" "+userId+" "+numberOfSeats+" "+bookingDate+" "+showTime);

        // Update the associated movie with the new booking ID
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(movieId))
                .apply(new Update().push("bookingIds").value(savedBooking.getId()))
                .first();

        // Return the generated booking ID
        return savedBooking.getMovieId();
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(String id) {
        return bookingRepository.findById(id);
    }
}