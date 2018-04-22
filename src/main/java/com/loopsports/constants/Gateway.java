package com.loopsports.constants;

public enum Gateway {

    DAIFU(1, "daifu");

    private String msg;
    private int code;


    Gateway(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
