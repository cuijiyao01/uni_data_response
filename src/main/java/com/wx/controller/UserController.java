package com.wx.controller;

import com.wx.domain.User;
import com.wx.service.IUserService;
import com.wx.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author i531869
 * @Date 2020/12/8 20:50
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping("addUser")
  public ResultVO<String> addUser(@RequestBody @Valid User user) {
    log.info(user.toString());
    return new ResultVO<>(userService.addUser(user));
  }

  @GetMapping("/getUser/{id}")
  public User getUser(@PathVariable Integer id){
    log.info("id:{}",id);
    User user =userService.getUser(id);
    return user;
  }

  @GetMapping("hello")
  public String hello() {
    return "hello";
  }


}
