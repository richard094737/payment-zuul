package com.loopsports.filter;

import com.loopsports.service.WhiteListService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherWhiteListFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(OtherWhiteListFilter.class);

    @Autowired
    WhiteListService whiteListService;

    @Override
    public String filterType() {
        return FilterType.PRE.type() ;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        return null;
    }
}
