package com.wx.controller;

import com.wx.service.impl.AsyncServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 8/18/21 8:48 PM
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

  @Autowired
  private AsyncServiceImpl asyncService;

  @GetMapping("/process")
  public void process() {
    asyncService.process();
    log.info("先走一步...");
  }
}
