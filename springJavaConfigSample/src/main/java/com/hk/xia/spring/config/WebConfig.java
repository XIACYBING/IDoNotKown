package com.hk.xia.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author wang.yubin
 * @date 2019/9/24
 * @description SpringDispatcherServlet的自定义实现
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.hk.xia.spring")
public class WebConfig implements WebMvcConfigurer {
    /*WebMvcConfigurerAdapter已过时，替代的方法是它实现的接口WebMvcConfigurer（官方推荐），或者WebMvcConfigurationSupport（需实现所有方法），两者区别不大*/
    @Bean
    public ViewResolver viewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/jsp", ".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer servletHandlerConfigurer){
        servletHandlerConfigurer.enable();
    }

}
