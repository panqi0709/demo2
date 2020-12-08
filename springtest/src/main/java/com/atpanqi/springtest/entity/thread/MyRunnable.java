package com.atpanqi.springtest.entity.thread;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/24 9:29
 */
public class MyRunnable implements  Runnable {
  @Override
  public void run() {
    System.out.println("Runnable.run...........");
  }
}
