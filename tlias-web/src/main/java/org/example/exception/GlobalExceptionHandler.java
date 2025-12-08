package org.example.exception;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器类
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
    public Result handleException(Exception e) {
        return Result.error("出错了，请联系管理员~");
    }
}