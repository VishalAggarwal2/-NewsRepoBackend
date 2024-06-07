package com.NewsApp.NewsApp.Service;

import com.NewsApp.NewsApp.Repository.NewResponse;
import com.NewsApp.NewsApp.Repository.NewsArticle;
import com.NewsApp.NewsApp.Repository.NewsRepo;
import com.NewsApp.NewsApp.Util.NewsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsService {

    private final RestTemplate rt;

    @Autowired
    public NewsService(RestTemplate rt) {
        this.rt = rt;
    }

    @Autowired
    private NewsRepo nr;

public List<NewsArticle> getDefault(){
        try{
            System.out.println("get request called");
            NewResponse n = rt.getForObject(NewsApi.url,NewResponse.class);
            return  n.getArticles();
        }catch (Exception e){
            return  null;
        }
}

public List<NewsArticle> getByTopic(String topic){
    System.out.println("news geted");
    System.out.println(topic);
    try{
        NewResponse n=    rt.getForObject(NewsApi.setUrl(topic), NewResponse.class);
        System.out.println(n);
        List<NewsArticle> na= n.getArticles();
        for(NewsArticle nt:na){
            System.out.println(nt.getAuthor());
        }
        return n.getArticles();
    }catch (Exception e){
        System.out.println("Exception Occured");
        e.printStackTrace();
    }
    return null;
}


}

