package com.hk.xia.rocketmq.sample.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.Date;

/**
 * @author wang.yubin
 * @date 2019/7/26
 * @description RocketMQ的DemoProducer
 */
public class Producer {

    private static final int PRODUCE_NUMBER = 100;

    public static void main(String[] args) throws Exception {
        /*创建消息生产者，并制定生产者群组名*/
        DefaultMQProducer producer = new DefaultMQProducer("Demo_producer");
        /*指定NameServer地址*/
        producer.setNamesrvAddr("localhost:9876");
        /*启动生产者*/
        producer.start();
        System.out.println("Producer started...");
        /*发送结果类*/
        SendResult sendResult;
        /*指定消息要发送到的队列*/
        MessageQueue queue = new MessageQueue("topic_sample_Java","HKSERVER-PC",0);
        for (int i=0; i<PRODUCE_NUMBER; i++){
            /*消息类，三个参数分别是topic、tag和body，topic可以看成消息的一级分类，tag是二级分类，body是消息实体*/
            Message message = new Message("topic_sample_Java","TagA",(new Date() + "Hello RocketMQ Double Sample : "+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            sendResult = producer.send(message,queue);
            System.out.println(new Date() + ":" + i);
            /*输出发送结果*/
            System.out.println(sendResult.toString());
        }
        System.out.println("Producer stoping...");
        producer.shutdown();
    }

}
