package com.wx.service;

import com.wx.domain.User;

/**
 * @Author i531869
 * @Date 2020/12/9 16:23
 * @Version 1.0
 */
public interface IUserService {
  String addUser(User user);

  User getUser(Integer id);
}
