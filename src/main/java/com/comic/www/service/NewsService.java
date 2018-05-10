package com.comic.www.service;

import com.comic.www.pojo.CommonPageListWithoutTotal;
import com.comic.www.pojo.Result;
import com.comic.www.pojo.requestparam.NewsParam;
import com.comic.www.pojo.requestparam.NewsPreAndNextParam;
import com.comic.www.pojo.responseparam.News;

/**
 * @文件名：NewsService.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-7
 * @功能描述：新闻模块服务接口层
 */
public interface NewsService {

    /**
     * @函数介绍：新闻列表
     * @参数 null
     * @返回值：
     */
    Result getNewsList(NewsParam newsParam);

    /**
     * @函数介绍：翻页接口
     * @参数
     * @返回值：
     */
    Result<CommonPageListWithoutTotal<News>> getPageList(NewsPreAndNextParam newsPreAndNextParam);
}
