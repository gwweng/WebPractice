package com.web.practice.config;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler({Exception.class})
    public ResultVo methodParamNotValidExceptionHandler(Exception e){
        if(e instanceof MethodArgumentNotValidException){
            ObjectError objectError = ((MethodArgumentNotValidException)e).getBindingResult().getAllErrors().get(0);
            return new ResultVo(ResultCode.VALIDATE_ERROR, objectError.getDefaultMessage());
        }
        return new ResultVo(ResultCode.VALIDATE_ERROR, e.getMessage());
    }
}
