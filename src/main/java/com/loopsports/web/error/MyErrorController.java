package com.loopsports.web.error;

import com.loopsports.exception.GlobalException;
import com.loopsports.utils.JSONResult;
import com.loopsports.utils.ResultGenerator;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class MyErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return "";
    }

    /**
     * Supports other formats like JSON, XML
     *
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public JSONResult error(HttpServletRequest request, Exception ex) {
        GlobalException globalException = new GlobalException(ex.getMessage());
        return ResultGenerator.genErrorResult(globalException, request);
    }
}
