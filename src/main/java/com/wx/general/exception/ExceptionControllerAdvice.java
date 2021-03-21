package com.wx.general.exception;

import com.wx.data_enum.ResultCodeEnum;
import com.wx.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author i531869
 * @Date 2020/12/9 17:02
 * @Version 1.0
 */
@RestControllerAdvice(basePackages = "com.wx.controller")
public class ExceptionControllerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
    ObjectError error = exception.getAllErrors().get(0);
    return new ResultVO<>(ResultCodeEnum.VALIDATE_FAILED, error.getDefaultMessage());
  }

  /**
   * 自定义异常
   *
   * @param apiException
   * @return
   */
  @ExceptionHandler(ApiException.class)
  public ResultVO<String> ApiExceptionHandler(ApiException apiException) {
    return new ResultVO<>(ResultCodeEnum.FAILED, apiException.getMsg());
  }
}
