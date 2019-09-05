package com.hk.xia.spring.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author wang.yubin
 * @date 2019/9/3
 * @description 测试@PostConstruct和@PreDestroy注解的一个Servlet
 */
public class ConstructServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ConstructServlet.class);

    @PostConstruct
    public void preInit(){
        logger.info("@PostConstruct preInit ConstructServlet.............");
    }

    @Override
    public void init() throws ServletException {
        logger.info("ConstructServlet init..........................................");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("ConstructServlet service.........................................");
    }

    @Override
    public void destroy() {
        logger.info("ConstructServlet destroy............................");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("@PreConstruct preDestroy ConstructServlet.............");
    }

}
