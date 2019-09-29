package com.hk.xia.spring.config;

import com.hk.xia.spring.initializer.MvcContextInitializer;
import com.hk.xia.spring.pojo.Employee;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author wang.yubin
 * @date 2019/9/29
 * @description 测试怎么在
 */
@SpringJUnitConfig(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcContextInitializer.class, WebConfig.class, InitialBeanConfig.class}, loader = AnnotationConfigContextLoader.class)
public class InitialBeanConfigTest {

    private static final Logger logger = LoggerFactory.getLogger(InitialBeanConfigTest.class);

    /**
     * 雇员实体类
     */
    @Autowired
    private Employee employee;

    @Test
    public void beanGenerateSequence(){
        logger.info("Eid : [{}]", employee.getEId());
    }

}
