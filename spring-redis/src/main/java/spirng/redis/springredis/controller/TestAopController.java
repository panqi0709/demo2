package spirng.redis.springredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spirng.redis.springredis.service.TestAopService;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/17 17:17
 */
@RestController
@RequestMapping("wfy")
public class TestAopController {

  @Autowired
  private TestAopService service;

  @RequestMapping("getString")
  public String getString(String aa) {
    return service.getString(aa);
  }
}
