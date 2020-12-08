package com.atpanqi.springbootaop.config;

import com.atpanqi.springbootaop.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/18 15:39
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MyInterceptor())
            .addPathPatterns("/**").excludePathPatterns("/wfy/all");
  }
}
