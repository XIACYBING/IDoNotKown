package com.hk.xia.dubbo.sample.provider;

import com.hk.xia.dubbo.sample.api.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wang.yubin
 * @date 2019/7/19
 * @description 服务提供者提供的方法
 */
public class DubboServiceImpl implements DubboService {

    private static Logger logger = LoggerFactory.getLogger(DubboServiceImpl.class);

    @Override
    public String dubboSayHello(String str) {
        logger.info("dubbosampleprovider.DubboServiceImpl.dubboSayHello()......");
        return "Dubbo Provider Say:" + str;
    }
}
