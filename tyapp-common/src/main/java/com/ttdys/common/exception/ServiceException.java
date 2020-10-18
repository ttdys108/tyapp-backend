package com.ttdys.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {
    private String code;
    private String msg;

    public ServiceException() {
        this(ErrorCode.SYSTEM_ERROR);
    }

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }


    public ServiceException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ServiceException(ErrorCode errorCode, String msg) {
        this(errorCode.getCode(), msg);
    }

}
