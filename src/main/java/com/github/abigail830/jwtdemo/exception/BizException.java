package com.github.abigail830.jwtdemo.exception;

public class BizException extends RuntimeException {

    private String message;

    public BizException(String message) {
        super(message);
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
