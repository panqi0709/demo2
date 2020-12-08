package com.atpanqi.springbootaop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/17 17:38
 */

@Slf4j
//@WebFilter(filterName = "myFilter", urlPatterns = "/wfy/*")
public class MyFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) {
    log.info("##############################MyFilter.init");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    log.info("##############################MyFilter.doFilter filterChain.doFilter 前");
    log.info("进入DealStreamFilter。。。。。。");
    final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

    final HttpServletRequestWrapper requestWrapper = new MyHttpServletRequestWrapper(httpServletRequest);
    final String requestBody = requestWrapper.toString();

    filterChain.doFilter(servletRequest, servletResponse);
    log.info("##############################MyFilter.doFilter filterChain.doFilter 后");
  }

  @Override
  public void destroy() {
    log.info("##############################MyFilter.destroy");
  }

  static class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public MyHttpServletRequestWrapper(HttpServletRequest request)
    {
      super(request);
    }

    private String getBodyAsString()
    {
      StringBuffer buff = new StringBuffer();
      buff.append(" BODY_DATA START [ ");
      char[] charArr = new char[getContentLength()];
      try
      {
        BufferedReader reader = new BufferedReader(getReader());
        reader.read(charArr, 0, charArr.length);
        reader.close();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      buff.append(charArr);
      buff.append(" ] BODY_DATA END ");
      return buff.toString();
    }

    public String toString()
    {
      return getBodyAsString();
    }
  }
}
