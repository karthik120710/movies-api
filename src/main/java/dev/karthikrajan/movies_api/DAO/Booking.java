package dev.karthikrajan.movies_api.DAO;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "bookings")
public class Booking {

    public Booking(String movieId,String userId, LocalDateTime bookingTime, int numberOfSeats) {
        this.movieId = movieId;
        this.userId = userId;
        this.bookingTime = bookingTime;
        this.numberOfSeats = numberOfSeats;
    }


    @Id
    private String id;

    public String getId() {
        return id;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    private String movieId;
    private String userId;
    private LocalDateTime bookingTime;
    private int numberOfSeats;
}
