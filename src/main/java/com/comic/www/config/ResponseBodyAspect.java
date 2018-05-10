package com.comic.www.config;

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
 * @功能描述：TODO
 */
//@Aspect
//@Component
public class ResponseBodyAspect {

    private static final int TOKEN_LENGTH = 8 ;
    private static final int RES_LENGTH = 300 ;

//    @Pointcut("(@within(org.springframework.web.bind.annotation.RestController) && @annotation(org.springframework.web.bind.annotation.RequestMapping)) || @annotation(org.springframework.web.bind.annotation.ResponseBody)")
//    public void responseBody() {
//    }
//    @Around("responseBody()")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        StopWatch stopWatch=new StopWatch();
//        stopWatch.start();
//        Object[] args = joinPoint.getArgs();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Object data = null;
//        String token = RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH);
//        try {
//            LogUtils.info("[{}] - {}.{} 请求参数：{}", token, signature.getDeclaringType().getSimpleName(), signature.getMethod().getName(), args);
//            if(args.length > 0) {
//                for(Object arg : args) {
//                    if(arg instanceof ApiParam) {
//                        ((ApiParam) arg).check();
//                    }
//                }
//            }
//            data = joinPoint.proceed(args);
//            stopWatch.stop();
//        } catch (BizException e) {
//            LogUtils.error(ResponseEnum.EXCEPTION.getName(), e);
//            data =Result.result(e.getCode(), e.getMsg(),null) ;
//        } catch (AppBaseException e) {
//        	Throwable cause = e.getCause();
//            if (cause instanceof SdkBaseException) {
//                LogUtils.error(ResponseEnum.EXCEPTION.getName(), e);
//                data=convertError(e);
//            } else {
//            	LogUtils.error(e.getMessage(), e);
//            	data =Result.result(e.getExceptionCode(), e.getMessage(),null);
//            }
//        } catch (Throwable e) {
//            LogUtils.error(ResponseEnum.EXCEPTION.getName(), e);
//            data=convertError(e);
//        } finally {
//            LogUtils.info("[{}] - 耗时：{}，请求应答：{}", token, stopWatch.getTotalTimeSeconds(),data);
//        }
//        // MDC.put("logTraceResult", Objects.toString(data, ""));//如果logtraceParamSwitch = 0即不收集出参则该行代码可注释掉。
//        return data;
//    }
//
//    /**
//     * 异常转换
//     * @param e
//     * @return
//     */
//    public Object convertError(Throwable e){
//        //如果里面包装的是SdkBaseException，并且有bsp的异常码，进行bsp->app异常码转换
//        Integer errorCode=ResponseEnum.EXCEPTION.getCode();
//        String errorMsg=ResponseEnum.EXCEPTION.getName();
//        Throwable cause = e.getCause();
//        if (cause instanceof SdkBaseException) {
//            SdkBaseException sdkBaseExcept = (SdkBaseException) cause;
//            int bspErrorCode = sdkBaseExcept.getErrorCode();
//            if (bspErrorCode != 0) {
//                errorCode = ErrorCode.getAppErrorCode(bspErrorCode);
//                errorMsg = sdkBaseExcept.getMessage();
//            }
//        }
//        Object data = Result.result(errorCode, errorMsg,null) ;
//        return data;
//
//    }
}
