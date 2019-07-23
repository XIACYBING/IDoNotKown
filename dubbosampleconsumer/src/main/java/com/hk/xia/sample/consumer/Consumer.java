package com.hk.xia.sample.consumer;

import com.hk.xia.dubbo.sample.api.DubboService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description
 */
public class Consumer {

    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

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

    @Test
    public void testJedis(){
        Jedis jedis = new Jedis();
        jedis.set("Jedis","testSucccess");
        System.out.println("Jedis" + jedis.get("Jedis"));
    }

}
