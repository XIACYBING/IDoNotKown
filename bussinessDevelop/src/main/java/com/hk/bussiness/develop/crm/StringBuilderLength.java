package com.hk.bussiness.develop.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wang.yubin
 * @date 2019/11/22
 * @description 测试StringBuilder的一些特性
 */
public class StringBuilderLength {

    private static final Logger logger = LoggerFactory.getLogger(StringBuilderLength.class);

    /**
     * 循环次数
     */
    private static final Integer LOOP_TIME = 4;

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < LOOP_TIME; i++) {
            stringBuilder.append(i).append("-");
        }
        logger.info("StringBuilder:[{}]", stringBuilder.toString());
        logger.info("StringBuilder.length:[{}]", stringBuilder.length());
        logger.info("StringBuilder.substring(0, StringBuilder.length() - 1):[{}]", stringBuilder.substring(0, stringBuilder.length() - 1));
    }

}
