package com.NewsApp.NewsApp.Controller;

import com.NewsApp.NewsApp.Repository.NewResponse;
import com.NewsApp.NewsApp.Repository.NewsArticle;
import com.NewsApp.NewsApp.Service.NewsService;
import com.NewsApp.NewsApp.Service.UserService;
import com.NewsApp.NewsApp.Util.NewsApi;
import com.NewsApp.NewsApp.entity.FavNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class NewController {
   @Autowired
   private NewsService ns;
   @Autowired
   private UserService us;

    @GetMapping("/{topic}")
    public List<NewsArticle> getNews(@PathVariable String topic){
       return ns.getByTopic(topic);
    }
    @GetMapping
    public List<NewsArticle> getDefaultNews(){
        return  ns.getDefault();
    }

    @GetMapping("/{userId}/favNews")
    public List<FavNews> getFavNews(@PathVariable String userId){
    return  us.favArticle(userId);
    }

    @PostMapping("/{userId}/addFav")
    public String saveFavNews(@RequestBody FavNews fa,@PathVariable String userId){
        return us.addFavNews(fa,userId);
    }

    @GetMapping("/{userId}/{newsId}")
    public String deleteFavNews(@PathVariable String userId,@PathVariable String newsId){
        return us.deleteFavNews(userId,newsId);

    }

}
