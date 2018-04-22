package com.loopsports.filter;

import com.loopsports.exception.GlobalException;
import com.loopsports.service.WhiteListService;
import com.loopsports.utils.JSONResult;
import com.loopsports.utils.ResultCode;
import com.loopsports.utils.ResultGenerator;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class DaifuWhiteListFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(DaifuWhiteListFilter.class);

    @Autowired
    WhiteListService whiteListService;

    @Override
    public String filterType() {
        return FilterType.PRE.type();
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        PrintWriter out = null;
        try {
            boolean isAllowedIP = whiteListService.checkDaifuWhiteList(request);
            if (!isAllowedIP) {
                HttpServletResponse response = ctx.getResponse();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                out = response.getWriter();
                GlobalException exception = new GlobalException(
                        ResultCode.UNAUTHORIZE.msg(),
                        ResultCode.UNAUTHORIZE.code()
                );
                JSONResult result = ResultGenerator.genErrorResult(exception);
                out.append(result.toString());
            }
        } catch (Exception e) {

        }finally {
            if (out != null) {
                out.close();
            }
        }

        return null;
    }
}
