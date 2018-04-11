package com.loopsports.filter;

import com.loopsports.service.WhiteListService;
import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class WhiteListFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(WhiteListFilter.class);
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
        logger.info("stringkdsjfkdsjfkksjdfkdsjkj");
        whiteListService.saveWhiteList();
        return null;
    }
}
