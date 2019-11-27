package com.hk.bussiness.develop.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wang.yubin
 * @date 2019/11/25
 * @description
 */
public class ObjectEquals {

    private static final Logger logger = LoggerFactory.getLogger(ObjectEquals.class);

    public static void main(String[] args) {
        ObjectEquals objectEquals = new ObjectEquals();
        ObjectEquals objectEqualsCompare = objectEquals;
        logger.info("objectEquals:[{}]", objectEquals);
        logger.info("objectEqualsCompare:[{}]", objectEqualsCompare);
    }

}
