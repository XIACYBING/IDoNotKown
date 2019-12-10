package com.hk.bussiness.develop.clean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wang.yubin
 * @date 2019/11/29
 * @description 格式化日期的实验
 */
public class DateFormat {

    private static final Logger logger = LoggerFactory.getLogger(DateFormat.class);

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        System.out.println(calendar.getTime());
    }

}
