package com.wx.vo;

import com.wx.data_enum.ResultCodeEnum;
import lombok.Getter;

/**
 * @Author i531869
 * @Date 2020/12/9 17:20
 * @Version 1.0
 */
@Getter
public class ResultVO<T> {
  private Integer code;

  private String msg;

  private T data;

  public ResultVO(T data) {
    this(ResultCodeEnum.SUCCESS, data);
  }

  public ResultVO(ResultCodeEnum resultCodeEnum, T data) {
    this.code = resultCodeEnum.getCode();
    this.msg = resultCodeEnum.getMsg();
    this.data = data;
  }
}
