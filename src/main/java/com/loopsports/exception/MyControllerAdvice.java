package com.loopsports.exception;


import com.loopsports.utils.JSONResult;
import com.loopsports.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler(value = GlobalException.class)
    public JSONResult myErrorHandler(HttpServletRequest request, GlobalException ex) {
        return ResultGenerator.genErrorResult(ex, request);
    }
}
