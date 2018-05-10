package com.comic.www.service;

import com.comic.www.pojo.Result;
import com.comic.www.pojo.requestparam.DemandParam; /**
 * @公司名称：YUTONG
 * @工程名：www
 * @文件名：DemandService.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-10
 * @功能描述：需求服务接口层
 */
public interface DemandService {

    /**
     * @函数介绍：新增需求接口
     * @参数 null
     * @返回值：
     */
    Result addDemand(DemandParam demandParam);
}
