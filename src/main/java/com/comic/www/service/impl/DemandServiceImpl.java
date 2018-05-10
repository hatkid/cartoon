package com.comic.www.service.impl;

import com.comic.www.dao.MybatisDAO;
import com.comic.www.pojo.Result;
import com.comic.www.pojo.requestparam.DemandParam;
import com.comic.www.service.DemandService;
import com.comic.www.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @文件名：DemandServiceImpl.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-10
 * @功能描述：需求服务接口实现层
 */
@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    MybatisDAO mybatisDAO;

    /**
     * @函数介绍：新增需求接口
     * @参数 null
     * @返回值：
     */
    @Override
    public Result addDemand(DemandParam demandParam) {
        Result result = new Result();
        if (StringUtils.isEmpty(demandParam) || StringUtils.isEmpty(demandParam.getName())
                || demandParam.getName().length() > 10) {
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("name为空或者长度超过10");
            return result;
        }
        if (StringUtils.isEmpty(demandParam.getPhone()) || demandParam.getPhone().length() > 15) {
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("phone为空或者长度超过15");
            return result;
        }
        if (StringUtils.isEmpty(demandParam.getDemandContent()) || demandParam.getDemandContent().length() > 2000) {
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("需求内容为空或者长度超过2000");
            return result;
        }
        int count = mybatisDAO.insert("Demand.addDemand", demandParam);
        if ( count != 1 ) {
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("入库失败");
            return result;
        }
        return result;
    }
}
