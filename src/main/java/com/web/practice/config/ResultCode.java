package com.web.practice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode implements StatusCode{
    SUCCESS(1000,"请求成功"),
    FAILED(1001, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_ERROR(1003,"参数返回失败")
    ;


    private int code;
    private String msg;


}
