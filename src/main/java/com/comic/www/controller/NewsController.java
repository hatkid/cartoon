package com.comic.www.controller;



import com.comic.www.pojo.CommonPageListWithoutTotal;
import com.comic.www.pojo.Result;
import com.comic.www.pojo.requestparam.NewsParam;
import com.comic.www.pojo.requestparam.NewsPreAndNextParam;
import com.comic.www.pojo.responseparam.News;
import com.comic.www.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@Api(value = "NewsController", description = "新闻消息")
public class NewsController {

    @Autowired
    NewsService newsService;

    @ApiOperation(value = "新闻列表获取接口", notes = "新闻列表获取接口")
    @RequestMapping(value = "/getNewsList", method = RequestMethod.POST, produces = "application/json")
    public Result<CommonPageListWithoutTotal<News>> getNewsList(@RequestBody NewsParam newsParam){
        return newsService.getNewsList(newsParam);
    }

    @ApiOperation(value = "翻页接口", notes = "翻页接口")
    @RequestMapping(value = "/getPreAndNextNewsList", method = RequestMethod.POST,produces = "application/json")
    public Result<CommonPageListWithoutTotal<News>> getPreAndNextNewsList(@RequestBody NewsPreAndNextParam newsPreAndNextParam){
        return newsService.getPageList(newsPreAndNextParam);
    }

}
