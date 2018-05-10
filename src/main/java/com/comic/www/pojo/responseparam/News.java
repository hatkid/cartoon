package com.comic.www.pojo.responseparam;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @文件名：News.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-10
 * @功能描述：新闻返回信息
 */
@Data
@ApiModel(value = "News")
public class News {

    @ApiModelProperty(value = "新闻id", required = true)
    private String id;

    @ApiModelProperty(value = "新闻标题", required = true)
    private String title;

    @ApiModelProperty(value = "新闻内容", required = true)
    private String content;

    @ApiModelProperty(value = "新闻时间", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
