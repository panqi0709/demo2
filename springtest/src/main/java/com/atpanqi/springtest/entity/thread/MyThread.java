package com.atpanqi.springtest.entity.thread;

import lombok.Data;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/24 9:26
 */
@Data
public class MyThread extends Thread {

  private int a;

  private int b;
  @Override
  public void run() {
    System.out.println("Thread.run.......");
    int anInt = getInt();
    System.out.println("anInt = " + anInt);
  }

  private int getInt() {
    return a + b;
  }
}
