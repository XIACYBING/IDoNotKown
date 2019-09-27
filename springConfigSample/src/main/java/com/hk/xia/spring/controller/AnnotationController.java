package com.hk.xia.spring.controller;

import com.hk.xia.spring.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author wang.yubin
 * @date 2019/9/5
 * @description 使用注解方式配置Controller
 */
@Controller
public class AnnotationController {

    /**
     * 测试注解配置SpringMvc，测试ViewResolver
     * @return 返回一串字符串，通过解析跳转向视图
     */
    @RequestMapping("/annotation")
    public String findAnnotation(){
        System.out.println("find Annotation Controller Method................");
        return "annotation";
    }

    /**
     * 为了测试参数和pojo对象自动映射的一个类
     * @param employee 雇员类
     * @return 返回一串字符串，通过解析器跳转向视图
     */
    @RequestMapping("/employee")
    public String findEmployee(Employee employee){
        System.out.println("employee:" + employee.toString());
        return "annotation";
    }

    /**
     * ModelMap/Model/ModelAndView/Map，大多是为了填充数据，然后返回给前台用的
     * @param model Model，一个数据模型
     * @param modelMap ModelMap，一个数据模型
     * @param modelAndView ModelAndView，一个数据模型
     * @param paramMap Map<String,Object>,一个数据模型
     * @return 返回一串字符串，通过解析器跳转向视图
     */
    @RequestMapping("/model")
    public String userModel(Model model, ModelMap modelMap, ModelAndView modelAndView, Map<String,Object> paramMap){
        model.addAttribute("model","Map!");
        modelMap.addAttribute("modelMap","ModelMap!");
        modelAndView.addObject("modelAndView","ModelAndView!");
        paramMap.put("paramMap","Map<String, Object>");
        System.out.println("ModelMap:" + model.toString());
        return "annotation";
    }

}
