package dev.karthikrajan.movies_api.Repository;

import dev.karthikrajan.movies_api.DAO.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId>
{

}
