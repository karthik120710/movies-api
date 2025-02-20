package dev.karthikrajan.movies_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Collections;
import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @JsonProperty("id")
    private ObjectId id;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("trailerLink")
    private String trailerLink;
    @JsonProperty("genres")
    private List<String> genres;
    @JsonProperty("poster")
    private String poster;
    @JsonProperty("backdrops")
    private List<String> backdrops;

    @DocumentReference
    @JsonProperty("reviews")
    private List<Review> reviews;

    private void getReviews(Review review){
        this.reviews= Collections.singletonList(review);
    }

}
