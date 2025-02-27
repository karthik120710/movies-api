package dev.karthikrajan.movies_api.DAO;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "bookings")
public class Booking {

    public Booking(String movieId,String userId, LocalDateTime bookingTime, int numberOfSeats,String bookingDate,String showTime) {
        this.movieId = movieId;
        this.userId = userId;
        this.bookingTime = bookingTime;
        this.numberOfSeats = numberOfSeats;
        this.bookingDate = bookingDate;
        this.showTime = showTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getMovieId() {
        return movieId;
    }

    @Id
    private String id;

    private String movieId;
    private String userId;
    private LocalDateTime bookingTime;
    private int numberOfSeats;
    private String bookingDate;
    private String showTime;
}
