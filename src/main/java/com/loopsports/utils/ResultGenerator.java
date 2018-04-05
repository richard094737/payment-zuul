package com.loopsports.utils;

import com.loopsports.exception.GlobalException;
import sun.reflect.annotation.ExceptionProxy;

import javax.servlet.http.HttpServletRequest;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /***
     *
     * @return
     */
    public static JSONResult genSuccessResult() {
        return new JSONResult()
                .setCode(ResultCode.SUCCESS.code())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData("");
    }

    /***
     *
     * @param data
     * @return
     */
    public static JSONResult genSuccessResult(Object data) {
        return new JSONResult()
                .setCode(ResultCode.SUCCESS.code())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /***
     *
     * @param exception
     * @return
     */
    public static JSONResult genErrorResult(GlobalException exception){
        return new JSONResult()
                .setCode(exception.getCode())
                .setMessage(exception.getMessage())
                .setData("");
    }

    /***
     *
     * @param exception
     * @return
     */
    public static JSONResult genErrorResult(GlobalException exception, HttpServletRequest request){
        return new JSONResult()
                .setCode(exception.getCode())
                .setMessage(exception.getMessage())
                .setData("")
                .setUrl(request.getRequestURL().toString());
    }
}
