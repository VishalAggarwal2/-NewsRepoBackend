package com.NewsApp.NewsApp.Convertor;

import com.NewsApp.NewsApp.Repository.UserInput;
import com.NewsApp.NewsApp.Repository.UserRepo;
import com.NewsApp.NewsApp.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UitoUr {
    public static  UserEntity convertor(UserInput u){
      UserEntity ue= new UserEntity();
      ue.setId(u.id);
      ue.setEmail(u.email);
      ue.setFirstName(u.firstName);
      ue.setLastName(u.lastName);
      ue.setPhone(u.phone);
      ue.setPassword(u.password);
      return  ue;
    }

    public  static  UserInput convertor(UserEntity ue){
        UserInput ui = new UserInput();
        ui.firstName = ue.getFirstName();
        ui.lastName=ue.getLastName();
        ui.phone=ue.getPhone();
        ui.password=ue.getPassword();
        ui.id=ue.getId();
        ui.favNews=ue.getFavNews();
        return ui;
    }
}
