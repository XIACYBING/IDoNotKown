package com.hk.xia.tkmybatis.sample.consumer;

import com.hk.xia.dubbo.sample.api.DubboService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("Jedis","testSucccess");
        System.out.println("Jedis" + jedis.get("Jedis"));
        jedis.close();
    }

    @Test
    public void testJedisCluster() throws IOException {
        Set<HostAndPort> hapSet = new HashSet<HostAndPort>();
        hapSet.add(new HostAndPort("127.0.0.1",7001));
        hapSet.add(new HostAndPort("127.0.0.1",7002));
        hapSet.add(new HostAndPort("127.0.0.1",7003));
        hapSet.add(new HostAndPort("127.0.0.1",7004));
        hapSet.add(new HostAndPort("127.0.0.1",7005));
        hapSet.add(new HostAndPort("127.0.0.1",7006));
        JedisCluster cluster = new JedisCluster(hapSet);
        cluster.set("cluster","Cluster generator Success");
        String str = cluster.get("cluster");
        System.out.println("Cluster:" + str);
        cluster.close();
    }

}
