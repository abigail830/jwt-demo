package com.github.abigail830.jwtdemo.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Controller
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public ExceptionResponse handleBizException(BizException bizException) {
        return new ExceptionResponse(bizException.getMessage());
    }
}
