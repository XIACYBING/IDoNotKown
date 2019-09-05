package com.hk.xia.spring.controller;

import com.hk.xia.spring.pojo.Employee;
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

    /**
     * 为了测试参数和pojo对象自动映射的一个类
     * @param employee
     * @return
     */
    @RequestMapping("/employee")
    public String findEmployee(Employee employee){
        System.out.println("employee:" + employee.toString());
        return "annotation";
    }

}
