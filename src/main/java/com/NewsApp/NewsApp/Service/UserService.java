package com.NewsApp.NewsApp.Service;

import com.NewsApp.NewsApp.Convertor.UitoUr;
import com.NewsApp.NewsApp.Repository.*;
import com.NewsApp.NewsApp.entity.FavNews;
import com.NewsApp.NewsApp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo ur;

    @Autowired
    private NewsRepo n;

    @Autowired
    private EmailService es;

    public String Login(UserInput us){
        System.out.println("User Login");
        UserEntity ue = UitoUr.convertor(us);
        Optional<UserEntity> ut = ur.findByEmail(ue.getEmail());
        if(ut.isPresent()){
            System.out.println("user already exist");
            return "User Already Exist";
        }else{

            ur.save(ue);
            es.sendSimpleMessage(ue.getEmail(),"Welcome To NewsMania",
                    "Thank you for choosing us as your go-to destination for the latest news, insightful articles, and captivating stories. As a valued member of our community, you are now part of a vibrant network of news enthusiasts who share a passion for staying informed and engaged with the world around them.\n" +
                    "\n" +
                    "At [Your News Website], our mission is to deliver accurate, relevant, and thought-provoking content that enriches your daily life. Whether you're interested in breaking news, technology trends, entertainment updates, or educational insights, we've got you covered.\n" +
                    "\n" +
                    "As you embark on your journey with us, we encourage you to explore all that our platform has to offer. From curated news sections to personalized recommendations, we've designed [Your News Website] to provide you with a seamless and enjoyable browsing experience.\n" +
                    "\n" +
                    "Don't forget to customize your preferences, save your favorite articles, and interact with fellow readers through comments and discussions. Your feedback is invaluable to us as we strive to continuously improve and tailor our services to meet your needs.\n" +
                    "\n" +
                    "Once again, welcome aboard! We're excited to have you join us, and we look forward to keeping you informed, inspired, and entertained every step of the way.\n" +
                    "\n" +
                    "If you have any questions, suggestions, or feedback, please don't hesitate to reach out to our dedicated support team. We're here to assist you and ensure that your experience with [Your News Website] is nothing short of exceptional.\n" +
                    "\n" +
                    "Here's to new beginnings and endless discoveries!\n" +
                    "\n" );


            return "User Login";

        }
    }
 public Optional<UserEntity> Signup(UserLoginInput uli){
     System.out.println("Signup function ");
        Optional<UserEntity> ue = ur.findByEmail(uli.email);
          System.out.println("comes here "+ue);
     if (ue.isPresent()) {
         UserEntity userEntity = ue.get();
         if (userEntity.getPassword().equals(uli.password)) {
             return ue;
         } else {
             System.out.println("Invalid Password");
             return null;
         }
     } else {
         return null;
     }
 }

public List<FavNews> favArticle(String id){
    System.out.println("Function Called");
    Optional<UserEntity> ue = ur.findById(id);
    if(ue.isPresent()){
        UserEntity userEntity = ue.get();
        UserInput ui = UitoUr.convertor(userEntity);
        return  ui.favNews;


    }else {
        return  null;
    }
}

public String addFavNews(FavNews f,String id){
    System.out.println("Function Called");
    Optional<UserEntity> ue = ur.findById(id);
    if(ue.isPresent()){
        UserEntity userEntity = ue.get();
        n.save(f);
        List<FavNews> favNewsList = userEntity.getFavNews();
        favNewsList.add(f); // Add the favorite news article to the user's list
        userEntity.setFavNews(favNewsList);
        ur.save(userEntity); // Save the updated user entity
        return "News Added Succ";
    }else {
        return  "Not Added User Not Found";
    }
}


    public String deleteFavNews(String userId, String newsId) {
        System.out.println("Delete Function Called");
        Optional<UserEntity> ue = ur.findById(userId);
        if (ue.isPresent()) {
            UserEntity userEntity = ue.get();
            List<FavNews> favNewsList = userEntity.getFavNews();
            if (favNewsList != null) {
                boolean removed = favNewsList.removeIf(favNews -> favNews.getNewsId().equals(newsId));
                if (removed) {
                    userEntity.setFavNews(favNewsList);
                    ur.save(userEntity); // Save the updated user entity
                    // Optionally remove the FavNews from the FavNews collection if no longer referenced
                    if (favNewsList.stream().noneMatch(favNews -> favNews.getNewsId().equals(newsId))) {
                        n.deleteById(newsId);
                    }
                    return "Favorite News Deleted Successfully";
                } else {
                    return "Favorite News Not Found";
                }
            } else {
                return "Favorite News List is Empty";
            }
        } else {
            return "User Not Found";
        }
    }

}
