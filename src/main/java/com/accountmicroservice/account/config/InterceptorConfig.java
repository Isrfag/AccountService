package com.accountmicroservice.account.config;

import com.accountmicroservice.account.interceptors.ServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    ServiceInterceptor serviceInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serviceInterceptor).addPathPatterns("/accounts");
    }
}
