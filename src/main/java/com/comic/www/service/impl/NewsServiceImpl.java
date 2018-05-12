package com.comic.www.service.impl;


import com.comic.www.dao.MybatisDAO;
import com.comic.www.pojo.CommonPageListWithoutTotal;
import com.comic.www.pojo.Result;
import com.comic.www.pojo.requestparam.NewsParam;
import com.comic.www.pojo.requestparam.NewsPreAndNextParam;
import com.comic.www.pojo.responseparam.News;
import com.comic.www.service.NewsService;
import com.comic.www.utils.ConstantUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @文件名：NewsServiceImpl.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-9
 * @功能描述：新闻服务层实现类
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    MybatisDAO mybatisDAO;

    /**
     * @函数介绍：新闻列表
     * @参数 null
     * @返回值：
     */
    @Override
    public Result getNewsList(NewsParam newsParam) {
        Result result = new Result();
        if (newsParam == null) {
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("参数异常");
        }
        Page page = PageHelper.startPage(newsParam.getPageNo(),newsParam.getPageSize());
        List<News> newList = mybatisDAO.getList("News.getNewsList", newsParam);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("totalCount",page.getTotal());
        retMap.put("data", newList);
        result.setData(retMap);
        return result;
    }

    /**
     * @函数介绍：翻页接口
     * @参数
     * @返回值：
     */
    @Override
    public Result<CommonPageListWithoutTotal<News>> getPageList(NewsPreAndNextParam newsPreAndNextParam) {
        Result result = new Result();
        if (StringUtils.isEmpty(newsPreAndNextParam.getId())) {
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("参数异常");
            return result;
        }
        newsPreAndNextParam.setOrder("desc");
        newsPreAndNextParam.setOperator("<");
        News preNews = mybatisDAO.get("News.getPage", newsPreAndNextParam);
        Map<String, Object> retMap = new HashMap<>();
        if ( preNews != null ) {
            retMap.put("pre", preNews);
        }
        newsPreAndNextParam.setOrder("asc");
        newsPreAndNextParam.setOperator(">");
        News nextNews = mybatisDAO.get("News.getPage", newsPreAndNextParam);
        if ( nextNews != null ) {
            retMap.put("next", nextNews);
        }
        newsPreAndNextParam.setOrder("asc");
        newsPreAndNextParam.setOperator("=");
        News currentNew = mybatisDAO.get("News.getPage", newsPreAndNextParam);
        if ( currentNew != null ) {
            retMap.put("current", currentNew);
        }

        if ( retMap.size() > 0 ){
            result.setData(retMap);
        } else {
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("无数据");
        }
        return result;
    }
}
