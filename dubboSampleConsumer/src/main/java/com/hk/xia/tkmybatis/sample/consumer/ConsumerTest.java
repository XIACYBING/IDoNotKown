package com.hk.xia.tkmybatis.sample.consumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hk.xia.dubbo.sample.api.DubboService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
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
public class ConsumerTest {

    private static Logger logger = LoggerFactory.getLogger(ConsumerTest.class);

    public static void main(String[] args) throws IOException {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
        logger.info("Consumer started.");

        DubboService demoService = (DubboService)context.getBean("demoService");
        String hello = demoService.dubboSayHello("pika");
        logger.info(hello);
        /*为了程序不马上关闭*/
        System.in.read();
    }

    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String setResult = jedis.set("Jedis", "testSuccess");
        logger.info("setResult : [{}]", setResult);
        logger.info("Jedis:[{}]", jedis.get("Jedis"));
        Long delResult = jedis.del("Jedis");
        logger.info("delResult:[{}]", delResult);
        jedis.close();
    }

    @Test
    public void testJsonArray(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("experience", "{\"1\":[5,6,7],\"2\":[7,8,9]}");
        String experience = jedis.get("experience");
        logger.info("experience:[{}]", experience);
        JSONObject experienceJson = JSONObject.parseObject(experience);
        logger.info("experienceJson:[{}]", JSONObject.toJSONString(experienceJson));
        JSONArray tagArray = experienceJson.getJSONArray("1");
        logger.info("tagArray:[{}]",JSONObject.toJSONString(tagArray));
        logger.info("tagArray.0:[{}]", tagArray.get(1));
    }

    @Test
    public void testJedisCluster() throws IOException {
        Set<HostAndPort> hapSet = new HashSet<>();
        hapSet.add(new HostAndPort("127.0.0.1",7001));
        hapSet.add(new HostAndPort("127.0.0.1",7002));
        hapSet.add(new HostAndPort("127.0.0.1",7003));
        hapSet.add(new HostAndPort("127.0.0.1",7004));
        hapSet.add(new HostAndPort("127.0.0.1",7005));
        hapSet.add(new HostAndPort("127.0.0.1",7006));
        JedisCluster cluster = new JedisCluster(hapSet);
        cluster.set("cluster","Cluster generator Success");
        String str = cluster.get("cluster");
        logger.info("Cluster:[{}]", str);
        cluster.close();
    }

}
