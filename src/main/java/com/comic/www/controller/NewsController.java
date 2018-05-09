package com.comic.www.controller;


import com.comic.www.pojo.requestparam.NewsParam;
import com.comic.www.pojo.responseparam.News;
import com.comic.www.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/news")
@Api(value = "NewsController", description = "新闻消息")
public class NewsController {

    @Autowired
    NewsService newsService;

    @ApiOperation(value = "新闻列表获取接口", notes = "新闻标题获取")
    @RequestMapping(value = "/getTopNewsList")
    public List<News> getTopNewsList(@RequestBody NewsParam newsParam){
        News news = new News();
        news.setContent("content");
        news.setCreateTime("2018-05-08");
        news.setTitle("title");
        List<News> list = new ArrayList<>();
        list.add(news);
        return list;
    }

}
