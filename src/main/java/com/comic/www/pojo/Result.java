package com.comic.www.pojo;/**
 * Created by lvzhi on 2018/5/9
 */

import com.comic.www.utils.ConstantUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @公司名称：YUTONG
 * @工程名：eap-es
 * @文件名：Result.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018/5/9
 * @功能描述：统一返回信息
 */
@Data
@ApiModel(value = "Result", description = "统一返回实体")
public class Result<T> {

    @ApiModelProperty(value = "状态码:0-正常；其它-异常;", required = true)
    private int code = ConstantUtils.ErrorCode.ERROR_OK;

    @ApiModelProperty(value = "返回说明", required = true)
    private String msg = "success";

    @ApiModelProperty(value = "返回数据", required = true)
    private T data;

}
