package dev.karthikrajan.movies_api.Controller;

import dev.karthikrajan.movies_api.DAO.Booking;
import dev.karthikrajan.movies_api.DAO.BookingRequest;
import dev.karthikrajan.movies_api.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {
    private final BookingService bookingService;


    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest bookingRequest) {
        String bookingId = bookingService.createBooking(
                bookingRequest.getMovieId(),
                bookingRequest.getUserId(),
                bookingRequest.getNumberOfSeats(),
                bookingRequest.getBookingDate(),
                bookingRequest.getShowTime()

        );

        bookingRequest.toString();
        return ResponseEntity.ok(bookingId);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable("id") String movieId) {
       // return bookingService.getBookingById(movieId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

        return new ResponseEntity<Optional<Booking>>(
                bookingService.getBookingById(movieId),
                HttpStatus.OK
        );
    }
}
