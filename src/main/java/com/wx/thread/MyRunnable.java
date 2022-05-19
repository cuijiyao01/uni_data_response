package com.wx.thread;

import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.TimeUnit;

/**
 * @Author i531869
 * @Date 8/25/21 5:05 PM
 * @Version 1.0
 */
public class MyRunnable implements Runnable {
  int i = 0;

  @Override
  public void run() {
    Thread currentThread = Thread.currentThread();
    System.out.println(currentThread.getName() + "-------------进入");
    try {
      i++;
    } finally {
      System.out.println(currentThread.getName() + "-------------离开");
    }

  }

  public static void main(String[] args) {
    Person p = new Person();
    // MyRunnable myRunnable = new MyRunnable();
    // Thread thread1 = new Thread(myRunnable, "线程1");
    // Thread thread2 = new Thread(myRunnable, "线程2");
    // Thread thread3 = new Thread(myRunnable, "线程3");
    //
    // thread1.start();
    // thread2.start();
    // thread3.start();
  }
}
