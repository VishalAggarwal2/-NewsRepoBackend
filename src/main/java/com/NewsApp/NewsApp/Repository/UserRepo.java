package com.NewsApp.NewsApp.Repository;
import com.NewsApp.NewsApp.entity.UserEntity;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoExpression;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
