package com.wx.service.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author i531869
 * @Date 8/18/21 8:45 PM
 * @Version 1.0
 */
@Service
@Slf4j
public class AsyncServiceImpl {

  @SneakyThrows
  @Async("threadPoolTaskExecutor")
  public void process() {
    log.info("开始执行异步任务...");
    log.info("正在执行异步任务...");
    Thread.sleep(3000);
    log.info("结束执行异步任务...");
  }
}
