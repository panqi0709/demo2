package com.atpanqi.springbootaop.controller;

import com.atpanqi.springbootaop.service.TestAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

  @PostMapping("getPost")
  public String getPost(@RequestBody String aa) {
    System.out.println(aa+".................................");
    //测试git
    //测试git
    return service.getString(aa);
  }
  @RequestMapping("all")
  public String getAll(String aa) {
    return service.getString(aa);
  }
}
