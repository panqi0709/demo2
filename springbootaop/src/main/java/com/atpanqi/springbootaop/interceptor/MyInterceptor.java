package com.atpanqi.springbootaop.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/18 14:06
 */

@Slf4j
public class MyInterceptor extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    log.info("进入拦截器preHandle***********************************");
    log.info("记录访问接口：{}", request.getRequestURI());
    BufferedReader reader = request.getReader();
    System.out.println("reader == null     ====" + reader == null);
//    BufferedReader reader2 = request.getReader();
//
//    System.out.println("reader2 == null     ====" + reader2 == null);

    String postParams = JSON.toJSONString(request.getParameterMap());
    System.out.println("postParams   ====" + postParams);
    return true;
  }

  @Override
  public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.info("进入拦截器afterConcurrentHandlingStarted***********************************");
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    log.info("进入拦截器postHandle***********************************");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    log.info("进入拦截器afterCompletion***********************************");
  }
}
