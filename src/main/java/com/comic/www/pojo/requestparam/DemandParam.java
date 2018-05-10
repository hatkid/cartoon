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
 * @功能描述：新增需求接口请求参数
 */
@Data
@ApiModel(value = "DemandParam")
public class DemandParam {

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "电话", required = true)
    private String phone;

    @ApiModelProperty(value = "需求", required = true)
    private String demandContent;

}
