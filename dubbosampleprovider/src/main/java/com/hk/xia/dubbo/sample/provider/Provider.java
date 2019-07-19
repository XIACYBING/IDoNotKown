package com.hk.xia.dubbo.sample.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description Provider启动类
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-provider.xml"});
        context.start();
        System.out.println("Provider started.");
        System.in.read(); // press any key to exit
    }

}
