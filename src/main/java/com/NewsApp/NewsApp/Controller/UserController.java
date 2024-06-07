package com.NewsApp.NewsApp.Controller;

import com.NewsApp.NewsApp.Repository.UserInput;
import com.NewsApp.NewsApp.Repository.UserLoginInput;
import com.NewsApp.NewsApp.Service.UserService;
import com.NewsApp.NewsApp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;
    @PostMapping
    public String userLogin(@RequestBody UserInput u){
      return us.Login(u);
    }

   @PostMapping("/login")
    public Optional<UserEntity> userSignup(@RequestBody UserLoginInput u){
        return  us.Signup(u);
    }

}

