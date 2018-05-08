package com.comic.www.controller;


import com.comic.www.pojo.requestparam.NewsParam;
import com.comic.www.pojo.responseparam.News;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/news")
public class NewsController {

    @RequestMapping(value = "/getTopNewsList")
    public List<News> getTopNewsList(){
        News news = new News();
        news.setContent("content");
        news.setCreateTime("2018-05-08");
        news.setTitle("title");
        List<News> list = new ArrayList<>();
        list.add(news);
        return list;
    }

}
