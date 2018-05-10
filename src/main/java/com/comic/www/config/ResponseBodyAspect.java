package com.comic.www.config;

import com.comic.www.pojo.Result;
import com.comic.www.utils.ConstantUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @文件名：ResponseBodyAspect.java
 * @作者：lvzhi
 * @版本号：1.0
 * @生成日期：2018-5-10
 * @功能描述：同一拦截处理器
 */
@Aspect
@Component
public class ResponseBodyAspect {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ResponseBodyAspect.class);

    private static final int TOKEN_LENGTH = 8 ;

    @Pointcut("(@within(org.springframework.web.bind.annotation.RestController) && @annotation(org.springframework.web.bind.annotation.RequestMapping)) || @annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public void responseBody() {
    }
    @Around("responseBody()")
    public Object around(ProceedingJoinPoint joinPoint) {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Object data = null;
        String token = RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH);
        try {
            logger.info("[{}] - {}.{} 请求参数：{}", token, signature.getDeclaringType().getSimpleName(), signature.getMethod().getName(), args);
            data = joinPoint.proceed(args);
            stopWatch.stop();
        } catch (Exception e) {
            logger.error("exception all", e);
            Result result = new Result();
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("exception all ");
            return result;
        }catch (Throwable e) {
            logger.error("throwable all", e);
            Result result = new Result();
            result.setCode(ConstantUtils.ErrorCode.ERROR_FAILE);
            result.setMsg("throwable all ");
            return result;
        }finally {
            logger.info("[{}] - 耗时：{}，请求应答：{}", token, stopWatch.getTotalTimeSeconds(),data);
        }
        return data;
    }

}
