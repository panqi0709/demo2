package spirng.redis.springredis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spirng.redis.springredis.service.TestAopService;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/17 17:19
 */
@Service
@Slf4j
public class TestAopServiceImpl implements TestAopService {

  @Override
  public String getString(String aa) {
    log.info("##############################方法中执行getString aa = {}", aa);
    return aa;
  }
}
