package com.wx.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

/**
 * @Author i531869
 * @Date 8/19/21 3:34 PM
 * @Version 1.0
 */
public class ThreadInterrupt {
  public static void main(String[] args) throws InterruptedException {
    // Thread thread = new Thread(new Runnable() {
    //   @Override
    //   public void run() {
    //     synchronized (this) {
    //       try {
    //         wait();
    //       } catch (InterruptedException e) {
    //         System.out.println("I am not waiting now");
    //       }
    //     }
    //   }
    // });
    // thread.start();
    // Thread.sleep(1000);
    // System.out.println(thread.getState() + " " + thread.isInterrupted());
    //
    // thread.interrupt();
    // Thread.sleep(1000);
    // System.out.println(thread.getState() + " " + thread.isInterrupted());

    // BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(6000000);
    // Thread thread1 = new Thread(new Runnable() {
    //   @Override
    //   public void run() {
    //     IntStream.rangeClosed(1, 500000).forEach(i -> {
    //       try {
    //         queue.put(i);
    //       } catch (InterruptedException e) {
    //         System.out.println("当前入队: " + i);
    //         System.out.println(e.getMessage());
    //       }
    //     });
    //   }
    // });
    // thread1.start();
    // Thread.sleep(50);
    // System.out.println(thread1.getState());
    // thread1.interrupt();
    // Thread.sleep(1000);
    // System.out.println(thread1.getState());
    // ExecutorService;

    // Thread thread = new Thread();
    // thread.run();
    // System.out.println(thread.getState());
    // thread.interrupt();
    // System.out.println("interrupt: " + thread.isInterrupted());
    // ExecutorService executor = Executors.newFixedThreadPool(2);
    // executor.execute(new Runnable() {
    //   @Override
    //   public void run() {
    //     // System.out.println("抛出异常");
    //     int i = 1 / 0;
    //   }
    // });
    // executor.execute(new Runnable() {
    //   @Override
    //   public void run() {
    //     System.out.println("正常输入");
    //   }
    // });
    // executor.shutdown();
    // System.out.println("z主线程执行完毕");
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("抛出异常");
        int i = 1 / 0;
      }
    });
    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread t, Throwable e) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(e.getMessage());
      }
    });
    thread.start();
    // Runtime.
  }
}
