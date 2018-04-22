package com.loopsports.exception;


import com.loopsports.utils.JSONResult;
import com.loopsports.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class MyControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

    @ExceptionHandler(value = GlobalException.class)
    public ModelAndView errorHandler(
            HttpServletRequest request,
            HttpServletResponse response,
            GlobalException ex) {

        JSONResult result = ResultGenerator.genErrorResult(ex, request);

        if(!(request.getHeader("accept").contains("application/json")
                ||
                (null != request.getHeader("X-Requested-With")
                && request.getHeader("X-Requested-With").contains("XMLHttpRequest")))){

            ModelAndView mv = new ModelAndView("error");
            mv.addObject("exception", result);
            return mv;
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "application/json");
            try {
                response.getWriter().write(result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @ResponseBody
    @ExceptionHandler(value = GlobalException.class)
    public JSONResult myErrorHandler(HttpServletRequest request, GlobalException ex) {
        return ResultGenerator.genErrorResult(ex, request);
    }
}
