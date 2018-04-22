package com.loopsports.config;

import com.loopsports.filter.DaifuWhiteListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public DaifuWhiteListFilter whiteListFilter(){
        return new DaifuWhiteListFilter();
    }
}
