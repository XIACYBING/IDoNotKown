package com.hk.xia.rocketmq.sample.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author wang.yubin
 * @date 2019/7/26
 * @description RocketMQ的DemoConsumer
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        pushConsumer("127.0.0.1:9876");
    }

    public static void pullConsumer(String nameSrvAddr) throws Exception {
        DefaultMQPullConsumer pullConsumer = new DefaultMQPullConsumer("Demo_pull_consumer");
        pullConsumer.setNamesrvAddr(nameSrvAddr);


        pullConsumer.start();
        System.out.println("Consumer started...");
    }

    public static void pushConsumer(String nameSrvAddr) throws Exception {
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("Demo_push_consumer");
        pushConsumer.setNamesrvAddr(nameSrvAddr);
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        pushConsumer.subscribe("topic_sample_Java","*");

        /*顺序消费*/
        MessageListenerOrderly messageListenerOrderly = new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                if (list != null){
                    for (MessageExt ext : list){
                        try {
                            System.out.println(System.currentTimeMillis() + " : " + new String(ext.getBody(),"UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            System.out.println("ERROR!Error Message is :" + e.getMessage());
                        }
                    }
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        };
        pushConsumer.registerMessageListener(messageListenerOrderly);

        /*并行消费*/
        /*MessageListenerConcurrently messageListener = new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                if (list != null){
                    for (MessageExt ext : list){
                        try {
                            System.out.println(System.currentTimeMillis() + " : " + new String(ext.getBody(),"UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            System.out.println("ERROR!Error Message is :" + e.getMessage());
                        }
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        };
        pushConsumer.registerMessageListener(messageListener);*/

        pushConsumer.start();
        System.out.println("Consumer started...");
    }

}
