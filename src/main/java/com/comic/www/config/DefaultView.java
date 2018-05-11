package com.comic.www.config;


import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @文件名：DefaultView.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-11
 * @功能描述：默认首页重定向,如果纯动态交互，适合使用这个
 */
//@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}