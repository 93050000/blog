package com.zhao.config;

import com.zhao.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    //添加视图管理
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index/").setViewName("index");
        registry.addViewController("/").setViewName("index");

    }
    @Autowired
   private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("login.html");
    }
}
