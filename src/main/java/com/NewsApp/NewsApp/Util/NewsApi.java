package com.NewsApp.NewsApp.Util;

public class NewsApi {
    public static String url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=3972c771bd884a2287e545fc86dfa39c";

    public static String setUrl(String topic){
        String url ="https://newsapi.org/v2/everything?q="+topic+"&from=2024-05-07&sortBy=publishedAt&apiKey=dd965b07a79940f98760d18dac2bdf89";
        System.out.println("url is :------"+url);
     return url;
    }


}
