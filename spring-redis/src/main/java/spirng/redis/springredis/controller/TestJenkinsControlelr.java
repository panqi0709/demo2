package spirng.redis.springredis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/12/8 15:51
 */
@RestController
@RequestMapping("jenkins")
public class TestJenkinsControlelr {

  @RequestMapping("getString")
  public String getString(String aa) {
    System.out.println("我去直接提交？dd，为什么直接看不到提交记录了？");
    return aa + "第二次提交123";
  }

}
