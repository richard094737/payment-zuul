package com.loopsports.exception;


public class GlobalException extends RuntimeException {

    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public GlobalException() {}

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, int code) {
        super(message);
        this.code = code;
    }
}
