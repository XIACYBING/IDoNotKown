package com.hk.xia.multithread.sample.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wang.yubin
 * @date 2019/8/7
 * @description 实现Runable重写run方法
 */
public class ImRunable implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(ImRunable.class);

    @Override
    public void run() {
        logger.info("ImRunable Thread Run...");
    }

}
