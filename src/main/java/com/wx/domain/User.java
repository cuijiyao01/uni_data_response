package com.wx.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author i531869
 * @Date 2020/12/8 20:52
 * @Version 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
public class User {

  @NotNull(message = "用户id不能为空")
  private Integer id;

  @NotNull(message = "用户姓名不能为空")
  @Size(min = 2, max = 20,message = "用户姓名长度必须要2-11个字符")
  private String name;

  @NotNull(message = "年龄不得为空")
  private Integer age;

  @Email
  private String email;
}
