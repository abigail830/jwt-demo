package com.github.abigail830.jwtdemo.exception;

public class ExceptionResponse {

    String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
