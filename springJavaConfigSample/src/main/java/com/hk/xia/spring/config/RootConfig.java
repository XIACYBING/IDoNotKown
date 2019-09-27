package com.hk.xia.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author wang.yubin
 * @date 2019/9/24
 * @description springContextLoaderListener的自定义实现
 */
@Configuration
@ComponentScan(basePackages = "com.hk.xia.spring" , excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {

}
