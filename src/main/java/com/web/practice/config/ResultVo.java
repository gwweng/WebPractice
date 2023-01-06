package com.web.practice.config;

import lombok.Data;

@Data
public class ResultVo {

    private int code;

    private String msg;

    private Object data;

    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 默认返回成功状态
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 指定返回状态码
    public ResultVo(StatusCode code, Object data){
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public ResultVo(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }
}
