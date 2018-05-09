package com.comic.www.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by lvzhi on 2018/5/8
 */
@Data
@ApiModel(value = "PageBase")
public class PageBase {

    @ApiModelProperty(value = "每页数据量", required = true)
    private int pageSize;

    @ApiModelProperty(value = "页码", required = true)
    private int pageNo;

}
