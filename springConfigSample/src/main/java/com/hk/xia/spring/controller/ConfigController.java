package com.hk.xia.spring.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wang.yubin
 * @date 2019/8/21
 * @description 使用纯配置方法配置Spring时的控制器
 */
public class ConfigController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("ConfigController Execute...");
        return null;
    }

}
