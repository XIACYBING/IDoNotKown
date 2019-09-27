package com.hk.xia.dubbo.sample.providerTwo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description
 */
public class ProviderTwo {

    public static void main(String[] args) throws IOException {
        System.setProperty("java.net.preferIPv4stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-provider2.xml"});
        context.start();
        System.out.println("ProviderTwo started.");
        System.in.read();
    }

}
