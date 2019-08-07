package com.hk.xia.multithread.sample.test;

import com.hk.xia.multithread.sample.thread.ExThread;
import com.hk.xia.multithread.sample.thread.ImRunable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wang.yubin
 * @date 2019/8/7
 * @description
 */
public class TestThread {

    private static Logger logger = LoggerFactory.getLogger(TestThread.class);

    public static void main(String[] args) {
        logger.info("TestThread Main Method Run ...");
        ExThread exThread = new ExThread();
        ImRunable imRunable = new ImRunable();
        Thread thread = new Thread(imRunable);
        exThread.setPriority(Thread.MIN_PRIORITY);
        thread.setPriority(Thread.MAX_PRIORITY);

        exThread.start();
        thread.start();
    }

}
