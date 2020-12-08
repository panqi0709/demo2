package com.atpanqi.springbootaop.controller;

import com.atpanqi.springbootaop.service.TestAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/17 20:34
 */
@RestController
@RequestMapping("other")
public class OtherController {
  @Autowired
  private TestAopService service;

  @RequestMapping("getString")
  public String getString(String aa) {
    return service.getString(aa);
  }
}
