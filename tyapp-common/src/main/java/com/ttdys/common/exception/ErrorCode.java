package com.ttdys.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    //0开头表示成功
    SUCCESS("000000", "请求成功"),

    LACK_ARGUMENTS("100000", "缺少请求参数"),

    SYSTEM_ERROR("999999", "系统异常"),



    ;


    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;


}
