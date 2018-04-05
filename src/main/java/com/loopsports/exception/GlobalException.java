package com.loopsports.exception;


public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = -5701182284190108797L;

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
