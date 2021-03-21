package com.wx.service.impl;

import com.wx.domain.User;
import com.wx.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author i531869
 * @Date 2020/12/9 16:28
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

  @Override
  public String addUser(User user) {
    return "success";
  }

  @Override
  public User getUser(Integer id) {
    User user = new User();
    user.setId(id);
    user.setAge(18);
    user.setEmail("jason.cui01@google.com");
    user.setName("Jason");
    return user;
  }
}
