package dev.karthikrajan.movies_api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Review {

    private ObjectId id;
    private String reviewBody;

    public Review(String reviewBody) {
        this.reviewBody=reviewBody;
    }

    public ObjectId getId() {
        return id;
    }

    public String getReviewBody() {
        return reviewBody;
    }
}