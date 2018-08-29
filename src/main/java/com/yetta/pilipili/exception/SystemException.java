package com.yetta.pilipili.exception;

/**
 * 系统自定义异常类
 * 抛出预期的异常信息
 */
public class SystemException extends Exception {

    public String message;

    public SystemException(String message){
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
