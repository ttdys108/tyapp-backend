package com.ttdys.common.http;

import com.ttdys.common.exception.ErrorCode;
import com.ttdys.common.exception.ServiceException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private String code;
    private String msg;
    private T data;

    private Response() {}

    public static <T> Response<T> of(String code, String msg, T data) {
        Response<T> response = new Response<>();
        response.code = code;
        response.msg = msg;
        response.data = data;
        return response;
    }

    public static <T> Response<T> success() {
        return error(ErrorCode.SUCCESS, null);
    }

    public static <T> Response<T> success(T data) {
        return error(ErrorCode.SUCCESS, data);
    }

    public static <T> Response<T> error(ErrorCode errorCode, T data) {
        return of(errorCode.getCode(), errorCode.getMsg(), data);
    }

    public static <T> Response<T> error(ErrorCode errorCode) {
        return error(errorCode, null);
    }

    public static <T> Response<T> error(ServiceException exception) {
        return of(exception.getCode(), exception.getMsg(), null);
    }

    public static <T> Response<T> error() {
        return error(ErrorCode.SYSTEM_ERROR, null);
    }

    public boolean hasSucceed() {
        return ErrorCode.SUCCESS.getCode().equals(code);
    }

}
