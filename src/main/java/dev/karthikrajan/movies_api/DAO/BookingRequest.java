package dev.karthikrajan.movies_api.DAO;
public class BookingRequest {
    private String movieId;
    private String userId;
    private int seats;

    // Getters and Setters
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }
}