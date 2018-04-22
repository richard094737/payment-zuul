package com.loopsports.utils;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200, "success"),//成功

    FAIL(400, "失败"),//失败
    UNAUTHORIZED(401, "未认证（签名错误）"),//未认证（签名错误）
    NOT_FOUND(404, "接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),//服务器内部错误
    TOO_MANY_REQUEST(429, "服务器限制请求"),
    UNAUTHORIZE(999,"未授权"),
    GONE(410, "服务器不在服务状态");



    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
