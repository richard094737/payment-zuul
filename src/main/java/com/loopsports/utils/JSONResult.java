package com.loopsports.utils;

import com.alibaba.fastjson.JSON;

import java.time.Instant;

public class JSONResult {

    /**
     * 统一API响应结果封装
     */

    private int code;
    private String message;
    private Object data;
    private boolean needCached;
    private String url;
    private Instant time;

    public String getUrl() {
        return url;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public JSONResult setMessage(String message) {
        this.message = message;
        return this;
    }


    public JSONResult setCode(int code) {
        this.code = code;
        return this;

    }

    public JSONResult setData(Object data) {
        this.data = data;
        return this;
    }

    public JSONResult setUrl(String url){
        this.url = url;
        return this;
    }

    public boolean isNeedCached() {
        return needCached;
    }

    public void setNeedCached(boolean needCached) {
        this.needCached = needCached;
    }

    public JSONResult(){}

    /**
     *
     * @param code 返回码
     * @param message 信息
     * @param data 数据
     */
    public JSONResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }
}
