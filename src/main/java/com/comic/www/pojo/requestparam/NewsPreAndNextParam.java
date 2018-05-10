package com.comic.www.pojo.requestparam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @文件名：NewsPreAndNextParam.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-10
 * @功能描述：新闻上一条和下一条
 */
@Data
@ApiModel(value = "NewsPreAndNextParam")
public class NewsPreAndNextParam {

    @ApiModelProperty(value = "新闻类型：1-头部新闻；2-页面新闻", required = true)
    private int type = 1;

    @ApiModelProperty(value = "新闻id", required = true)
    private int id;

    @ApiModelProperty(value = "排序规则，隐藏字段", hidden = true)
    private String order;

    @ApiModelProperty(value = "操作符，隐藏字段", hidden = true)
    private String operator;
}
