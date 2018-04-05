package com.loopsports.config;


import com.loopsports.exception.GlobalException;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class RateLimiterErrorHandlerConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(RateLimiterErrorHandlerConfiguration.class);

    @Bean
    public RateLimiterErrorHandler rateLimitErrorHandler() {
        return new DefaultRateLimiterErrorHandler(){
            @Override
            public void handleSaveError(String key, Exception e) {
                logger.info("test1");
                throw  new GlobalException(key);
            }

            @Override
            public void handleFetchError(String key, Exception e) {
                logger.info("test2");
                throw  new GlobalException(key);
            }

            @Override
            public void handleError(String msg, Exception e) {
                 logger.info("test3");
                 throw  new GlobalException(msg);
            }
        };
    }
}
