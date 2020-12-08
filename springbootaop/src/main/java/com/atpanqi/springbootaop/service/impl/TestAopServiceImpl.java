package com.atpanqi.springbootaop.service.impl;

import com.atpanqi.springbootaop.service.TestAopService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    return "原始版本 = "+ aa;
  }
}
