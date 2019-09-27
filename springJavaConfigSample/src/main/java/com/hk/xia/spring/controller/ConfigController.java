package com.hk.xia.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wang.yubin
 * @date 2019/9/24
 * @description 纯Java配置SpringMVC的控制器测试
 */
@Controller
public class ConfigController {

    @RequestMapping("/start")
    public String start(){
        System.out.println("purity Java Config Success.....");
        return "start";
    }

}
