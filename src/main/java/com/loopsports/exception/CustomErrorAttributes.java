package com.loopsports.exception;

import com.alibaba.fastjson.JSON;
import com.loopsports.utils.JSONResult;
import com.loopsports.utils.ResultGenerator;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> result =
                super.getErrorAttributes(requestAttributes, includeStackTrace);
        String message = (String) result.get("error");
        int code =(Integer) result.get("status");
        GlobalException ex = new GlobalException(message, code);
        JSONResult packageResult = ResultGenerator.genErrorResult(ex);
        return JSON.parseObject(packageResult.toString(),Map.class);
    }

    @Override
    public Throwable getError(RequestAttributes requestAttributes) {
        return null;
    }
}
