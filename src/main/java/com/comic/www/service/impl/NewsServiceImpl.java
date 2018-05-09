package com.comic.www.service.impl;


import com.comic.www.dao.MybatisDAO;
import com.comic.www.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
