package com.wx.thread;

import lombok.SneakyThrows;

/**
 * @Author i531869
 * @Date 8/18/21 8:22 PM
 * @Version 1.0
 */
public class ThreadJoin {
  public static void main(String[] args) {
    //通过join方法,使得执行T3前先执行T2,执行T2前先执行T1;
    Thread t1 = new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "执行完毕!");
      }
    }, "T1");

    Thread t2 = new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Thread.sleep(1000);
        t1.start();
        t1.join();  //t1执行完之后执行t2
        System.out.println(Thread.currentThread().getName() + "执行完毕!");
      }
    }, "T2");

    Thread t3 = new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        t2.start();
        t2.join();
        System.out.println(Thread.currentThread().getName() + "执行完毕!");
      }
    }, "T3");
    t3.start();
  }
}
