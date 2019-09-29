package com.hk.xia.spring.config;

import com.hk.xia.spring.pojo.Employee;
import com.hk.xia.spring.pojo.Employer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wang.yubin
 * @date 2019/9/29
 * @description 初始化bean的配置类
 */
@Configuration
public class InitialBeanConfig {

    private static final Logger logger = LoggerFactory.getLogger(InitialBeanConfig.class);

    @Bean
    public Employee employee(Employer employer, ApplicationContext applicationContext){
        logger.info("Employee is Definition");
        this.logBeanNames(applicationContext);
        return new Employee();
    }

    @Bean
    public Employer employer(ApplicationContext applicationContext/*, Employee employee*/){
        logger.info("Employer is Definition");
        this.logBeanNames(applicationContext);
        return new Employer();
    }

    /**
     * 获取到上下文中所有的beanId，并循环输出
     * @param applicationContext 应用上下文
     */
    private void logBeanNames(ApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            logger.info("BeanName is : [{}]", beanName);
        }
    }

}
