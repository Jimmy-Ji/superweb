package com.jimmy.intercepters;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jim on 16-1-12.
 */
public class UrlControllerNameInterceptor extends HandlerInterceptorAdapter{

    ThreadLocal<Long> threadLocal = new ThreadLocal();

    Logger log = Logger.getLogger(UrlControllerNameInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String controllerName = handler.toString();
        String requestName = request.getRequestURL().toString();
        log.info("请求："+requestName+"  处理器："+controllerName);
        Long time = System.currentTimeMillis();
        threadLocal.set(time);
        return true;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        Long start_time = threadLocal.get();
        Long end_time = System.currentTimeMillis();
        long between = end_time - start_time;
        log.info("请求："+request.getRequestURL().toString()+"结束; 耗时："+between);
    }

}
