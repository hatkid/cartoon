package com.comic.www.controller;

import com.comic.www.pojo.CommonPageListWithoutTotal;
import com.comic.www.pojo.Result;
import com.comic.www.pojo.requestparam.DemandParam;
import com.comic.www.pojo.requestparam.NewsParam;
import com.comic.www.pojo.responseparam.News;
import com.comic.www.service.DemandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @文件名：DemandController.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-10
 * @功能描述：需求控制器类
 */
@RestController
@RequestMapping("/demand")
@Api(value = "DemandController", description = "需求")
public class DemandController {

    @Autowired
    DemandService demandService;

    @ApiOperation(value = "新增需求接口", notes = "新增需求接口")
    @RequestMapping(value = "/demandParam", method = RequestMethod.POST)
    public Result addDemand(@RequestBody DemandParam demandParam){
        return demandService.addDemand(demandParam);
    }

}
