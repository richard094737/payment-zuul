package com.loopsports.config;

import com.loopsports.filter.WhiteListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public WhiteListFilter whiteListFilter(){
        return new WhiteListFilter();
    }
}
