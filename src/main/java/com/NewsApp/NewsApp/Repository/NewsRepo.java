package com.NewsApp.NewsApp.Repository;
import com.NewsApp.NewsApp.entity.FavNews;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface NewsRepo extends MongoRepository<FavNews,String> { }
