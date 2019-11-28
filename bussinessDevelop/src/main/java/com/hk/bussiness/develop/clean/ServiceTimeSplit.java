package com.hk.bussiness.develop.clean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author wang.yubin
 * @date 2019/11/28
 * @description 分割Pro套餐服务时间，并输出
 */
public class ServiceTimeSplit {

    private static final Logger logger = LoggerFactory.getLogger(ServiceTimeSplit.class);

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        /*orderItemId:4346969*/
        String timeString = "1574985600000,1575590400000,1576195200000,1576800000000,1577404800000,1578009600000,1578614400000,1580428800000,1581033600000,1581638400000,1582243200000,1582848000000,1583452800000,1584057600000,1584662400000,1585267200000,1585872000000,1586476800000,1587081600000,1587686400000,1588291200000,1588896000000,1589500800000,1590105600000,1576195200000,1578614400000,1581033600000,1583452800000,1585872000000";
        ServiceTimeSplit.splitPrintTime(timeString);
        /*orderItemId:4346988*/
        String cleanTimeString = "1574985600000,1575590400000,1576195200000,1576800000000,1577404800000,1578009600000,1578614400000,1580428800000,1581033600000,1581638400000,1582243200000,1582848000000,1583452800000,1584057600000,1584662400000,1585267200000,1585872000000,1586476800000,1587081600000,1587686400000,1588291200000,1588896000000,1589500800000,1590105600000";
        ServiceTimeSplit.splitPrintTime(cleanTimeString);
    }

    private static void splitPrintTime(String timeString) {
        String[] serviceTimeArray = timeString.split(",");
        for (String serviceTime : serviceTimeArray) {
            Date serviceTimeDate = new Date(Long.valueOf(serviceTime));
            logger.info("serviceTime:[{}]", serviceTimeDate);
        }
        /*换行隔离*/
        System.out.println("");
    }

}
