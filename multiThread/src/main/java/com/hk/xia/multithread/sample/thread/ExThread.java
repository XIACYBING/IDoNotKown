package com.hk.xia.multithread.sample.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wang.yubin
 * @date 2019/8/7
 * @description 继承Thread重写run方法
 */
public class ExThread extends Thread {

    private static Logger logger = LoggerFactory.getLogger(ExThread.class);

    @Override
    public void run(){
        logger.info("ExThread Thread Run...");
    }

}
