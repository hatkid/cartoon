package com.comic.www.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @文件名：CommonList.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018/5/9
 * @功能描述：带分页的集合
 */
@Data
@ApiModel(value = "CommonPageListWithTotal")
public class CommonPageListWithTotal<T> {

    @ApiModelProperty(value = "总数", required = true)
    private int totalCount;

    @ApiModelProperty(value = "数据", required = true)
    private List<T> data;


}
