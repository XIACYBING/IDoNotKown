package com.hk.xia.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wang.yubin
 * @date 2019/9/5
 * @description 使用注解方式配置Controller
 */
@Controller
public class AnnotationController {

    @RequestMapping("/annotation")
    public String findAnnotation(){
        System.out.println("find Annotation Controller Method................");
        return "annotation";
    }

}
