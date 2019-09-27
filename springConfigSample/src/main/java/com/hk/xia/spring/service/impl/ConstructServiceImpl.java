package com.hk.xia.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
/**
 * @author wang.yubin
 * @date 2019/9/3
 * @description 测试@PostConstruct和@PreDestroy是否对普通方法有用
 */
public class ConstructServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ConstructServiceImpl.class);

    @PostConstruct
    public void preInit(){
        logger.info("@PostConstruct preInit ConstructServlet.............");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("@PreConstruct preDestroy ConstructServlet.............");
    }

}
