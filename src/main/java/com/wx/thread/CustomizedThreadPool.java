package com.wx.thread;

import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

/**
 * @Author i531869
 * @Date 8/18/21 5:07 PM
 * @Version 1.0
 */
@EnableAsync
public class CustomizedThreadPool {

  class WorkerThread extends Thread {
    public WorkerThread(String name) {
      super(name);
    }

    @Override
    public void run() {
      while (true) {
        Runnable task = null;
        try {
          task = taskQueue.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        task.run();
      }
    }
  }

  private BlockingQueue<Runnable> taskQueue;

  private List<WorkerThread> workers;

  public CustomizedThreadPool(BlockingQueue<Runnable> taskQueue, int threadSize) {
    this.taskQueue = taskQueue;
    //初始化线程池
    this.workers = new ArrayList<>(threadSize);
    IntStream.rangeClosed(1, threadSize).forEach(i -> {
      WorkerThread thread = new WorkerThread("myThread" + i);
      thread.start();
      workers.add(thread);
    });
  }

  public void execute(Runnable task) {
    taskQueue.add(task);
  }

  public static void main(String[] args) {
    BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>(10);
    CustomizedThreadPool threadPool = new CustomizedThreadPool(taskQueue, 5);
    IntStream.rangeClosed(1, 10).forEach(i -> {
      threadPool.execute(() -> {
        System.out.println(Thread.currentThread().getName() + "正在打怪升级.....");
      });
    });

  }

}
