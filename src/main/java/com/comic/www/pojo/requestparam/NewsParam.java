package com.comic.www.pojo.requestparam;

import com.comic.www.pojo.PageBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @文件名：NewsParam.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-9
 * @功能描述：新闻请求接口请求参数
 */
@Data
@ApiModel(value = "NewsParam")
public class NewsParam extends PageBase {

    @ApiModelProperty(value = "新闻类型：1-头部新闻；2-页面新闻", required = true)
    private int type;
}
