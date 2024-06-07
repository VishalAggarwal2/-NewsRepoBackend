package com.NewsApp.NewsApp.entity;

import com.NewsApp.NewsApp.Repository.NewsArticle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class UserEntity {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    @DBRef
    private List<FavNews> favNews = new ArrayList<>();;
    public List<FavNews> getFavNews() {
        return favNews;
    }
    public void setFavNews(List<FavNews> favNews) {
        this.favNews = favNews;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
