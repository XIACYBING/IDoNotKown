package com.hk.xia.sample.consumer;

import com.hk.xia.dubbo.sample.api.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description
 */
public class Consumer {

    public static void main(String[] args) throws IOException {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
        System.out.println("Consumer started.");

        DubboService demoService = (DubboService)context.getBean("demoService");
        String hello = demoService.dubboSayHello("pika");
        System.out.println(hello);

        System.in.read();
    }

}
