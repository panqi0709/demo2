package spirng.redis.springredis.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/17 17:38
 */
@WebFilter(filterName = "MyFilter", urlPatterns = "/wfy/*")
@Slf4j
public class MyFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) {
    log.info("##############################MyFilter.init");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    log.info("##############################MyFilter.doFilter filterChain.doFilter 前");
    filterChain.doFilter(servletRequest, servletResponse);
    log.info("##############################MyFilter.doFilter filterChain.doFilter 后");
  }

  @Override
  public void destroy() {
    log.info("##############################MyFilter.destroy");
  }
}
