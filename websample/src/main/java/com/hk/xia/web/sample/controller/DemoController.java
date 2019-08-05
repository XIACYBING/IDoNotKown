package com.hk.xia.web.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wang.yubin
 * @date 2019/8/5
 * @description
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/sout")
    public void sout(){
        System.out.println("Tomcat is Ok!");
    }

}
