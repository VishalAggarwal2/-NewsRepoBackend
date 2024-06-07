package com.NewsApp.NewsApp.Repository;

import com.NewsApp.NewsApp.entity.FavNews;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInput {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String password;
    public List<FavNews> favNews;
}

